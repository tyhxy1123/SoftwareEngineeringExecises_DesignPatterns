//package Factorial;

public class Functions {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int n){

        int fact = 1;
        for (int i = n; i > 1; i--) {
            fact *= i;
        }
        return fact;
    }
}
