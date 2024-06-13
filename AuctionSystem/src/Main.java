public class Main {
    protected Auction a;

    public static void main(String[] args) {
        new Main().setUp();
    }

    public void setUp() {
        a = new AllPayAuction();
        testGenerateAllBidsString();
    }

    public void testGenerateAllBidsString() {
//        String[] result = new String[6];
//        result[0] = "All bids:";
//        result[1] = "All bids:";
//        result[2] = "All bids:";
//        result[3] = "All bids:\n1 EUR by Max";
//        result[4] = "All bids:\n7000 EUR by Moritz";
//        result[5] = "All bids:\n1000 EUR by Max\n2000 EUR by Moritz";
//
//        Item i1 = new Item("Socks", "Ancient socks", 1);
//        Item i2 = new Item("Book", "Ancient book", 5000);
//        Item i3 = new Item("Clock", "Ancient clock", 1000);
//        a.registerItem(i1);
//        a.registerItem(i2);
//        a.registerItem(i3);
//
//        a.addBid("Socks", "Max", 1);
//        a.addBid("Book", "Moritz", 7000);
//        a.addBid("Clock", "Max", 1000);
//        a.addBid("Clock", "Moritz", 2000);
//        System.out.println(a.generateAllBidsString(i3));
        a.registerItem(new Item("Socks","Ancient socks", 1));
        a.registerItem(new Item("Book", "Ancient book", 5000));
        a.registerItem(new Item("Clock", "Ancient clock", 1000));
        System.out.println(a.generateItemString(a.getAllItems().get(0)));
    }
}
