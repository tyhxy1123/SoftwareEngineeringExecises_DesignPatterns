import java.util.Map;
import java.util.TreeMap;

public class Surface extends RenovationObject{
    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface(double length, double width) {
        if(length <= 0) throw new IllegalArgumentException();
        if(width <= 0) throw new IllegalArgumentException();
        this.length = length;
        this.width = width;
    }

    public void setMaterial(Material m){
        if(m == null) throw new NullPointerException();
        selectedMaterial = m;
    }

    public double getArea(){
        return getLength() * getWidth();
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPrice() {
        return selectedMaterial.getPriceOfASurface(this);
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

        if(materials.containsKey(selectedMaterial.getName())){
            int m = materials.get(selectedMaterial.getName());
            m += selectedMaterial.getMaterialReq(this);
            materials.remove(selectedMaterial.getName());
            materials.put(selectedMaterial.getName(), m);
        }
        else{
            materials.put(selectedMaterial.getName(), selectedMaterial.getMaterialReq(this));
        }
        return materials;
    }
}
