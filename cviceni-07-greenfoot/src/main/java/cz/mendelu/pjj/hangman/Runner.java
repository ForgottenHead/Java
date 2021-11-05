package cz.mendelu.pjj.hangman;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.hangman.greenfoot.HangmanWorld;

public class Runner extends GreenfootRunner {
    static {
        bootstrap(Runner.class,
               Configuration.forWorld(HangmanWorld.class)
                    .projectName("Hangman")
                    .hideControls(true)
        );
    }

    public static void main(String[] args) {

        GreenfootRunner.main(args);
    }
}
