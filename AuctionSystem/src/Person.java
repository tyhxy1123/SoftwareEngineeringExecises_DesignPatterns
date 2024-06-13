public class Person {
    private String name;

    public Person(String name){
        if(name == null) throw new NullPointerException();
        if(name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
