package cz.mendelu.pjj.robot;

/**
 * Created by Honza on 08.11.2016.
 */
public class Robot {

    private Coordinate coordinate;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        //this.x = x;
        //this.y = y;
        this.coordinate = new Coordinate(x, y);
        this.direction = direction;
    }

    public void forward() {
        // FIXME Upravit v samostatné práci
        /*
        switch (direction) {
            case Direction.NORTH:
                y -= 1;
                break;
            case Direction.SOUTH:
                y += 1;
                break;
            case Direction.EAST:
                x += 1;
                break;
            case Direction.WEST:
                x -=1;
                break;
        }
         */
        coordinate = direction.forwardFrom(coordinate);
    }

    public void turnLeft() {
        // FIXME Upravit v samostatné práci
        //switch (direction) {
        // case Direction.NORTH:
        // direction = Direction.WEST;
        // break;
        // case Direction.SOUTH:
        // direction = Direction.EAST;
        // break;
        // case Direction.EAST:
        // direction = Direction.NORTH;
        // break;
        // case Direction.WEST:
        // direction = Direction.SOUTH;
        // break;
        //}
        direction = direction.onLeft();
    }

    public void turnRight() {
        // FIXME Upravit v samostatné práci
        /*
        switch (direction) {
            case Direction.NORTH:
                direction = Direction.EAST;
                break;
            case Direction.SOUTH:
                direction = Direction.WEST;
                break;
            case Direction.EAST:
                direction = Direction.SOUTH;
                break;
            case Direction.WEST:
                direction = Direction.NORTH;
                break;
        }

         */
        direction = direction.onRight();
    }

    public Coordinate getPosition() {
        //return new Coordinate(x, y);
        return coordinate;
    }

    public String getDirectionName() {
        //switch (direction) {
        // case Direction.NORTH:
        // return "north";
        // case Direction.SOUTH:
        // return "south";
        // case Direction.EAST:
        // return "east";
        // case Direction.WEST:
        // return "west";
        //}
        //throw new IllegalArgumentException();
        return direction.getName();
    }



}
