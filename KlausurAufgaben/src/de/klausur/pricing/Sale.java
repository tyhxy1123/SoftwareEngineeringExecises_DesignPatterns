package de.klausur.pricing;

public class Sale {

    /**
     * While several discounts may be registered for a Sale object,
     * only one can actually be applied because our pricing logic is very simple.
     * Different discounts can be created by the static method Sale.createPricing().
     *
     * The arguments of this method are:
     *
     * discountType:
     * A value of the enumeration DiscountType,
     that determines whether to use an absolute or percentage discount.
     *
     * percentage:
     * In case of a percentage discount,
     this argument specifies the granted percentage.
     The two remaining arguments should be 0 in this case.
     *
     * discount and threshold:
     * In case of an absolute discount these arguments describe the granted discount,
     as explained above. The percentage argument should be 0 in this case.
     */

    private ISalePricing pricing;
    private long preDiscountTotal;

    public Sale(long preDiscountTotal, ISalePricing pricing){

        this.pricing = pricing;
        this.preDiscountTotal = preDiscountTotal;
    }

    public long getPreDiscountTotal() {
        //return the catalog price of this product
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing) {
        /**
         * the desired pricing logic pricing
         (BestForCustomerPricing or BestForStorePricing)
         is being selected using setPricing()
         */

        this.pricing = pricing;
    }

    public long getTotal(){
        //calculates final price of this product through List of pricings
        return pricing.getTotal(this);
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        switch (discountType) {
            case ABSOLUTEDISCOUNT:
                if(percentage != 0) throw new IllegalArgumentException();
                if(discount < 0) throw new IllegalArgumentException();
                return new AbsoluteDiscountPricing(discount, threshold);
            case PERCENTAGEDISCOUNT:
                if(discount != 0 || threshold != 0) throw new IllegalArgumentException();
                if(percentage < 0 || percentage > 100) throw new IllegalArgumentException();
                return new PercentageDiscountPricing(percentage);
            default:
                throw new IllegalArgumentException();
        }
    }
}
