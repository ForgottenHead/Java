package cz.mendelu.pjj.witcher;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.witcher.greenfoot.WitcherWorld;

public class Runner extends GreenfootRunner {

    public static void main(String[] args) {
        bootstrap(Runner.class,
                Configuration.forWorld(WitcherWorld.class)
                        .projectName("Witcher")
                        .hideControls(true)
        );
        GreenfootRunner.main(args);
    }
}
