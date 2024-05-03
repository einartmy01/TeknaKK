package eksempler.src.lf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Proffessor extends Human implements Academic, Iterable<Student>, Comparable<Proffessor>{

    private List<Student> students = new ArrayList<>();
    private boolean isTeaching;

    public Proffessor(int age, double height, String name) {
        super(age, height, name);
    }

    public void addStudent(Student stud){
        students.add(stud);
    }

    public List<Student> getStudents(){
        return students;
    }

    @Override
    public void goToClass() {
        isTeaching = true;
    }

    @Override
    public void leaveClass(){
        isTeaching = false;
    }


    @Override
    public void doAssignment(String assignment) {
        Random rnd = new Random();
        Student stud = students.get(rnd.nextInt(students.size()));
        stud.doAssignment(assignment);
    }    

    @Override
    public Iterator<Student> iterator() {
        return new ProffessorIterator(this);
    }

    
    @Override
    public int compareTo(Proffessor o) {
        return new ProffessorComparator().compare(this, o);
    }


    public static void main(String[] args) {
        Proffessor prof1 = new Proffessor(80, 1.90, "Skau");
        Student stud1 = new Student(19, 1.29, "Per", 25);
        Student stud2 = new Student(20, 1.29, "Ola", 26);

        prof1.addStudent(stud1);
        prof1.addStudent(stud2);

        prof1.doAssignment("Objektøving 1");

        for (Student student : prof1) {
            System.out.println(student.getName());
        }
    }

}
