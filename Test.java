public class Test {
    private int x;
    private int y;

    Test() {
        x = 10;
        y = 20;
    }

    int getX () {
        return x;
    }

    int getY () {
        return y;
    }  


    
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getX());

        System.out.println("Hello, World!");
    }
}