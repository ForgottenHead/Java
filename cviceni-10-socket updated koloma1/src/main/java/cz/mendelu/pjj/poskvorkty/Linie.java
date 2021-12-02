package cz.mendelu.pjj.poskvorkty;

import java.util.Iterator;
import java.util.Objects;

public class Linie implements Iterable<Ctverecek> {

    public static final int LENGTH = 5;

    public final Ctverecek start;
    public final int[] smer;

    public Linie(Ctverecek start, int[] smer) {
        this.start = start;
        this.smer = smer;
    }

    @Override
    public Iterator<Ctverecek> iterator() {
        return new Iterator<Ctverecek>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < LENGTH;
            }

            @Override
            public Ctverecek next() {
                var x = start.x + i * smer[0];
                var y = start.y + i * smer[1];
                i += 1;
                return Ctverecek.of(x, y);
            }
        };
    }

    public boolean isIn(Ctverecek ctverecek) {
        for (var ct : this) {
            if (Objects.equals(ct, ctverecek)) {
                return true;
            }
        }
        return false;
    }
}
