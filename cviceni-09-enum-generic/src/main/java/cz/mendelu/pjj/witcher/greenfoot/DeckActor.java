package cz.mendelu.pjj.witcher.greenfoot;

import cz.mendelu.pjj.witcher.Deck;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.function.Consumer;

class DeckActor extends Actor {

    private final String name;
    private final Deck deck;

    private Consumer action;

    public DeckActor(String name, Deck deck) {
        this.deck = deck;
        this.name = name;
        this.update();
    }

    public void setAction(Consumer action) {
        this.action = action;
    }

    @Override
    public void act() {
        if (action != null && Greenfoot.mouseClicked(this)) {
            action.accept(deck.drawCard());
            update();
        }
    }

    public void update() {
        var imageName = WitcherWorld.CARD_FOLDER + ((deck.isEmpty()) ? "no_card.png" : name + ".png");
        var image = new GreenfootImage(imageName);
        image.scale(WitcherWorld.CARD_WIDTH, WitcherWorld.CARD_HEIGHT);
        setImage(image);
    }
}
