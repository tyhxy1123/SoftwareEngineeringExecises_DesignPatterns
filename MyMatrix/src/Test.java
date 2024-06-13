import java.util.*;

public class Test {
    Map<Integer, String> map = new HashMap<>();

    MyMatrix<String> filledMatrix, emptyMatrix;
    String a, b;

    public void setUp() {
        filledMatrix = new MyMatrix<String>();
        emptyMatrix = new MyMatrix<String>();
        a = "a";
        b = "b";

        filledMatrix.put(0, 1, a);
        filledMatrix.put(1, 3, b);
        filledMatrix.put(2, 0, a);
        System.out.println("Column is: " + filledMatrix.getColumnCount());
        System.out.println("Row is:" + filledMatrix.getRowCount());
        testGetIllegalArgument();

    }

    public void testGetIllegalArgument() {
        for (int i = 3; i < 5; i++) {
            filledMatrix.get(i, 0);
        }
        for (int i = 4; i < 6; i++) {
            filledMatrix.get(0, i);
        }
    }

    public static void main(String[] args) {
        new Test().setUp();

    }
}
