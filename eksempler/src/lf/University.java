package eksempler.src.lf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class University {
    
    private HashMap<Academic,List<String>> academics = new HashMap<>();
    private String name;


    public University(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addSubject(Academic academic, String subject){
        if (!academics.containsKey(academic)) {
            academics.put(academic, new ArrayList<>());
        }
        academics.get(academic).add(subject);
    }

    public HashMap<Academic,List<String>> getAcademicsWithSubjects(){
        return academics;
    }

    public static void main(String[] args) {
        University uni1 = new University("NTNU");
        Proffessor prof1 = new Proffessor(50, 1.20, "Olav");
        uni1.addSubject(prof1, "TDT4100");


        System.out.println(uni1.getAcademicsWithSubjects().get(prof1)); 
    }
}
