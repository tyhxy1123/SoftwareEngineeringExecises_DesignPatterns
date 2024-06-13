package BinarTree;

public class BinarTreeTest {
    public static void main(String args[]) {
        //Auto auto = new Auto();
        Honda honda = new Honda();
        honda.run();
        System.out.print("");
    }

}

abstract class Auto{
    private Wheel wheel = new Wheel();
    private String name = "auto";
    abstract public void run();

}

class Honda extends Auto{
    public void run() {
        System.out.print("Honda running...");
    }
}

class Wheel{
    private String ruber;
    private String metal;
}