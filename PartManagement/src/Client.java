public class Client {
    private Purchasing purch;
    private Part part;
    private ReceivingStock rStock;

    public void setUp() {
        rStock = new ReceivingStock(10, 100);
        purch = new Purchasing(rStock);
        part = new Components("id", "TestComponent");

        testBuy();


    }

    public void testBuy() {
        purch.buy(part, 25);
//      25 "Purchasing.buy() should add the specified number of parts to the stock even if the stock did not contain the part!"
        part = new SingleComponent("S5", "a single component");
        rStock.insert(part, 10);
        purch.buy(part, 13);
//      23 "Purchasing.buy() should add the specified number of parts to the stock!"
        System.out.println(purch.getStock().get(part));
    }

    public static void main(String[] args) {
        new Client().setUp();
    }
}
