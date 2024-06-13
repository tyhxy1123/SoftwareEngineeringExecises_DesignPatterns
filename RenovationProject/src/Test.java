import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    private StructuredObject structuredObject = new StructuredObject();

    public static void main(String[] args) {
        new Test().testFloorSurface();
    }
    public void testFloorSurface() {
        Surface s1 = new Surface(2.0, 3.0);
        Material m1 = new Flooring("PVC red", 5.0, 2.0);
        s1.setMaterial(m1);
        structuredObject.add(s1);

        Map<String, Integer> expectedMaterials = new TreeMap<String, Integer>();
        expectedMaterials.put("PVC red", 3);

        Map<String, Integer> actualMaterials = new TreeMap<String, Integer>();
        actualMaterials = structuredObject.addMaterialReq(actualMaterials);


    }
}
