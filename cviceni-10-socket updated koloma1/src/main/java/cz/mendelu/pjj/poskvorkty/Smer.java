package cz.mendelu.pjj.poskvorkty;

public enum Smer {

    S(0,-1),
    SV(1,-1),
    V(1,0),
    JV(1,1),
    J(0,1),
    JZ(-1,1),
    Z(-1,0),
    SZ(-1,-1);

    public final int x, y;

    Smer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
