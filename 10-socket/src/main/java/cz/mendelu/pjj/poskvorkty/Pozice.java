package cz.mendelu.pjj.poskvorkty;

import java.util.Objects;

public class Pozice {
    public static Pozice of(int x, int y){
        return new Pozice(x, y);
    }

    public final int x, y;


    private Pozice(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozice pozice = (Pozice) o;
        return x == pozice.x && y == pozice.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pozice[" + x + ", " + y +']';
    }
}

