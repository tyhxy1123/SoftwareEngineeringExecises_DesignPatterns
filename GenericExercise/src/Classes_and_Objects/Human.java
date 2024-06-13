package Classes_and_Objects;

public class Human {

    private String name;
    private String forename;

    @Override
    public String toString() {

        return this.forename + " " + this.name;
    }

    public String getForename() {
        return forename;
    }

    public Human() {
    }

    public Human(String forename, String name) {

        this.forename = forename;
        this.name = name;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
