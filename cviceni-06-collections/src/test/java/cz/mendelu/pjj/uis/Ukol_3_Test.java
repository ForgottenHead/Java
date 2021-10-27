package cz.mendelu.pjj.uis;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by xkoloma1 on 02.11.2016.
 */
class Ukol_3_Test {

    @Test
    public void test_opakovaneho_pridani() {
        Predmet predmet = new Predmet("PJJ");

        assertTrue(predmet.zapisDoPredmetu(new Student("Tomaš", "Novak")));
        assertFalse(predmet.zapisDoPredmetu(new Student("Tomaš", "Novak")));
    }

    @Test
    public void test_serazeni_studentu_v_predmetu() {
        Predmet predmet = new Predmet("PJJ");
        predmet.zapisDoPredmetu(new Student("Tomaš", "Novak"));
        predmet.zapisDoPredmetu(new Student("Jan", "Vopička"));
        predmet.zapisDoPredmetu(new Student("Tomaš", "Novak"));
        predmet.zapisDoPredmetu(new Student("Jan", "Adamek"));

        Iterator<Student> studentIterator = predmet.getStudents().iterator();

        assertEquals(new Student("Jan", "Adamek"), studentIterator.next());
        assertEquals(new Student("Tomaš", "Novak"), studentIterator.next());
        assertEquals(new Student("Jan", "Vopička"), studentIterator.next());
        assertFalse(studentIterator.hasNext());
    }

    @Test
    public void test_implementace_metody_compateTo() {
        Student a = new Student("Tomaš", "Novak");
        Student b = new Student("Jan", "Vopička");
        Student c = new Student("Jan", "Adamek");
        Student d = new Student("Tomaš", "Novak");

        assertTrue(a.compareTo(b) < 0);
        assertTrue(b.compareTo(c) > 0);
        assertTrue(a.compareTo(d) == 0);
    }

    @Test
    public void test_zabezpecneho_pridani() {
        Predmet predmet = new Predmet("PJJ");
        Student jack = new Student("Jack", "Sparrow");

        assertThrows(RuntimeException.class,
                () -> predmet
                        .getStudents()
                        .add(jack));
    }
}
