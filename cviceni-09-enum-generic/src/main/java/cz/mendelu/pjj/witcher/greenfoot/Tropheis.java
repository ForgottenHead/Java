package cz.mendelu.pjj.witcher.greenfoot;

import cz.mendelu.pjj.witcher.Card;

import java.util.LinkedList;
import java.util.List;

public class Tropheis {

    private final WitcherWorld world;
    private final List cards = new LinkedList();

    public Tropheis(WitcherWorld world) {
        this.world = world;
    }

    public void setTrophies(List trophies) {
        world.removeObjects(cards);

        for (int i = trophies.size(); i > 0; i--) {
            var tca = new CardActor((Card) trophies.get(i - 1));
            world.addObject(tca, world.getWidth() - WitcherWorld.CARD_WIDTH, (int) (world.getHeight() - ((i+1.5f) * WitcherWorld.CARD_HEIGHT / 3)));
            cards.add(tca);
        }
    }
}
