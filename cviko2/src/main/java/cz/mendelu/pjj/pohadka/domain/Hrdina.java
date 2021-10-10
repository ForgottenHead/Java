package cz.mendelu.pjj.pohadka.domain;

public abstract class Hrdina implements Bojeschopny {
    int zivoty;
    int sila;

//    public Hrdina(int zivoty, int sila){
//        this.zivoty = zivoty;
//        this.sila = sila;
//    }

    public void uberZivot(int zivot){
        zivot -= zivot;
    }

}