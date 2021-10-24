package cz.mendelu.pjj.robot;

import cz.mendelu.pjj.robot.Coordinate;

public interface CoordinateBuilder {

    Coordinate of(int x, int y);
}
