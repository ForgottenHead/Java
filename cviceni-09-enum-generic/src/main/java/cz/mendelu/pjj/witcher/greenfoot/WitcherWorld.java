package cz.mendelu.pjj.witcher.greenfoot;

import cz.mendelu.pjj.witcher.*;
import greenfoot.World;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class WitcherWorld extends World {

    public static final int CARD_WIDTH = 300 / 2;
    public static final int CARD_HEIGHT = 500 / 2;
    public static final String CARD_FOLDER = "images/";

    public static final int CARD_SPACE = CARD_WIDTH / 5;

    private static final int WORLD_WIDTH = 1280;
    private static final int WORLD_HEIGHT = CARD_HEIGHT * 4;


    private Game game = new Game(
            new Player("Player 1"),
            new Player("Player 2")
    );

    private InHand inHand;
    private Tropheis tropheis;
    private Player currentPlayer;
    private DeckActor attackDeckActor;
    private DeckActor monsterDeckActor;
    private CardActor[] marketPlace = new CardActor[Game.ATTACK_CARDS];
    private LabelActor playerName;

    public WitcherWorld() {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        this.setBackground("images/background.png");

        this.inHand = new InHand(this);
        this.tropheis = new Tropheis(this);

        this.attackDeckActor = new DeckActor("attack_card", game.getAttackDeck());
        this.addObject(attackDeckActor, CARD_WIDTH, CARD_HEIGHT * 2);

        for (int i = 0; i < Game.ATTACK_CARDS; i++) {
            var acc = new CardActor((AttackCard) game.getAttackDeck().drawCard());
            marketPlace[i] = acc;
            addObject(acc, CARD_WIDTH * 2 + CARD_SPACE + (i * (CARD_WIDTH + CARD_SPACE)), CARD_HEIGHT * 2);
            acc.setAction(new Consumer() {
                @Override
                public void accept(Object ac) {
                    currentPlayer.addAttackCard((AttackCard) ac);
                    acc.setNoCard();
                }
            });
        }

        this.monsterDeckActor = new DeckActor("monster_card", game.getMonsterDeck());
        this.addObject(monsterDeckActor, CARD_WIDTH, CARD_HEIGHT - CARD_SPACE);

        this.playerName = new LabelActor("Player");
        this.addObject(playerName, WORLD_WIDTH / 2, CARD_HEIGHT / 6);

        for (int i = 0; i < Game.MONSTER_CARDS; i++) {
            var acc = new CardActor((Card) game.getMonsterDeck().drawCard());
            addObject(acc, CARD_WIDTH * 2 + CARD_SPACE + (i * (CARD_WIDTH + CARD_SPACE)), CARD_HEIGHT - CARD_SPACE);
            acc.setAction(new Consumer() {
                @Override
                public void accept(Object mc) {
                    if (currentPlayer.attackTo((MonsterCard) mc)) {
                        acc.setCard((Card) game.getMonsterDeck().drawCard());
                        tropheis.setTrophies(currentPlayer.trophies());
                    }
                }
            });
        }

        var nextActor = new LabelActor("Next player", new Supplier() {
            @Override
            public Object get() {
                nextPlayer();
                return null;
            }
        });
        this.addObject(nextActor, WORLD_WIDTH - nextActor.getImage().getWidth(), WORLD_HEIGHT - nextActor.getImage().getHeight());

        nextPlayer();
    }

    public void nextPlayer() {
        this.currentPlayer = game.nextPLayer();
        this.inHand.setPlayer(currentPlayer);
        this.attackDeckActor.setAction(new Consumer() {
            @Override
            public void accept(Object attackCard) {
                currentPlayer.addAttackCard((AttackCard) attackCard);
            }
        });
        this.tropheis.setTrophies(currentPlayer.trophies());

        for (CardActor card : marketPlace) {
            if (!card.getCard().isPresent() && !game.getAttackDeck().isEmpty()) {
                card.setCard((Card) game.getAttackDeck().drawCard());
            }
        }

        this.playerName.setLabel(currentPlayer.getName());
    }

    @Override
    public void act() {
        inHand.update();
    }
}
