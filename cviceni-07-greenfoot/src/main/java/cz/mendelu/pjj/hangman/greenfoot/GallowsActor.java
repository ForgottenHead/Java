package cz.mendelu.pjj.hangman.greenfoot;

import cz.mendelu.pjj.hangman.Hangman;
import greenfoot.Actor;

public class GallowsActor extends Actor {

    private final Hangman hangman;
    private int missed = -1;

    public GallowsActor(Hangman hangman) {
        this.hangman = hangman;
        this.act();
    }

    public void act(){
        if (missed != hangman.getMissed()){
            missed = hangman.getMissed();
            this.setImage(String.format("images/man%d.png"), missed));
        }
    }
}
