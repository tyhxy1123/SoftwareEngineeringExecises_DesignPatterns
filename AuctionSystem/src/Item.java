import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private String description;
    private long minPrice;
    private List<Bid> allBids;
    private Bid highestBid;

    @Override
    public String toString() {
        if(allBids == null){
//            return name + ": " + description
//                    + " (minimum bidding price: "
//                    + minPrice + " EUR)\n"
//                    + "No bids placed";
            return name + ": " + description
                    + " (minimum bidding price: "
                    + minPrice + " EUR)";
        }
        else {
            return name + ": " + description +
                    " (minimum bidding price: " + minPrice + " EUR)\n"
                    + "Highest bid: " + highestBid.getPrice() + " EUR by "
                    + highestBid.getBidder().getName();
        }
    }

    public Item(String name, String description, long minPrice){
        if(name == null || description == null) throw new NullPointerException();
        if(name.isEmpty() || description.isEmpty() || minPrice <= 0) throw new IllegalArgumentException();
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
    }

    public void addBid(Person bidder, long price){
        if(bidder == null) throw new NullPointerException();
        if(price <= 0) throw new IllegalArgumentException();
        if(price < minPrice) return;
        if(highestBid != null && price <= highestBid.getPrice()){
            return;
        }
        Bid bid = new Bid(bidder, price);
        if(allBids == null) {
            allBids = new ArrayList<>();
            allBids.add(bid);
        }
        else allBids.add(bid);
        for(Bid temp : allBids){
            if(highestBid == null) {
                highestBid = bid;
            }
            else if(highestBid.getPrice() < price){
                highestBid = bid;
            }
        }
    }

    public List<Bid> getAllBids(){
        if(allBids == null) return new ArrayList<>();
        return allBids;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return description;
    }

    public Bid getHighestBid(){
        return highestBid;
    }

}
