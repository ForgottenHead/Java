package cz.mendelu.pjj.robot.greenfoot;

import greenfoot.Actor;

public class CheckActor extends Actor {

    private int ttl = 80;

    public CheckActor() {
        setImage("images/check.png");
    }

    @Override
    public void act() {
        if ((ttl--) < 10) {
            getWorld().removeObject(this);
        } else if (ttl < 64) {
            getImage().scale(ttl, ttl);
        }
    }
}
