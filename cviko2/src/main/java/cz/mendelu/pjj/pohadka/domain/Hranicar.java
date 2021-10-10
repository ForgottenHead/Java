package cz.mendelu.pjj.pohadka.domain;

public class Hranicar extends Hrdina {

    public Hranicar(int zivoty, int sila) {
        this.zivoty = zivoty;
        this.sila = sila;
    }

    public void zautoc(Bojeschopny jedinec, int distance){
        if(distance <= 1){
            jedinec.uberZivot(this.zivoty);
        }
    };

    public boolean jeZivy(){
        return zivoty>0;
    };
    // TODO Doimplementovat
}
