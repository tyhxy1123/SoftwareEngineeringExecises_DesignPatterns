package de.klausur.pricing;
import java.util.*;

/**
 * abstract class ComplexPricing is responsible for selecting the discount to be applied
 */

public abstract class ComplexPricing implements ISalePricing {
    private List<ISalePricing> pricings;

    public ComplexPricing(){
        pricings = new LinkedList<ISalePricing>();
    }

    public void add(ISalePricing pricing){

        if(pricing == null) throw new NullPointerException();

        pricings.add(pricing);
    }

    public List<ISalePricing> getPricings(){
        return pricings;
    }
}
