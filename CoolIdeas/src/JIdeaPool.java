import java.util.*;

public class JIdeaPool {
    private Map<JTopic, Set<JIdea>> pool;

    public JIdeaPool() {
        pool = new HashMap<>();
    }

    public void add(JTopic topic){
        if(topic == null) throw new NullPointerException();
        if(pool.containsKey(topic)) return;
        else pool.put(topic, new HashSet<>());
    }

    public void add(JIdea idea, JTopic topic){
        if(idea == null || topic == null) throw new NullPointerException();
        //check if pool contains this idea already
        boolean poolContainsIdea = false;
        for (Set<JIdea> eachSet:pool.values()
             ) {
            if(eachSet.contains(idea)) {
                poolContainsIdea = true;
                break;
            }
        }
        //if pool contains idea already
        if(poolContainsIdea){
            //if topic exists not in pool
            if(!pool.keySet().contains(topic)){
                Set<JIdea> temp = new HashSet<>();
                temp.add(idea);
                pool.put(topic, temp);
            }
            //if topic exists in pool
            else{
                //check if idea exists in topic's corresponding set
                if(pool.get(topic).contains(idea)) return;
                else pool.get(topic).add(idea);
            }
        }
        //if pool does not contain idea
        else {
            //if there is idea with same title already in the pool, return
            for (Set<JIdea> eachSet : pool.values()
                    ) {
                for (JIdea anyIdea : eachSet
                        ) {
                    //if true, then return
                    if (anyIdea.getTitle().equals(idea.getTitle())) return;
                }
            }
            //no idea in poll with same title, check if topic exists in pool
            //if pool contains topic
            if(pool.containsKey(topic)) pool.get(topic).add(idea);
            //if pool contains not topic
            else{
                Set<JIdea> temp = new HashSet<>();
                temp.add(idea);
                pool.put(topic, temp);
            }
        }
        //code end


//        if(pool.containsKey(topic)) {
//            boolean setContainsSameElement = false;
//            for(Set<JIdea> tempSet : pool.values()){
//                for(JIdea tempIdea : tempSet){
//                    if(idea.getTitle() == tempIdea.getTitle()) setContainsSameElement = true;
//                }
//                if(!setContainsSameElement){
//                    tempSet.add(idea);
//                }
//            }
//            for(JIdea tempIdea : pool.get(topic)){
//                if(idea.getTitle() == tempIdea.getTitle()) setContainsSameElement = true;
//            }
//            if(!setContainsSameElement) pool.get(topic).add(idea);
//        }
//        else{
//            Set<JIdea> temp = new HashSet<>();
//            temp.add(idea);
//            boolean setContainsSameElement1 = false;
//            for(Set<JIdea> tempSet : pool.values()){
//                for(JIdea tempIdea : tempSet){
//                    if(idea.getTitle() == tempIdea.getTitle()) setContainsSameElement1 = true;
//                }
//                if(!setContainsSameElement1){
//                    pool.put(topic, temp);
//                }
//            }
//            pool.put(topic, temp);
//        }
    }

    public boolean remove(JTopic topic){
        if(topic == null) throw new NullPointerException();
        if(!pool.containsKey(topic)) return false;
        else{
            pool.remove(topic);
            return true;
        }
    }

    public boolean remove(JIdea idea){
        if(idea == null) throw new NullPointerException();
        //check if idea exists in the pool
        boolean exist = false;
        for (Map.Entry<JTopic, Set<JIdea>> entry:
                pool.entrySet()) {
            if(entry.getValue().contains(idea)) {
                exist = true;
                break;
            }
        }
        if(!exist) return false;
        else{
            for(Map.Entry<JTopic, Set<JIdea>> entry:
                    pool.entrySet()){
                for(JIdea tempIdea : entry.getValue()){
                    if(tempIdea.getTitle() == idea.getTitle()) {
                        entry.getValue().remove(tempIdea);
                        break;
                    }
                }
            }
        }
        for(Map.Entry<JTopic, Set<JIdea>> entry:
                pool.entrySet()){
            for(JIdea tempIdea : entry.getValue()){
                if(tempIdea.getTitle() == idea.getTitle()) entry.getValue().remove(tempIdea);
            }
        }
        return true;
    }

    public JIdea getIdea(String title){
        if(title == null) throw new NullPointerException();
        if(title.isEmpty()) throw new IllegalArgumentException();
        for(Map.Entry<JTopic, Set<JIdea>> entry : pool.entrySet()){
            for(JIdea temp : entry.getValue()){
                if(temp.getTitle() == title) return temp;
            }
        }
        return null;
    }

    public int numberOfTopics(){
        return pool.isEmpty() ? 0 : pool.entrySet().size();
    }

    public int numberOfIdeas(){
        if(pool.isEmpty()) return 0;
        Set<JIdea> set = new HashSet<>();
        for (Set<JIdea> tempSet:
             pool.values()) {
            for(JIdea tempIdea : tempSet){
                if(set.isEmpty())set.add(tempIdea);
                else{
                    boolean contains = false;
                    for(JIdea ideaInSet : set){
                        if(ideaInSet.getTitle() == tempIdea.getTitle()) {
                            contains = true;
                            break;
                        }
                    }
                    if(contains==false) set.add(tempIdea);
                }
            }
        }
        return set.size();
    }

    public void removeReleased(){
        for (Set<JIdea> tempSet:
            pool.values() ) {
            Iterator<JIdea> it = tempSet.iterator();
            while(it.hasNext()){
                JIdea tempIdea = it.next();
                if(tempIdea.isReleased()) it.remove();
            }
        }
    }

    public void removeDeclined(){
        for (Set<JIdea> tempSet:
                pool.values() ) {
            Iterator<JIdea> it = tempSet.iterator();
            while(it.hasNext()){
                JIdea tempIdea = it.next();
                if(tempIdea.isDeclined()) it.remove();
            }
        }
    }
}
