package cz.mendelu.pjj.pohadka.domain;

public class Rytir extends Hrdina {

    public Rytir(int zivoty, int sila) {
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
