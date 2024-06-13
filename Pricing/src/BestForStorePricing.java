/**
 * The class BestForStorePricing selects the discount,
 * that is best for the vendor (i.e. lowest total discount).
 */
public class BestForStorePricing extends ComplexPricing {

    public BestForStorePricing(ISalePricing pricing) {

        super();
        if(pricing == null) throw new NullPointerException();
        getPricings().add(pricing);
    }

    @Override
    public long getTotal(Sale sale) {

        long toReturn = getPricings().get(0).getTotal(sale);

        for(ISalePricing s : getPricings()){

            if(toReturn < s.getTotal(sale)){

                toReturn = s.getTotal(sale);
            }
        }

        return toReturn;
    }
}
