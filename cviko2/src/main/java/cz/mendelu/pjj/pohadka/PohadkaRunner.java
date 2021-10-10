package cz.mendelu.pjj.pohadka;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.pohadka.greenfoot.BattleField;

/**
 * A sample runner for a greenfoot project.
 */
public class PohadkaRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(PohadkaRunner.class,
                // 3. Prepare the configuration for the runner based on the world class
                Configuration.forWorld(BattleField.class)
                        // Set the project name as you wish
                        .projectName("Rytieri, hraniciari a drak")
                        .hideControls(true)
        );
    }

    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}