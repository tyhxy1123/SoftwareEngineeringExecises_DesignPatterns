import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.NoSuchElementException;

public class Task extends ProjectItem {
    private List<ProjectItem> projectItems;

    public Task(String name, String details, double rate) {
        super(name, details, rate);
        projectItems = new ArrayList<>();
    }

    @Override
    public double getTimeRequired() {
        if(projectItems == null) throw new NullPointerException();
        if(projectItems.isEmpty()) return 0;
        double time = 0;
        for(ProjectItem t : projectItems){
            time += t.getTimeRequired();
        }
        return time;
    }

    @Override
    public long getMaterialCost() {
        if(projectItems == null) throw new NullPointerException();
        if(projectItems.isEmpty()) return 0;
        long cost = 0;
        for(ProjectItem t : projectItems){
            cost += t.getMaterialCost();
        }

        return cost;
    }

    public void addProjectItem(ProjectItem pi){
        if(pi == null) throw new NullPointerException();
        projectItems.add(pi);
    }

    public void removeProjectItem(ProjectItem pi){
        if(pi == null) throw new NullPointerException();
        if(!projectItems.contains(pi)) throw new NoSuchElementException();
        projectItems.remove(pi);
    }

    public List<Deliverable> allDeliverables(){
        if(projectItems == null) throw new NullPointerException();
        if(projectItems.isEmpty()) return new ArrayList<>();
        List<Deliverable> temp = new ArrayList<>();
        for(ProjectItem d : projectItems){
            if(d instanceof Deliverable){
                temp.add((Deliverable)d);
            }
            if(d instanceof Task){
                temp.addAll(((Task) d).allDeliverables());
            }
        }
        return temp;
    }
}
