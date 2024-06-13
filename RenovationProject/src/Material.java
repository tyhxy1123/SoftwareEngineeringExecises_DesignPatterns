public abstract class Material {

    private String name;
    private double price;

    public Material(String name, double price) {
        if(name == null) throw new NullPointerException();
        if(name.isEmpty()) throw new IllegalArgumentException();
        if(price < 0) throw new IllegalArgumentException();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit(){
        return price;
    }

    public abstract int getMaterialReq(Surface s);

    public double getPriceOfASurface(Surface s){
        if(s == null) throw new NullPointerException();
        return getPricePerUnit() * getMaterialReq(s);
    }
}
