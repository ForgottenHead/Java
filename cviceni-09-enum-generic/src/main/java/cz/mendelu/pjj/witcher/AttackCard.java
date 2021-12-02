package cz.mendelu.pjj.witcher;

import java.util.List;

/**
 * The cards from this deck represent the four witcher fighting styles.
 *
 * <p>They are divided into: <b>Steel Sword Attacks</b>, <b>Silver Sword Attacks</b>, <b>Potions</b> and <b>Signs</b> (all with the strength value of 1 or 2).
 *
 * <p>At the beginning of the game each player receives two cards from this deck.
 * During the game they need to collect more of these cards in order to be able to defeat more powerful Monsters.
 *
 * <p>The deck is complemented with four The Sword of Destiny cards, which can be used instead of any other Attack (strength value of 1).
 */
public class AttackCard implements Card {

    /** All types of cards */
    public static final AttackCard[] CARDS = {
            new AttackCard("pirouette", Attack.Type.STEEL_SWORD),
            new AttackCard("feint", Attack.Type.STEEL_SWORD, Attack.Type.STEEL_SWORD),
            new AttackCard("slash", Attack.Type.SILVER_SWORD),
            new AttackCard("parry", Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD),
            new AttackCard("aard", Attack.Type.SIGN),
            new AttackCard("yrden", Attack.Type.SIGN, Attack.Type.SIGN),
            new AttackCard("cat", Attack.Type.POTIONS),
            new AttackCard("black_gull", Attack.Type.POTIONS, Attack.Type.POTIONS),
            new AttackCard("sword_of_destiny", Attack.Type.DESTINY)
    };

    private final String name;
    private final List<Attack.Type> attacks;

    private AttackCard(String name, Attack.Type ... attacks) {
        this.name = name;
        // Vytvoříme nemodifikovatlenou kolekci
        this.attacks = List.of(attacks);
    }

    public String getName() {
        return name;
    }

    public List<Attack.Type> getAttacks() {
        return attacks;
    }

    @Override
    public String toString() {
        return "AttackCard{" +
                "name='" + name + '\'' +
                ", attacks=" + attacks +
                '}';
    }
}
