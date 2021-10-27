package cz.mendelu.pjj.uis;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by xkoloma1 on 02.11.2016.
 */
class Ukol_5_Test {

    @Test
    public void test_pridani_studenta_k_registraci() {
        Predmet predmet = new Predmet("PJJ");
        Registrace registrace = new Registrace(predmet);

        registrace.zaregistruj(new Student("Tomaš", "Novak"));
        registrace.zaregistruj(new Student("Jan", "Vopička"));
        registrace.zaregistruj(new Student("Jan", "Adamek"));

        Iterator<Student> studentIterator = registrace.getStudents().iterator();

        assertEquals(new Student("Tomaš", "Novak"), studentIterator.next());
        assertEquals(new Student("Jan", "Vopička"), studentIterator.next());
        assertEquals(new Student("Jan", "Adamek"), studentIterator.next());
        assertFalse(studentIterator.hasNext());
    }

    @Test
    public void test_vicenasobne_registrace_jednoho_studenta() {
        Predmet predmet = new Predmet("PJJ");
        Registrace registrace = new Registrace(predmet);

        registrace.zaregistruj(new Student("Jan", "Adamek"));
        registrace.zaregistruj(new Student("Jan", "Adamek"));

        assertEquals(1, registrace.getStudents().size());
    }

    @Test
    public void test_hromadneho_zapisu() {
        Predmet predmet = new Predmet("PJJ");
        Registrace registrace = new Registrace(predmet);

        registrace.zaregistruj(new Student("Tomaš", "Novak"));
        registrace.zaregistruj(new Student("Jan", "Vopička"));
        registrace.zaregistruj(new Student("Jan", "Adamek"));

        predmet.zalozCviceni(2);
        predmet.zalozCviceni(2);

        assertEquals(1, registrace.hromadnyZapis());
    }

    @Test
    public void test_hromadneho_zapisu_nad_kapacitu() {
        Predmet predmet = new Predmet("PJJ");
        Registrace registrace = new Registrace(predmet);

        registrace.zaregistruj(new Student("Tomaš", "Novak"));
        registrace.zaregistruj(new Student("Jan", "Vopička"));
        registrace.zaregistruj(new Student("Jan", "Adamek"));
        registrace.zaregistruj(new Student("Eva", "Marná"));
        registrace.zaregistruj(new Student("Petr", "Nový"));

        predmet.zalozCviceni(2);
        predmet.zalozCviceni(2);

        assertEquals(-1, registrace.hromadnyZapis());
    }

}
