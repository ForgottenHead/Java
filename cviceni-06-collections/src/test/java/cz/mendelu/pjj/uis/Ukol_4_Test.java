package cz.mendelu.pjj.uis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by xkoloma1 on 02.11.2016.
 */
class Ukol_4_Test {

    @Test
    public void test_radneho_prihlaseni_studenta_do_cviceni() {
        Predmet predmet = new Predmet("PJJ");
        Student student = new Student("Tomaš", "Novak");
        Cviceni cviceni = predmet.zalozCviceni(10);
        predmet.zapisDoPredmetu(student);

        assertTrue(cviceni.prihlasit(student));
    }

    @Test
    public void test_prihlaseni_studenta_do_cviceni_kdyz_neni_zapsan_do_predmetu() {
        Predmet predmet = new Predmet("PJJ");
        Student student = new Student("Tomaš", "Novak");
        Cviceni cviceni = predmet.zalozCviceni(10);

        assertFalse(cviceni.prihlasit(student));
    }

    @Test
    public void test_seznam_studnetu_bez_cviceni() {
        Predmet predmet = new Predmet("PJJ");
        Student studentTomas = new Student("Tomaš", "Novak");
        Student studentJan = new Student("Jan", "Adamek");

        predmet.zapisDoPredmetu(studentTomas);
        predmet.zapisDoPredmetu(studentJan);

        Cviceni cviceni = predmet.zalozCviceni(10);
        cviceni.prihlasit(studentTomas);

        assertEquals(1, predmet.getStudentyBezCviceni().size());
    }

    @Test
    public void test_zabezpecneho_pridani() {
        Predmet predmet = new Predmet("PJJ");
        Student jack = new Student("Jack", "Sparrow");

        assertThrows(RuntimeException.class,
                () -> predmet
                        .getStudentyBezCviceni()
                        .add(jack));
    }


}
