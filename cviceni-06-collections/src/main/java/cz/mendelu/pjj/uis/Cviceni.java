package cz.mendelu.pjj.uis;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xkoloma1 on 02.11.2016.
 */
public class Cviceni {

    private final int kapacita;

    private Set<Student> students = new HashSet<>();

    public Cviceni(int kapacita) {
        this.kapacita = kapacita;
    }

    public int getKapacita() {
        return kapacita;
    }

    // Ukol 1
    public boolean prihlasit(Student s) {
        if (Predmet.getStudents().contains(s) && students.size() < kapacita) {
            return students.add(s);
        }
        return false;
    }

    // Ukol 1
    public Collection<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }


}
