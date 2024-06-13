package generics;

public class Wine extends Drink{
    String region;

    public Wine(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "region='" + region + '\'' +
                '}';
    }

    public String getRegion() {
        return region;
    }
}
