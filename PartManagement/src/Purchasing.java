public class Purchasing implements Observation {
    private ReceivingStock stock;
    @Override
    public void alarm(Part part) {
        if(part == null) throw new NullPointerException();
        if(stock.get(part) < stock.getMinStockItems()){
            buy(part, stock.getMaxStockItems() - stock.get(part));
        }
    }

    public Purchasing(ReceivingStock receivingStock) {
        if(receivingStock == null) throw new NullPointerException();
        this.stock = receivingStock;
    }

    public void buy(Part part, int count){
        if(part == null) throw new NullPointerException();
        if(count <= 0) throw new IllegalArgumentException();
        stock.insert(part, count);
    }

    public ReceivingStock getStock(){
        return stock;
    }
}
