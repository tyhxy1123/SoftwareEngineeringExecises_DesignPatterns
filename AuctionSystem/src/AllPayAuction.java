public class AllPayAuction extends Auction {

    @Override
    public String generateItemString(Item item) {
        if(item == null) throw new NullPointerException();
        //For every item on item list, all bids of the item should be generated
        String s = new String();
        if(!item.getAllBids().isEmpty()) {
            s = item.toString() + "\n" + generateAllBidsString(item);
            return s;
        }
        else{
            return item.toString() + '\n' + "No bids placed";
        }
    }
}
