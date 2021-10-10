package cz.mendelu.pjj.pohadka.domain;

public class Drak  implements Bojeschopny  {
    int zivoty;
    int sila;

    private static Drak smak{
    };

    public static Drak getSmak() {
        if (smak == null) {
            smak = new Drak();
        }
        return smak;
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