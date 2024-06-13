import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Auction {
    private List<Item> allItems = new ArrayList<>();
    private List<Person> bidders = new ArrayList<>();
    private int nextItem = 1;
    private boolean closed = false;


    public Auction(){
    }

    public void addBid(String itemName, String nameOfBidder, long price){
        if(closed == true) throw new IllegalStateException();
        if(itemName == null || nameOfBidder == null) throw new NullPointerException();
        if(itemName.isEmpty() || nameOfBidder.isEmpty() || price <= 0) throw new IllegalArgumentException();
        Person newBidder = new Person(nameOfBidder);
        bidders.add(newBidder);
        for(Item i : allItems){
            if(i.getName().equals(itemName)){
                i.addBid(newBidder, price);
                return;
            }
        }
        throw new NoSuchElementException("can not find the corresponding item");

    }

    public String closeAuction(){
        if(closed == true) throw new IllegalStateException();
        closed = true;
        return generateItemListString();
    }

    public String generateAllBidsString(Item item){
        //new String will return a null String which is not allowed!
        String s = new String();
        if(!item.getAllBids().isEmpty()) {
            s = item.getAllBids().get(0).toString();
            for (Bid b : item.getAllBids()) {
                if (b == item.getAllBids().get(0)) continue;
                s += "\n" + b.toString();
            }
        }

        else{
            return "All bids:";
        }

        return "All bids:" + "\n" + s;
    }

    public String generateItemListString(){
        if(allItems.isEmpty()) return new String();
        String temp = new String();
//        temp = allItems.get(0).toString();
        temp = generateItemString(allItems.get(0));
        if(allItems.size() >= 1) {
            for (int i = 1; i < allItems.size(); i++) {
                temp += "\n" + generateItemString(allItems.get(i));
            }
        }
        return temp + "\n";
    }

    public void registerItem(Item item){
        if(closed == true) throw new IllegalStateException();
        if(item == null) throw new NullPointerException();
        for(Item i : allItems){
            if(item.getName().equals(i.getName())) throw new IllegalArgumentException();
        }
        allItems.add(item);
    }

    public abstract String generateItemString(Item item);

    public List<Item> getAllItems(){
        return allItems;
    }
}
