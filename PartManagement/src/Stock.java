import java.util.*;

public abstract class Stock {
    private Map<Part, Integer> parts = new TreeMap<>(new Comparator<Part>() {
        @Override
        public int compare(Part o1, Part o2) {
            return o1.getId().compareTo(o2.getId());
        }
    });
    private List<Observation> observers = new ArrayList<>();

    public int get(Part part){
        if(part == null) throw new NullPointerException();
        if(!parts.containsKey(part)) return -1;
        return parts.get(part);
    }

    public boolean set(Part part, int count){
        if(part == null) throw new NullPointerException();
        if(!parts.containsKey(part) || count < 0) return false;
        parts.put(part, count);
        notify(part);
        return true;
    }

    public void insert(Part part, int count){
        if(part == null) throw new NullPointerException();
        if(count <= 0) throw new IllegalArgumentException();
        if(parts.containsKey(part)){
            parts.put(part, parts.get(part) + count);
            notify(part);
        }
        else{
            parts.put(part, count);
            notify(part);
        }
    }

    public boolean delete(Part part, int count){
        if(part == null) throw new NullPointerException();
        if(count < 0) return false;
        if(!parts.containsKey(part)) return false;
        else if(parts.containsKey(part)){
            if(parts.get(part) >= count){
                if(parts.get(part) == count) parts.remove(part);
                parts.put(part, parts.get(part) - count);
                notify(part);
                return true;
            }
            else if(parts.get(part) < count){
                return false;
            }
        }
        return false;
    }

    public void register(Observation observer){
        if(observer == null) throw new NullPointerException();
        observers.add(observer);
    }

    public void notify(Part part){
        for(Observation ob : observers){
            ob.alarm(part);
        }
    }
}
