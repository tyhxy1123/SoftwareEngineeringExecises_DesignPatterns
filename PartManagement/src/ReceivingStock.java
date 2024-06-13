public class ReceivingStock extends Stock{
    private int minStockItems;
    private int maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems) {
        if(minStockItems < 1) throw new IllegalArgumentException();
        if(maxStockItems < minStockItems) throw new IllegalArgumentException();
        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;

    }

    public int getMinStockItems() {
        return minStockItems;
    }

    public int getMaxStockItems() {
        return maxStockItems;
    }
}
