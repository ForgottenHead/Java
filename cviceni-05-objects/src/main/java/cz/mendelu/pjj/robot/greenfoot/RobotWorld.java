package cz.mendelu.pjj.robot.greenfoot;

import cz.mendelu.pjj.robot.Coordinate;
import cz.mendelu.pjj.robot.Direction;
import cz.mendelu.pjj.robot.Robot;
import cz.mendelu.pjj.robot.World;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.format;

public class RobotWorld extends greenfoot.World {

    private static Logger log = Logger.getGlobal();

    private static final int WORLD_SIZE = 7;
    private static final int WORLD_CELL = 64;

    private final Robot robot;
    private final World world;

    public RobotWorld() {
        this(new World(WORLD_SIZE, WORLD_SIZE),
                new Robot(3, 0, Direction.SOUTH));

    }

    public RobotWorld(World world, Robot robot) {
        super(world.getWidth(), world.getHeight(), WORLD_CELL);
        this.robot = robot;
        this.world = world;

        setBackground("images/world-background.png");
        addObject(new RobotActior(robot), 0, 0);
        update();
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null && mouseInfo.getClickCount() == 1 && mouseInfo.getActor() == null) {
            String name = Greenfoot.ask("Vlož jméno pokladu: ");
            Object treasure = world.addTreasureAt(name, mouseInfo.getX(), mouseInfo.getY());
            log.info(String.format("Add Treasure at [%d, %d] name: %s.", mouseInfo.getX(), mouseInfo.getY(), treasure));
        }

        Coordinate coordinate = robot.getPosition();
        Object treasure = world.getTreasureAt(coordinate.x,coordinate.y);
        if (treasure != null) {
            log.info(format("Robot found treasure %s.", treasure.toString()));
            world.removeTreasureAt(coordinate.x, coordinate.y);
            this.addObject(new CheckActor(), coordinate.x, coordinate.y);
        }

        update();
    }

    private void update() {
        // Update treasurers
        List<TreasureActor> treasureActors = getObjects(TreasureActor.class);
        for(int x = 0; x < world.getWidth(); x++) {
            for(int y = 0; y < world.getHeight(); y++) {
                Object treasure = world.getTreasureAt(x, y);
                if (treasure != null) {
                    TreasureActor actor = remove(treasureActors, treasure);
                    if (actor == null) {
                        addObject(new TreasureActor(treasure), x, y);
                    }
                }
            }
        }
        removeObjects(treasureActors);

    }

    private static TreasureActor remove(List<TreasureActor> treasureActors, Object treasure) {
        Iterator<TreasureActor> iterator = treasureActors.iterator();
        while (iterator.hasNext()) {
            TreasureActor actor = iterator.next();
            if (actor.getTreasure().equals(treasure)) {
                iterator.remove();
                return actor;
            }
        }
        return null;
    }
}