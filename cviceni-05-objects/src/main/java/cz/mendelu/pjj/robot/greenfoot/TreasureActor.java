package cz.mendelu.pjj.robot.greenfoot;

import greenfoot.Actor;

public class TreasureActor extends Actor {

    private final Object treasure;

    public TreasureActor(Object treasure) {
        this.treasure = treasure;
        this.setImage("images/treasure.png");
        this.getImage().drawString(treasure.toString(), 5,60);
    }

    public Object getTreasure() {
        return treasure;
    }
}
