package generics;

public class Bottle {
    private Drink content;

    public void fill(Drink drink){
        content = drink;
    }
    public boolean isEmpty(){
        if(content == null) return true;
        return false;
    }

    public Drink empty(){
        return content;
    }
}

