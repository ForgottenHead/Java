package cz.mendelu.pjj.poskvorkty;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Piskvorky implements Iterable<Map.Entry<Pozice, Barva>>{
    private Map<Pozice, Barva> mrizka = new LinkedHashMap<>();
    private Barva aktualniBarva = Barva.RED;

    public Piskvorky(){
        pridajZnacku(1,1);
        pridajZnacku(2,2);
        pridajZnacku(3,3);
    }


    public Iterator<Map.Entry<Pozice, Barva>> iterator(){
        return mrizka.entrySet().iterator();
    }


    public Barva pridajZnacku(int x, int y){
        var poz = Pozice.of(x, y);
        if(mrizka.containsKey(poz)){
            return mrizka.get(poz);
        }
        mrizka.put(poz, aktualniBarva);
        var result = aktualniBarva;
        aktualniBarva = Barva.values()[(aktualniBarva.ordinal() + 1) % Barva.values().length];
        return result;
    }
}
