package cz.mendelu.pjj.hangman.greenfoot;

import cz.mendelu.pjj.hangman.Hangman;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

public class LetterActor extends Actor {

    private final Hangman hangman;
    private int index;

    public LetterActor(Hangman hangman, int index) {
        this.hangman = hangman;
        this.index = index;
        this.update();
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            String letter = hangman.getLetter(index);
            if (!hangman.guessLetter(letter)) {
                hangman.hangmanAsciiArt();
            }
            update();
        }
    }

    public void update() {
        var available = hangman.isAvailable(index);
        var image = (available)
                ? new GreenfootImage(hangman.getLetter(index), 32, Color.BLACK, Color.WHITE)
                : new GreenfootImage("_", 32, Color.BLACK, Color.WHITE);
        setImage(image);
    }

}
