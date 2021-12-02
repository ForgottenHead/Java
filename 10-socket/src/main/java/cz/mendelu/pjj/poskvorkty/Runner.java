package cz.mendelu.pjj.poskvorkty;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.poskvorkty.greenfoot.PiskvorkyWorld;

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
