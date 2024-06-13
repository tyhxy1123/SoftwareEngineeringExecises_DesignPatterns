import java.sql.SQLOutput;

public class Paint extends Material{
    private static double limit = 0.02;
    private int noOfCoats;
    private double noOfSqMPerLiter;

    public Paint(String name, double price, int noOfCoats, double noOfSqMPerLiter) {
        super(name, price);
        if(noOfCoats <= 0) throw new IllegalArgumentException();
        if(noOfSqMPerLiter <= 0) throw new IllegalArgumentException();
        this.noOfCoats = noOfCoats;
        this.noOfSqMPerLiter = noOfSqMPerLiter;
    }

    public int getNoOfCoats() {
        return noOfCoats;
    }

    public double getNoOfSqMPerLiter() {
        return noOfSqMPerLiter;
    }

    @Override
    public int getMaterialReq(Surface s) {
        int noOfBucket;
        double result = (s.getArea() * noOfCoats) / noOfSqMPerLiter;

        int decimal = (int)result;
        double fractional = result - decimal;
        System.out.println(result);
        System.out.println(decimal);
        System.out.println(fractional * 100 % 50);
        System.out.println(limit * 100);
        if(fractional * 100 % 50 >= limit * 100) {
            result = result + 0.5;
            System.out.println("in if");
        }
//        else {
//            result = decimal;
//        }
        System.out.println(result);
        noOfBucket = (int)(result * 2);
        System.out.println(noOfBucket);
        return noOfBucket;
    }
}
