package cz.mendelu.pjj.witcher;

import java.util.List;

import static cz.mendelu.pjj.witcher.Attack.*;

/**
 * The Monster Deck contains ferocious beasts and abominations
 * which threaten the Witcher universe. By killing the enemies the play-
 * er gains Fame Points, which are crucial for the victory in the game.
 * Each Monster Card lists the Monster’s name, the Technique nec-
 * essary to defeat it, the Reward and Fame Points acquired for killing
 * the enemy.
 */
public class MonsterCard implements Card {

    public static final MonsterCard[] MONSTERS = {
            new MonsterCard("Alp", 4, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SIGN, Attack.Type.SIGN),
            new MonsterCard("Graveir", 5, Attack.Type.SWORD, Attack.Type.SILVER_SWORD, Attack.Type.STEEL_SWORD, Attack.Type.SIGN, Attack.Type.POTIONS),
            new MonsterCard("Garkain", 6, Attack.Type.STEEL_SWORD, Attack.Type.STEEL_SWORD, Attack.Type.SIGN, Attack.Type.SIGN, Attack.Type.POTIONS, Attack.Type.POTIONS),
            new MonsterCard("Wild Hunt", 7, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SIGN, Attack.Type.SIGN, Attack.Type.POTIONS, Attack.Type.POTIONS),
            new MonsterCard("Frightemer", 8, Attack.Type.STEEL_SWORD, Attack.Type.STEEL_SWORD, Attack.Type.STEEL_SWORD, Attack.Type.STEEL_SWORD, Attack.Type.SIGN, Attack.Type.POTIONS, Attack.Type.POTIONS, Attack.Type.POTIONS),
            new MonsterCard("Koshchey", 8, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SILVER_SWORD, Attack.Type.SIGN, Attack.Type.SIGN, Attack.Type.SIGN, Attack.Type.POTIONS),
    };

    private final String name;
    private final int famePoint;
    private final List<Attack.Type> technique;

    public MonsterCard(String name, int famePoint, Attack.Type ... technique) {
        this.name = name;
        this.famePoint = famePoint;
        this.technique = List.of(technique);
    }

    public String getName() {
        return name;
    }

    public int getFamePoint() {
        return famePoint;
    }

    public List<Attack.Type> getTechnique() {
        return technique;
    }

    @Override
    public String toString() {
        return "MonsterCard{" +
                "name='" + name + '\'' +
                ", famePoint=" + famePoint +
                ", technique=" + technique +
                '}';
    }
}
