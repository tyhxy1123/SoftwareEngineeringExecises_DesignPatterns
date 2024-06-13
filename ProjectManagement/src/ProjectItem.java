public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate) {
        if(name.isEmpty() || details.isEmpty()) throw new IllegalArgumentException();
        if(name == null || details == null) throw new NullPointerException();
        if(rate <= 0) throw new IllegalArgumentException();
        this.name = name;
        this.details = details;
        this.rate = rate;
    }

    public void setDetails(String details) {
        if(details == null) throw new NullPointerException();
        if(details.isEmpty()) throw new IllegalArgumentException();
        this.details = details;
    }

    public long getCostEstimate(){
        double costOfTime = rate * getTimeRequired();
        if(costOfTime - (long)costOfTime < 0.5){ costOfTime = (long)costOfTime;}
        else{costOfTime = (long)costOfTime + 1;}
        return (long)costOfTime + getMaterialCost();
    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();
}
