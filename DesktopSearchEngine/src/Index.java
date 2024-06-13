import java.util.*;

public class Index{
    private Map<String, List<Resource>> index;
    public Index(){
        index = new HashMap<String, List<Resource>>();
    }
    public void add(Resource res){
        //get all keywords and related files and store them into index
        Set<String> keywordsSet = res.getType().getCollector().getKeywords(res);
        for (String keyword : keywordsSet) {
            if (index.containsKey(keyword)) {
                List<Resource> tempList = index.get(keyword);
                tempList.add(res);
                index.put(keyword, tempList);
            }
            else{
                List<Resource> tempList = new ArrayList<Resource>();
                tempList.add(res);
                index.put(keyword, tempList);
            }
        }
    }
    public List<Resource> getResources(String keyword){
        return index.get(keyword);
    }
}