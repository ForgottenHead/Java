package cz.mendelu.pjj.witcher;

import java.util.ArrayList;
import java.util.List;

/**
 * This is one game, it is control it and monitor.
 *
 * <p>It is basically keep both decks and all players.
 */
public class Game {

    public static final int ATTACK_CARDS = 4;
    public static final int MONSTER_CARDS = 3;

    private final Deck<AttackCard> attackDeck = new Deck();
    private final Deck<MonsterCard> monsterDeck = new Deck();
    private final List<Player> players = new ArrayList();
    private int currentPlayerIndex = -1;

    /**
     * Pro vytvoření hry je nutné mís seznam hračů.
     * <p>
     * Každý hrác dostane dvě karty do začátku.
     *
     * @param players
     */
    public Game(Player... players) {
        this.attackDeck.addCards(AttackCard.CARDS);
        this.attackDeck.shuffle();

        this.monsterDeck.addCards(MonsterCard.MONSTERS);
        this.monsterDeck.shuffle();

        for (Player player : players) {
            // TODO Remove cast
            player.addAttackCard(attackDeck.drawCard());
            // TODO Remove cast
            player.addAttackCard(attackDeck.drawCard());
            this.players.add(player);
        }
    }

    /**
     * Metoda vrátí dalšího hráče v pořadí.
     *
     * @return
     */
    public Player nextPLayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        // TODO Remove cast
        return players.get(currentPlayerIndex);
    }

    /**
     * Metoda vrací true, pokud aktuální hráč je poslední v kole.
     *
     * @return
     */
    public boolean isEndOfTurn() {
        return (players.size() - currentPlayerIndex) == 1;
    }

    public Deck getAttackDeck() {
        return attackDeck;
    }

    public Deck getMonsterDeck() {
        return monsterDeck;
    }
}
