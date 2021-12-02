package cz.mendelu.pjj.witcher;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * This special collection represents deck of card.
 *
 * <p>It can keep cards, add new Cards at the top, shuffle them and draw Card from th top.
 */
public class Deck<T extends Card>{

    private Random random = new Random();
    private List<T> cards = new LinkedList<>();

    /**
     * Add new cards at the top of the deck.
     * @param cards
     */
    public void addCards(T ... cards) {
        // TODO implemented in task 2.

        this.cards.addAll(Arrays.asList(cards));
    }

    /**
     * Shuffle all card in the deck.
     */
    public void shuffle() {
        // TODO implemented in task 2.
        Collections.shuffle(cards);
    }

    /**
     * Draw the card from the top of these deck.
     * @return
     */
    public T drawCard() {
        // TODO implemented in task 2.
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return false;
    }
}
