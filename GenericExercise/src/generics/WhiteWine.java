package generics;

public class WhiteWine extends Wine {
    public WhiteWine(String region) {
        super(region);
    }

    @Override
    public String toString() {
        return "WhiteWine{" +
                "region='" + region + '\'' +
                '}';
    }
}
