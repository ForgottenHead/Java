package cz.mendelu.pjj.uis;

import java.util.Objects;

/**
 * Created by xkoloma1 on 02.11.2016.
 */
public class Student {

    private final String jmeno;
    private final String prijmeni;

    public Student(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(jmeno, student.jmeno) && Objects.equals(prijmeni, student.prijmeni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jmeno, prijmeni);
    }



    // Ukol 3
    public int compareTo(Student other) {
        return this.prijmeni.compareTo(other.prijmeni);
    }


}

