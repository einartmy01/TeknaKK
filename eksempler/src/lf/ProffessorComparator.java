package eksempler.src.lf;

import java.util.Comparator;

public class ProffessorComparator implements Comparator<Proffessor> {

    @Override
    public int compare(Proffessor o1, Proffessor o2) {
        return o1.getStudents().size() - o2.getStudents().size();
    }
    
}
