package cz.mendelu.pjj.poskvorkty;

import java.util.*;

public class Piskvorky implements Iterable<Map.Entry<Ctverecek, Hrac>> {

    private static final int[][] smery = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

    private Map<Ctverecek, Hrac> papir = new LinkedHashMap<>();
    private List<Linie> linie = new ArrayList<>();
    private Hrac naTahu = Hrac.KRIZEK;

    public Iterator<Map.Entry<Ctverecek, Hrac>> iterator() {
        return papir.entrySet().iterator();
    }

    public Hrac proveďTah(int x, int y) {
        var poz = Ctverecek.of(x, y);
        if (!papir.containsKey(poz)) {
            // Umistění znažky na volnou pozici
            papir.put(poz, naTahu);

            // Změna aktuálního hráce
            naTahu = (naTahu == Hrac.KRIZEK) ? Hrac.KOLECKO : Hrac.KRIZEK;
            //naTahu = Hrac.values()[(naTahu.ordinal() + 1) % Hrac.values().length];

            // Otestování  vniku linie
            testVznikluLine(poz).ifPresent(linie::add);
        }

        // Vracení barvy na pozici at již jsem neco přidal nebo ne.
        return papir.get(poz);
    }

    public List<Linie> getLinie() {
        return Collections.unmodifiableList(linie);
    }

    public Hrac getHracTahu() {
        return naTahu;
    }


    private Optional<Linie> testVznikluLine(Ctverecek from) {
        var hrac = papir.get(from);
        smery:
        for (var smer : smery) {
            for (int i = 1; i < Linie.LENGTH; i++) {
                var ctverecek = Ctverecek.of(from.x + i * smer[0], from.y + i * smer[1]);
                // Konec testovaní smeru jakmile narazím na druhou barvu
                if (hrac != papir.get(ctverecek)) {
                    continue smery;
                }
                // Testuje za bod neni soucasti již jiné linie
                for (var line: linie) {
                    if (line.isIn(ctverecek)) {
                        continue smery;
                    }
                }
            }
            return Optional.of(new Linie(from, smer));
        }
        return Optional.empty();
    }


}
