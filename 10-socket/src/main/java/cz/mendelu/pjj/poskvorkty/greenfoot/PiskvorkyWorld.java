package cz.mendelu.pjj.poskvorkty.greenfoot;

import cz.mendelu.pjj.poskvorkty.Barva;
import cz.mendelu.pjj.poskvorkty.Piskvorky;
import cz.mendelu.pjj.poskvorkty.Pozice;
import cz.mendelu.pjj.poskvorkty.Server;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class PiskvorkyWorld extends World {
    private Piskvorky piskvorky;
    private Barva aktualniBarva;

    public PiskvorkyWorld() {
        super(24,16,32);
        setBackground("images/grid.png");


        piskvorky = new Piskvorky();

        new Server(piskvorky).start();

        for(var item: piskvorky){
            var poz = item.getKey();
            var farba = item.getValue();
            addObject(new ZnackaActor(farba), poz.x, poz.y);
        }
    }

    public void act(){
        var mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null
                && mouseInfo.getButton() == 1
                && mouseInfo.getClickCount() ==1
                && mouseInfo.getActor() == null){
            var barva = piskvorky.pridajZnacku(mouseInfo.getX(), mouseInfo.getY());
            var actor= new ZnackaActor(barva);
            addObject(actor, mouseInfo.getX(), mouseInfo.getY());
        }
    }




}
