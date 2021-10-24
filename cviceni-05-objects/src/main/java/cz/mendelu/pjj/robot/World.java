package cz.mendelu.pjj.robot;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Honza on 08.11.2016.
 */
public class World {

    private final int width;
    private final int height;
    //private Object[][] map;
    private final Map map;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        //this.map = new Object[width][height];
        this.map = new HashMap();
    }

    public Object getTreasureAt(int x, int y){
        // FIXME Upravit v samostatné práci
        //if (x < 0) {
        //    return null;
        //} else if (x >= width) {
        //    return null;
        //} else if (y < 0) {
        //    return null;
        //} else if (y >= height) {
        //    return null;
        //} else {
        //    return map[x][y];
        //}
        return map.get(new Coordinate(x, y));
    }

    public void removeTreasureAt(int x, int y){
        // FIXME Upravit v samostatné práci
//        if (x >= 0 && x < width && y >= 0 && y < height) {
//            map[x][y] = null;
//        }
        map.remove(new Coordinate(x, y));
    }

    public Object addTreasureAt(Object object, int x, int y){
        // FIXME Upravit v samostatné práci
        map.put(new Coordinate(x, y), object);
        return object;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CoordinateBuilder coordinateBuilder() {
        return new CoordinateBuilder() {
            @Override
            public Coordinate of(int x, int y) {
                return null;
            }
        };
    }
}
