package cz.mendelu.pjj.pohadka.domain;

public interface Bojeschopny {

    void zautoc(Bojeschopny jedinec, int distance);

    boolean jeZivy();

    void uberZivot(int zivot);
}
