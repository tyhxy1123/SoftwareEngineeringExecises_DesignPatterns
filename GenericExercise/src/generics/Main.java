package generics;

public class Main {
    public static void main(String[] args) {
        Bottle bottle = new Bottle();
        bottle.fill(new Wine("Burgundy"));
        Drink drink;
        if(bottle.empty() instanceof Beer){
            drink = (Beer) bottle.empty();
            System.out.println(((Beer)drink).getBrewery());
        }
        if(bottle.empty() instanceof RedWine){
            drink = (RedWine) bottle.empty();
            System.out.println(((RedWine)drink).getRegion());
        }
        if(bottle.empty() instanceof WhiteWine){
            drink = (WhiteWine) bottle.empty();
            System.out.println(((WhiteWine)drink).getRegion());
        }
        if(bottle.empty() instanceof Wine){
            drink = (Wine) bottle.empty();
            System.out.println(((Wine)drink).getRegion());
        }


    }
}
