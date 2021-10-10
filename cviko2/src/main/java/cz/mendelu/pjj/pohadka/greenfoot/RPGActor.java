package cz.mendelu.pjj.pohadka.greenfoot;

import cz.mendelu.pjj.pohadka.domain.Hranicar;
import cz.mendelu.pjj.pohadka.domain.Rytir;
import cz.mendelu.pjj.pohadka.domain.Bojeschopny;
import cz.mendelu.pjj.pohadka.domain.Drak;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

public class RPGActor extends Actor {

    private static String IMAGE_SUFIX = ".png";
    private static String IMAGE_SELECTED_SUFIX = "-red.png";
    private static String IMAGE_KNIGHT = "knight";
    private static String IMAGE_ARCHER = "archer";
    private static String IMAGE_DRAGON = "dragon";
    private static String IMAGE_DEAD   = "dead";

    private static RPGActor selectedHrdinaActor;

    private String imageName;

    private Bojeschopny jedinec;

    private RPGActor(String imageName) {
        this.imageName = imageName;
        this.setImage(imageName + IMAGE_SUFIX);
    }

    public RPGActor(Hranicar hranicar) {
        this(IMAGE_ARCHER);
        if (hranicar instanceof Bojeschopny) {
            this.jedinec = (Bojeschopny) hranicar;
        }
    }

    public RPGActor(Rytir rytir) {
        this(IMAGE_KNIGHT);
        if (rytir instanceof Bojeschopny) {
            this.jedinec = (Bojeschopny) rytir;
        }
    }

    public RPGActor() {
        this(IMAGE_DRAGON);
        Drak smak = Drak.getSmak();
        if (smak instanceof Bojeschopny) {
            this.jedinec = (Bojeschopny) smak;
        }
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof RPGActor || actor == null) {
                RPGActor rpgActor = (RPGActor)actor;
                if (isLeftClickOnThisActor(mouseInfo, rpgActor)) {
                    this.setSelected();
                //} else if (isLeftClickOnField(mouseInfo, rpgActor) && selectedHrdinaActor == this) {
                //    this.moveToLocation(mouseInfo.getX(), mouseInfo.getY());
                } else if (isRightClickOnThisActor(mouseInfo, rpgActor) && selectedHrdinaActor != this) {
                    this.executeFightWith(selectedHrdinaActor);
                }
            }
        }
        if (selectedHrdinaActor == this) {
            String key = Greenfoot.getKey();
            if (key != null) {
                switch (key) {
                    case "left":
                        move(-1, 0);
                        break;
                    case "right":
                        move(1, 0);
                        break;
                    case "up":
                        move(0, -1);
                        break;
                    case "down":
                        move(0, 1);
                        break;
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, RPGActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }

    private boolean isRightClickOnThisActor(MouseInfo mouseInfo, RPGActor actor) {
        return actor == this && mouseInfo.getButton() == 3 && mouseInfo.getClickCount() == 0;
    }

    private boolean isLeftClickOnField(MouseInfo mouseInfo, RPGActor actor) {
        return actor == null && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }

    private void setSelected() {
        // Dragon or dead can't be selected
        if (this.imageName == IMAGE_DRAGON || this.imageName == IMAGE_DEAD) {
            return;
        }

        // Remove selection from previous actor
        if (selectedHrdinaActor != null) {
            selectedHrdinaActor.setImage(selectedHrdinaActor.imageName + IMAGE_SUFIX);
        }

        // Change selection of actor
        selectedHrdinaActor = this;
        selectedHrdinaActor.setImage(imageName + IMAGE_SELECTED_SUFIX);
    }

    private void moveToLocation(int x, int y) {
        setLocation(x, y);
    }

    private void move(int dx, int dy) {
        if (getObjectsAtOffset(dx, dy, Actor.class).isEmpty()) {
            setLocation(getX() + dx, getY() + dy);
        }
    }

    private void executeFightWith(RPGActor attacker) {
        // No attacker is selected or defender is dead
        if (attacker == null || this.imageName == IMAGE_DEAD) {
            return;
        }

        int distance = Math.abs(this.getX() - attacker.getX())
                     + Math.abs(this.getY() - attacker.getY());

        attacker.jedinec.zautoc(this.jedinec, distance);

        if (!attacker.jedinec.jeZivy()) {
            attacker.setHeroIsDead();
        }

        if (!this.jedinec.jeZivy()) {
            this.setHeroIsDead();
        }
    }

    private void setHeroIsDead() {
        this.imageName = IMAGE_DEAD;
        this.setImage(IMAGE_DEAD + IMAGE_SUFIX);
    }
}
