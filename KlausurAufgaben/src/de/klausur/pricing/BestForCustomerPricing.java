package de.klausur.pricing;

import java.util.LinkedList;

/**
 * The class BestForCustomerPricing calculates the selling price,
 * based on the largest discount for the customer
 */
public class BestForCustomerPricing extends ComplexPricing{
    public BestForCustomerPricing(ISalePricing pricing){
        super();
        add(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        long toReturn = getPricings().get(0).getTotal(sale);

        for(ISalePricing s : getPricings()){

            if(toReturn > s.getTotal(sale)){

                toReturn = s.getTotal(sale);
            }
        }

        return toReturn;
    }
}