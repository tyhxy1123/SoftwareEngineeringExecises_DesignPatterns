import java.util.ArrayList;
import java.util.List;

public class Adapter extends Project implements IProject {

    public Adapter(String name, String description, double rate) {
        super(name, description, rate);
    }

    @Override
    public List<Deliverable> getDeliverables() {
        List<Deliverable> list = new ArrayList<>();
        for(List<Deliverable> value : super.allDeliverables().values()){
            list.addAll(value);
        }
        return list;
    }
}
