public class Flooring extends Material{

    private static double limit = 0.02;
    private double widthOfFlooring;

    public Flooring(String name, double price, double widthOfFlooring) {
        super(name, price);
        if(widthOfFlooring <= 0) throw new IllegalArgumentException();
        this.widthOfFlooring = widthOfFlooring;
    }

    public double getWidth() {
        return widthOfFlooring;
    }

    @Override
    public int getMaterialReq(Surface s) {
        double temp = s.getArea() / widthOfFlooring;
        int toReturn;
        if(((int)(temp * 100)) % 10 < 2) toReturn = (int)temp;
        else toReturn = (int)temp + 1;
        return toReturn;
    }
}
