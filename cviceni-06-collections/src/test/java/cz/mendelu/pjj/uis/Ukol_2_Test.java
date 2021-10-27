package cz.mendelu.pjj.uis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by xkoloma1 on 02.11.2016.
 */
class Ukol_2_Test {

    @Test
    public void test_zalozeni_cviceni_v_predmetu() {
        Predmet predmet = new Predmet("PJJ");

        Cviceni cviceni = predmet.zalozCviceni(10);

        assertNotNull(cviceni);
        assertEquals(10, cviceni.getKapacita());
    }

    @Test
    public void test_ziskani_seznamu_cviceni_na_predmetu() {
        Predmet predmet = new Predmet("PJJ");

        Cviceni prvni = predmet.zalozCviceni(10);
        Cviceni druhe = predmet.zalozCviceni(20);

        assertEquals(2, predmet.getCvicenis().size());
    }

    @Test
    public void test_ziskani_jednoho_cviceni_v_predmetu() {
        Predmet predmet = new Predmet("PJJ");

        Cviceni prvni = predmet.zalozCviceni(10);
        Cviceni druhe = predmet.zalozCviceni(20);

        assertEquals(prvni, predmet.getCviceni(0));
        assertEquals(druhe, predmet.getCviceni(1));
    }

    @Test
    public void test_nelegalniho_zalozeni_cviceni() {
        Predmet predmet = new Predmet("PJJ");
        Cviceni evilLesson = new Cviceni(Integer.MAX_VALUE);

        assertThrows(RuntimeException.class,
                () -> predmet
                        .getCvicenis()
                        .add(evilLesson));
    }
}
