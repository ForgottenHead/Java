package cz.mendelu.pjj.poskvorkty;

import java.util.Objects;

public class Ctverecek implements Comparable<Ctverecek> {

    public final int x, y;

    private Ctverecek(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Ctverecek of(int x, int y) {
        return new Ctverecek(x, y);
    }

    public static Ctverecek of(String line) {
        var split = line.split(",", 2);
        var x = Integer.parseInt(split[0]);
        var y = Integer.parseInt(split[1]);
        return Ctverecek.of(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ctverecek pozice = (Ctverecek) o;
        return x == pozice.x && y == pozice.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public int compareTo(Ctverecek other) {
        return (this.x + this.y) - (other.x + other.y);
    }
}
