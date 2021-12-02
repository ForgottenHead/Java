package cz.mendelu.pjj.poskvorkty.greenfoot;

import cz.mendelu.pjj.poskvorkty.Barva;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;

public class ZnackaActor extends Actor {

    public ZnackaActor(Barva barva){
        switch (barva) {
            case RED:
                setImage(new GreenfootImage("X", 30, Color.RED, null));
                break;
            case BLUE:
                setImage(new GreenfootImage("O", 30, Color.BLUE, null));
                break;
        }


    }
}
