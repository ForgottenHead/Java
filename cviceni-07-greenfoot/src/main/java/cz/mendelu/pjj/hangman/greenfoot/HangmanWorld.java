package cz.mendelu.pjj.hangman.greenfoot;

import cz.mendelu.pjj.hangman.Hangman;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class HangmanWorld extends World {

    private final Hangman hangman = Hangman.createNewGame();

    public HangmanWorld() {
        super(800, 600, 1);
        setBackground("images/papire.jpg");

        addObject(new WorldActor(hangman), 400, 400);

        for (int i = 0; i < 26; i++) {
            addObject(new LetterActor(hangman, i), 30 + (i * 30), 500);
        }

        addObject(new GallowsActor(hangman), 400, 200);
    }
}
