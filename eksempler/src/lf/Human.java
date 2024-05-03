package eksempler.src.lf;
// En felles klasse for alle mennesker som finnes 
// En klasse er et felles sett med variabler, aktiviteter (funksjoner) og regler 
public class Human{

    //Variabler som er forskjellig for vært objekt av type menneske
    private int age;    
    private double height;
    private String name;

    //"Konstruktør", lage et nytt objekt av type menneske:
    public Human(int age, double height, String name){
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void birthday(){
        age = age + 1;
    }

    //Ingen kode i klassene kjøres før de blir kalt på! Derfor har vi en main metode for å kunne kjøre litt kode.
    //Main metoden har ingenting med klassen å gjøre
    public static void main(String[] args) {
        Human human1 = new Human(0, 0.45 , "Peder");
        Human human2 = new Human(29, 1.78, "Jonas");
        
        System.out.println(human1.getName() + " er blitt " + human1.getAge());
        System.out.println(human2.getName() + " er blitt " + human2.getAge());

        human1.birthday();
        System.out.println(human1.getName() + " er blitt " + human1.getAge());
        System.out.println(human2.getName() + " er blitt " + human2.getAge());

        human2.birthday();
        System.out.println(human2.getName() + " er blitt " + human2.getAge());
    }
}
