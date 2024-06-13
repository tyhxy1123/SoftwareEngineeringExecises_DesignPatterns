package de.klausur.pricing;

public class AbsoluteDiscountPricing implements ISalePricing{
    private long discount;
    private long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold) {
        this.discount = discount;
        this.threshold = threshold;
    }

    @Override
    public long getTotal(Sale sale) {
        //use catalog price to determine
        if((sale.getPreDiscountTotal() - discount) > threshold){
            return sale.getPreDiscountTotal() - discount;
        }
        else return threshold;
    }
}
