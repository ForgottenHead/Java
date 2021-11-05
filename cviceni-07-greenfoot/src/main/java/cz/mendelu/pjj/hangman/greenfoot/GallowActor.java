package cz.mendelu.pjj.hangman.greenfoot;

import cz.mendelu.pjj.hangman.Hangman;
import cz.mendelu.pjj.hangman.PictureBuilder;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class GallowActor extends Actor {
    private final Hangman hangman;

    private int missed = -1;

    public GallowActor(Hangman hangman) {
        this.hangman = hangman;
        this.update();
    }

    @Override
    public void act() {
        update();
    }

    public void update() {
        if (missed != hangman.getMissed()) {
            missed = hangman.getMissed();
            this.setImage(String.format("images/gallow/%d.PNG", missed));
        }
    }
}
