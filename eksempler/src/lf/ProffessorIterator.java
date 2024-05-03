package eksempler.src.lf;

import java.util.Iterator;
import java.util.List;

public class ProffessorIterator implements Iterator<Student> {

    private Proffessor prof;
    private int index = 0;

    public ProffessorIterator(Proffessor prof){
        this.prof = prof;
    }

    @Override
    public boolean hasNext() {
        return index < prof.getStudents().size();
    }

    @Override
    public Student next() {
        List<Student> sortedStudents = prof.getStudents();

        sortedStudents.sort(new AgeComparator());
        Student nextStudent = sortedStudents.get(index);
        index++;
        return nextStudent;
    }
    
}
