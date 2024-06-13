package generics;

public class RedWine extends Wine {
    public RedWine(String region) {
        super(region);
    }

    @Override
    public String toString() {
        return "RedWine{" +
                "region='" + region + '\'' +
                '}';
    }
}
