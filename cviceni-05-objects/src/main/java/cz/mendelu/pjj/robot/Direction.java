package cz.mendelu.pjj.robot;

/**
 * Created by Honza on 09.11.2016.
 */
public abstract class Direction {

    public static final Direction NORTH = new Direction("north"){
        @Override
        public Direction onLeft() {
            return WEST;
        }

        @Override
        public Direction onRight() {
            return EAST;
        }

        @Override
        public Coordinate forwardFrom(Coordinate coordinate) {
            return new Coordinate(coordinate.x, coordinate.y -1);
        }
    };
    public static final Direction EAST = new Direction("east"){
        @Override
        public Direction onLeft() {
            return NORTH;
        }

        @Override
        public Direction onRight() {
            return SOUTH;
        }

        @Override
        public Coordinate forwardFrom(Coordinate coordinate) {
            return new Coordinate(coordinate.x +1, coordinate.y);
        }
    };
    public static final Direction SOUTH = new Direction("south"){
        @Override
        public Direction onLeft() {
            return EAST;
        }

        @Override
        public Direction onRight() {
            return WEST;
        }

        @Override
        public Coordinate forwardFrom(Coordinate coordinate) {
            return new Coordinate(coordinate.x, coordinate.y +1);
        }
    };
    public static final Direction WEST = new Direction("west"){
        @Override
        public Direction onLeft() {
            return SOUTH;
        }

        @Override
        public Direction onRight() {
            return NORTH;
        }

        @Override
        public Coordinate forwardFrom(Coordinate coordinate) {
            return new Coordinate(coordinate.x -1, coordinate.y);
        }
    };

    private final String name;

    private Direction(String name) {
        this.name = name;
    }

    public abstract Direction onLeft();
    public abstract Direction onRight();

    public String getName() {
        return name;
    }

    public abstract Coordinate forwardFrom(Coordinate coordinate);
}
