package cz.mendelu.pjj.poskvorkty.greenfoot;

import cz.mendelu.pjj.poskvorkty.Linie;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class LinieActorGroup {

    private final Linie linie;

    public LinieActorGroup(Linie linie, World world) {
        this.linie = linie;

        var gi = new GreenfootImage(PiskvorkyWorld.CELL_SIZE, PiskvorkyWorld.CELL_SIZE);
        gi.fillOval(PiskvorkyWorld.CELL_SIZE / 4, PiskvorkyWorld.CELL_SIZE / 4, PiskvorkyWorld.CELL_SIZE / 2, PiskvorkyWorld.CELL_SIZE / 2);

        for (var ct : linie) {
            var pa = new PartActor();
            pa.setImage(gi);
            world.addObject(pa, ct.x, ct.y);
        }
    }

    public static class PartActor extends Actor {
    }

}
