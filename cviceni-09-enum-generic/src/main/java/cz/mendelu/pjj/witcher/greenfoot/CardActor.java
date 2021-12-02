package cz.mendelu.pjj.witcher.greenfoot;

import cz.mendelu.pjj.witcher.AttackCard;
import cz.mendelu.pjj.witcher.Card;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.Optional;
import java.util.function.Consumer;

import static java.lang.String.format;

class CardActor extends Actor {

    private Card card;
    private Consumer action;

    public CardActor() {
        setNoCard();
    }

    public CardActor(Card card) {
        setCard(card);
    }

    public void setCard(Card card) {
        this.card = card;

        var image = new GreenfootImage(WitcherWorld.CARD_FOLDER + card.getName() + ".png");
        image.scale(WitcherWorld.CARD_WIDTH, WitcherWorld.CARD_HEIGHT);

        this.setImage(image);
    }

    public void setNoCard() {
        this.card = null;

        var image = new GreenfootImage(WitcherWorld.CARD_FOLDER + "no_card.png");
        image.scale(WitcherWorld.CARD_WIDTH, WitcherWorld.CARD_HEIGHT);

        this.setImage(image);
    }

    public Optional<Card> getCard() {
        return Optional.ofNullable(card);
    }

    public void setAction(Consumer action) {
        this.action = action;
    }

    @Override
    public void act() {
        if (action != null && card != null && Greenfoot.mouseClicked(this)) {
            action.accept(card);
        }
    }
}
