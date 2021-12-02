package cz.mendelu.pjj.witcher.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.util.function.Supplier;

public class LabelActor extends Actor {

    private Supplier action;

    public LabelActor(String label) {
        setLabel(label);
    }

    public LabelActor(String label, Supplier action) {
        setLabel(label);
        setAction(action);
    }

    public void setLabel(String label) {
        var image = new GreenfootImage(label, 32, Color.BLACK, null);
        this.setImage(image);
    }

    public void setAction(Supplier action) {
        this.action = action;
    }

    @Override
    public void act() {
        if (action != null && Greenfoot.mouseClicked(this)) {
            var result = action.get();
            if (result != null) {
                setLabel(result.toString());
            }
        }
    }
}
