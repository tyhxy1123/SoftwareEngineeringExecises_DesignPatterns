public class AbsoluteDiscountPricing implements ISalePricing{
    private long discount;
    private long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold) {
        if(discount < 0) throw new IllegalArgumentException();
        if(threshold < 0) throw new IllegalArgumentException();
        this.discount = discount;
        this.threshold = threshold;
    }

    @Override
    public long getTotal(Sale sale) {
        //use catalog price to determine
        if(sale.getPreDiscountTotal() < threshold) return sale.getPreDiscountTotal();

        if((sale.getPreDiscountTotal() - discount) > threshold){

            return sale.getPreDiscountTotal() - discount;
        }

        return threshold;
    }
}
