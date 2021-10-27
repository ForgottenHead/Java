package cz.mendelu.pjj.uis;

import cz.mendelu.pjj.uis.Predmet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Registrace {

    private Predmet predmet;
    private Queue<Student> students = new LinkedList<>();

    public Registrace(Predmet predmet) {
        this.predmet = predmet;
    }

    // Ukol 5
    public void zaregistruj(Student student) {
        if (!students.contains(student)){
            students.add(student);
        }
    }

    // Ukol 5
    public Collection<Student> getStudents() {
        return Collections.unmodifiableCollection(students);
    }

    // Ukol 5
    public int hromadnyZapis() {
        int registered = students.size();
        int kapacita = 0;
        int index = 0;

        for (int i = 0; i < predmet.getCvicenis().size(); i++) {
            kapacita += predmet.getCviceni(i).getKapacita();
        }

        while (!students.isEmpty() &&
                index < predmet.getCvicenis().size() - 1){

            if (predmet.getCviceni(index).prihlasit(students.peek())){
                //registered++;
                students.poll();
            }else{
                index++;
            }
        }



        return kapacita - registered;
    }
}
