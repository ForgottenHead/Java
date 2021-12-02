package cz.mendelu.pjj.poskvorkty.greenfoot;

import bh.greenfoot.runner.GreenfootRunner;

public class Runner extends GreenfootRunner {

    public static void main(String[] args) {
        bootstrap(Runner.class,
                Configuration.forWorld(PiskvorkyWorld.class)
                        .projectName("Piskvorky")
                        .hideControls(true)
        );
        GreenfootRunner.main(args);
    }
}
