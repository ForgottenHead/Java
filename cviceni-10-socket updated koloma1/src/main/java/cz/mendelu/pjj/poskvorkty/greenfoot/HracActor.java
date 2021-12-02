package cz.mendelu.pjj.poskvorkty.greenfoot;

import cz.mendelu.pjj.poskvorkty.Hrac;
import cz.mendelu.pjj.poskvorkty.Piskvorky;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class HracActor extends Actor {

    private final Piskvorky piskvorky;
    private Hrac lastView;

    public HracActor(Piskvorky piskvorky) {
        this.piskvorky = piskvorky;
        this.update();
    }

    private void update() {
        lastView = piskvorky.getHracTahu();
        setImage(new GreenfootImage("Na tahu je " + lastView, 24, Color.BLACK, Color.LIGHT_GRAY));
    }

    @Override
    public void act() {
        if (lastView != piskvorky.getHracTahu()) {
            update();
        }
    }
}
