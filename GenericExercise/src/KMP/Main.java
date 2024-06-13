package KMP;

import static KMP.Leet.allToLeet;
import static KMP.Leet.toLeet;

public class Main {
    public static void main(String[] args) {
        String b = "er";
        b = toLeet(b);
        System.out.println(b);
        String[] a = new String[10];
        a[0] = "We are elite hackers!";
        a[1] = "Informatiker machen coole Sachen!";
        a = allToLeet(a);
        printArray(a, 0);
    }

    public static void printArray(String[] a, int i){
        if(a[i] == null) return;
        System.out.println(a[i]);
        printArray(a, i + 1);
    }
}
