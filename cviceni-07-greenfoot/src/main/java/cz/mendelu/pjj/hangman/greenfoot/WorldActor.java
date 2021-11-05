package cz.mendelu.pjj.hangman.greenfoot;

import cz.mendelu.pjj.hangman.Hangman;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.util.Objects;

public class WorldActor extends Actor {

    private final Hangman hangman;

    private String word;

    public WorldActor(Hangman hangman) {
        this.hangman = hangman;
        this.update();
    }

    @Override
    public void act() {
        if (!Objects.equals(word, hangman.coveredWord())) {
            update();
        }
    }

    private void update() {
        word = hangman.coveredWord();
        var image = new GreenfootImage(" " + word, 48, Color.BLACK, Color.WHITE);
        setImage(image);
    }
}
