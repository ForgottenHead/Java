package cz.mendelu.pjj.witcher.greenfoot;

import cz.mendelu.pjj.witcher.AttackCard;
import cz.mendelu.pjj.witcher.Player;
import greenfoot.World;

import java.util.LinkedList;
import java.util.List;

class InHand {

    private final World world;
    private final List<CardActor> attackCardActors = new LinkedList<>();

    private Player player;

    public InHand(World world) {
        this.world = world;
    }

    public void setPlayer(Player player) {
        this.player = player;
        update();
    }

    public void update() {
        for (CardActor aca : attackCardActors) {
            world.removeObject(aca);
        }

        attackCardActors.clear();

        List inHand = player.inHand();
        for (int i = 0, inHandSize = inHand.size(); i < inHandSize; i++) {
            var ac = (AttackCard) inHand.get(i);
            var aca = new CardActor(ac);
            world.addObject(aca, WitcherWorld.CARD_WIDTH + (i * (WitcherWorld.CARD_WIDTH / 2)), WitcherWorld.CARD_HEIGHT * 3 + WitcherWorld.CARD_SPACE);
            attackCardActors.add(aca);
        }
    }

}
