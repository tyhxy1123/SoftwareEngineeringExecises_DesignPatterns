import java.util.*;

public class Main {



    public static void main(String[] args) {
        new Main().setUp();
    }

    private Deliverable deliverable;
    private Calendar cal;

    public void setUp() {
        cal = Calendar.getInstance();
        deliverable = new Deliverable("Deliverable1", "Details1", 2.2, 55, 2.5, cal);
        System.out.println(deliverable.getCostEstimate());
        System.out.println(deliverable.getMaterialCost());
        System.out.println(deliverable.getTimeRequired());
        System.out.println((double)(2.5 * 2.2 + 55));
    }
}
