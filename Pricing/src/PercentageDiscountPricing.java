public class PercentageDiscountPricing implements ISalePricing{
    private double percentage;

    public PercentageDiscountPricing(double percentage){
        if(percentage >= 0 && percentage <= 100){
            this.percentage = percentage;
        }
        else throw new IllegalArgumentException();
    }

    @Override
    public long getTotal(Sale sale){

        return (long)(sale.getPreDiscountTotal()*(100 - percentage)/100);
    }
}
