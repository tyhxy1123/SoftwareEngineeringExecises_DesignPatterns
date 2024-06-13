public class EnglishAuction extends Auction {
    @Override
    public String generateItemString(Item item) {
        if(item == null) throw new NullPointerException();
        if(item.getAllBids().isEmpty()) return item.toString() + "\n" + "No bids placed";
        else {
            return item.toString();
        }
    }
}
