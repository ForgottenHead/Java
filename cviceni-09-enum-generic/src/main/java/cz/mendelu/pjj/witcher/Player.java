package cz.mendelu.pjj.witcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private String name;
    private List<MonsterCard> monsters = new ArrayList();
    private List<AttackCard> inHand = new ArrayList();

    public Player(String name) {
        this.name = name;
    }

    public void addAttackCard(AttackCard attackCard) {
        inHand.add(attackCard);
    }

    public List<AttackCard> inHand() {
        return Collections.unmodifiableList(inHand);
    }

    public List<MonsterCard> trophies() {
        return Collections.unmodifiableList(monsters);
    }

    public boolean attackTo(MonsterCard mc) {
        monsters.add(mc);
        inHand.clear();
        return true;
    }

    public String getName() {
        return name;
    }
}
