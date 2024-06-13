package Inheritance;

public class Main {

    public static void main(String[] args) {

        steuerbescheid(new King(), 20);
        steuerbescheid(new Noble(), 20);
        steuerbescheid(new Peasant(), 20);
        steuerbescheid(new Serf(), 20);
    }

    static void steuerbescheid(Inhabitant einwohner, int income) {

        einwohner.setIncome(income);

        System.out.println(einwohner.getClass().getName() +
                ": Einkommen " + income +
                ", zu versteuerndes Einkommen " +
                einwohner.taxableIncome() +
                ", Steuer " + einwohner.tax());
    }

}