package cz.mendelu.pjj.uis;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by xkoloma1 on 02.11.2016.
 */
class Ukol_1_Test {

    private static void prihlasXStudentuDoCviceni(Cviceni cviceni, int kolik) {
        for (int i = 0; i < kolik; i++) {
            Student s = new Student("jmeno_" + i, "prijmeni_" + i);
            assertTrue(cviceni.prihlasit(s),
                    format("Prihlašení studenta %s do cvičení %s se nezdařilo", s, cviceni));
        }
    }

    @Test
    public void test_implementace_metod_hashCode_a_equals() {
        Student a = new Student("Tomáš", "Novak");
        Student b = new Student("Jan", "Vopička");
        Student a2 = new Student("Tomáš", "Novak");

        assertFalse(a.equals(b), "Provnaní dvou ruzných studentů");
        assertTrue(a.equals(a2), "Porovnaní dvou stejných studentů");
    }

    @Test
    public void test_prekroceni_kapacity() {
        Cviceni cviceni = new Cviceni(5);
        prihlasXStudentuDoCviceni(cviceni, 5);
        Student s = new Student("jmeno_X", "prijmeni_X");

        assertFalse(cviceni.prihlasit(s), "Přihlašeni studenta do předmetu s překročením kapacity");
        assertEquals(5, cviceni.getStudents().size());

    }

    @Test
    public void test_opakovaneho_pridani() {
        Cviceni cviceni = new Cviceni(5);

        assertTrue(cviceni.prihlasit(new Student("jmeno", "prijmeni")));
        assertFalse(cviceni.prihlasit(new Student("jmeno", "prijmeni")));
        assertEquals(1, cviceni.getStudents().size());
    }

    @Test
    public void test_zabezpecneho_pridani() {
        Cviceni cviceni = new Cviceni(5);
        prihlasXStudentuDoCviceni(cviceni, 5);
        Student jack = new Student("Jack", "Sparrow");

        assertThrows(RuntimeException.class,
                () -> cviceni
                        .getStudents()
                        .add(jack));
    }
}
