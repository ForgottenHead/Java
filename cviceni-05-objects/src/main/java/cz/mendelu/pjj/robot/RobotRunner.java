package cz.mendelu.pjj.robot;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.robot.greenfoot.RobotWorld;

/**
 * A sample runner for a greenfoot project.
 */
public class RobotRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(RobotRunner.class,
                // 3. Prepare the configuration for the runner based on the world class
                Configuration.forWorld(RobotWorld.class)
                        // Set the project name as you wish
                        .projectName("Robot project")
                        .hideControls(true)
        );
    }
    
    public static void main(String[] args) {
		GreenfootRunner.main(args);
	}
}