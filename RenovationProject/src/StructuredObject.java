import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StructuredObject extends RenovationObject{

    private Set<RenovationObject> parts;

    public StructuredObject() {
        parts = new HashSet();
    }

    public void add(RenovationObject r){
        if(r == null) throw new NullPointerException();
        parts.add(r);
    }

    @Override
    public double getPrice() {
        double price = 0;
        for(RenovationObject part : parts){
            price += part.getPrice();
        }
        return price;
    }

    @Override
    public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) {
        if(materials == null) throw new NullPointerException();
        if(materials instanceof TreeMap){
            if(materials.containsValue(null)) throw new NullPointerException();
        }
        else{
            if(materials.containsKey(null)) throw new NullPointerException();
            if(materials.containsValue(null)) throw new NullPointerException();
        }

        for(RenovationObject part : parts){
            part.addMaterialReq(materials);
        }
        return materials;
    }
}
