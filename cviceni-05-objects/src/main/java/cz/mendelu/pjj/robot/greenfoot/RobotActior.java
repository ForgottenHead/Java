package cz.mendelu.pjj.robot.greenfoot;

import cz.mendelu.pjj.robot.Coordinate;
import cz.mendelu.pjj.robot.Direction;
import cz.mendelu.pjj.robot.Robot;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.logging.Logger;

import static java.lang.String.format;

public class RobotActior extends Actor {

    private static Logger log = Logger.getGlobal();

    private static final String IMAGE_PATTERN = "images/%s.png";

    private final Robot robot;

    public RobotActior(Robot robot) {
        this.robot = robot;
        this.update();
    }

    @Override
    public void act() {
        String key = Greenfoot.getKey();
        if (key != null) {
            switch (key) {
                case "left":
                    robot.turnLeft();
                    log.info(format("Robot turn left to %s", robot.getDirectionName()));
                    break;
                case "right":
                    robot.turnRight();
                    log.info(format("Robot turn right to %s", robot.getDirectionName()));
                    break;
                case "up":
                    robot.forward();
                    log.info(format("Robot move forward to %s", robot.getPosition()));
                    break;
            }
        }
        this.update();
    }

    private void update() {
        setImage(format(IMAGE_PATTERN, robot.getDirectionName()));
        Coordinate coordinate = robot.getPosition();
        setLocation(coordinate.x, coordinate.y);
    }


}