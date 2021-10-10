package cz.mendelu.pjj.pohadka.greenfoot;

import cz.mendelu.pjj.pohadka.domain.Hranicar;
import cz.mendelu.pjj.pohadka.domain.Rytir;
import greenfoot.Actor;
import greenfoot.World;

import java.util.Random;

public class BattleField extends World {
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 80x80 pixels
     */
    public BattleField() {
        super(8, 8, 80);
        setBackground("grass.png");

        addObject(new RPGActor(new Rytir(15, 5)), 2, 4);
        addObject(new RPGActor(new Hranicar(15, 3)), 6, 4);
        addObject(new RPGActor(new Rytir(22, 10)), 6, 7);
        addObject(new RPGActor(new Hranicar(10, 15)), 2, 7);
        addObject(new RPGActor(), 4,1);

        Random random = new Random();
        int treeCount = 0;
        while (treeCount < 6) {
            int x = random.nextInt(8);
            int y = random.nextInt(8);
            boolean empty = getObjectsAt(x, y, Actor.class).isEmpty();
            if (empty) {
                addObject(new Tree(), x, y);
                treeCount++;
            }
        }
    }
}