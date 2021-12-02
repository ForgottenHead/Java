package cz.mendelu.pjj.poskvorkty.greenfoot;

import cz.mendelu.pjj.poskvorkty.Hrac;
import greenfoot.Actor;

public class ZnackaActor extends Actor {

    private static final String ICON_PATTERN = "images/%s.png";

    public ZnackaActor(Hrac hrac) {
        setImage(String.format(ICON_PATTERN, hrac));
    }
}
