import java.util.*;

public class Project {
    private String name;
    private String description;
    public Task mainTask;

    public Project(String name, String description, double rate) {
        if(name == null || description == null) throw new NullPointerException();
        if(name.isEmpty() || description.isEmpty()) throw new IllegalArgumentException();
        if(rate <= 0) throw new IllegalArgumentException();
        this.name = name;
        this.description = description;
        mainTask = new Task(name, description, rate);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(Task newTask) {
        if(newTask == null) throw new NullPointerException();
//        mainTask.addProjectItem(newTask);
        mainTask = newTask;
    }

    public double getDuration(){
        return mainTask.getTimeRequired();
    }

    public long getTotalCost(){
        long temp = 0;
        temp = mainTask.getCostEstimate();
        return temp;
    }

    public Map<Calendar, List<Deliverable>> allDeliverables(){
        Map<Calendar, List<Deliverable>> map = new TreeMap<>();
        for(Deliverable d : mainTask.allDeliverables()){
            if(map.containsKey(d.getDate())){
                map.get(d.getDate()).add(d);
            }
            else{
                List<Deliverable> temp = new ArrayList<>();
                map.put(d.getDate(), temp);
                temp.add(d);
            }
        }
        return map;
    }
}
