package eksempler.src.lf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Student extends Human implements Academic {

    private int studentID;
    private boolean isInClass;

    public Student(int age, double height, String name, int studentID) {
        super(age, height, name);
        
        this.studentID = studentID;
        isInClass = false;
    }
    
    public int getStudentID() {
        return studentID;
    }

    public void goToClass(){
        isInClass = true;
    }

    public void leaveClass(){
        isInClass = false;
    }

    @Override
    public void doAssignment(String assignment) {
        System.out.println(super.getName() + " har gjort oppgave: " + assignment);
    }


    public static void main(String[] args) {
        Student stud1 = new Student(18, 1.68, "Tor", 13);

        stud1.getStudentID();


        Human human1 = new Human(0, 0, "null");
        List<Human> humans = new ArrayList<>(Arrays.asList(human1, stud1));
        humans.add(human1);
        humans.add(stud1);
    }
}
