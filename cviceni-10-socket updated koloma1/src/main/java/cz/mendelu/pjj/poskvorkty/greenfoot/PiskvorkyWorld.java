package cz.mendelu.pjj.poskvorkty.greenfoot;

import cz.mendelu.pjj.poskvorkty.Ctverecek;
import cz.mendelu.pjj.poskvorkty.Hrac;
import cz.mendelu.pjj.poskvorkty.Piskvorky;
import greenfoot.Greenfoot;
import greenfoot.World;

public class PiskvorkyWorld extends World {

    public static final int CELL_SIZE = 32;

    private Piskvorky piskvorky;
    private Hrac hrac = Hrac.KRIZEK;
    private int lines = 0;

    public PiskvorkyWorld() {
        super(24, 16, CELL_SIZE);
        setBackground("images/grid.png");
        setPaintOrder(LinieActorGroup.PartActor.class, ZnackaActor.class, HracActor.class);
        piskvorky = new Piskvorky();
        addObject(new HracActor(piskvorky), 3, 0);
        //new Server(this).start();
    }

    public Piskvorky getPiskvorky() {
        return piskvorky;
    }

    public void provedTahAktualnimHracem(int x, int y) {
        var barva = piskvorky.proveďTah(x, y);
        if (getObjectsAt(x, y, ZnackaActor.class).isEmpty()) {
            var actor = new ZnackaActor(barva);
            addObject(actor, x, y);
        }
    }

    @Override
    public void act() {
        if (hrac == piskvorky.getHracTahu()) {
            var mouseInfo = Greenfoot.getMouseInfo();
            if (mouseInfo != null
                    && mouseInfo.getButton() == 1
                    && mouseInfo.getClickCount() == 1
                    && mouseInfo.getActor() == null) {
                provedTahAktualnimHracem(mouseInfo.getX(), mouseInfo.getY());
            }
        } else {
            var tah = Greenfoot.ask("Tah druheho hrace '1,2':");
            var ctverecek = Ctverecek.of(tah);
            provedTahAktualnimHracem(ctverecek.x, ctverecek.y);
        }

        if (lines != piskvorky.getLinie().size()) {
            for (int i = lines; i < piskvorky.getLinie().size(); i++) {
                new LinieActorGroup(piskvorky.getLinie().get(i), this);
            }
            lines = piskvorky.getLinie().size();
        }
    }
}
