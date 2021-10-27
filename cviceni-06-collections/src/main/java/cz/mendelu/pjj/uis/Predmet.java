package cz.mendelu.pjj.uis;

import java.util.*;

/**
 * Created by xkoloma1 on 02.11.2016.
 */
public class Predmet {

    private final String kod;

    private List<Cviceni> cviceni = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();


    public Predmet(String kod) {
        this.kod = kod;
    }

    // Ukol 2
    public Cviceni zalozCviceni(int kapacita) {
        Cviceni aux = new Cviceni(kapacita);
        cviceni.add(aux);
        return aux;
    }

    // Ukol 2
    public Collection<Cviceni> getCvicenis() {
        return Collections.unmodifiableList(cviceni);
    }

    // Ukol 2
    public Cviceni getCviceni(int index) {
        if (index <= cviceni.size()){
            return cviceni.get(index);
        }
        return null;
    }

    // Ukol 3
    public boolean zapisDoPredmetu(Student student) {
        if (!students.contains(student)){
            return students.add(student);
        }
        return false;
    }

    // Ukol 3
    public static Collection<Student> getStudents() {
        ArrayList<Student> aux = new ArrayList(students);
        aux.sort(Student::compareTo);
        return Collections.unmodifiableCollection(aux);

    }

    // Ukol 4
    public Collection<Student> getStudentyBezCviceni() {
        ArrayList<Student> aux = new ArrayList<>();
        boolean wasIn = false;
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < cviceni.size(); j++) {
                if (cviceni.get(j).getStudents().contains(students.get(i))){
                    wasIn = true;
                    break;
                }
            }
            if (!wasIn){
                aux.add(students.get(i));
            }
            wasIn = false;
        }
        return Collections.unmodifiableCollection(aux);
    }
}
