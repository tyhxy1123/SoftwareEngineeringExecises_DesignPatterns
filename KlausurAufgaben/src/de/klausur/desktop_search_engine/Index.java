package de.klausur.desktop_search_engine;

import java.util.*;
/*The index of all registered files will be handled by the class Index.
It represents a mapping of keywords to files (for each keyword a list of files).
The keywords belonging to a file were determined by the associated KeywordCollector.
It is possible to add a file to the index (add()) and to obtain the list of files which
    are associated with a specific keyword (getResources()).
If the index does not contain the specified keyword, an empty List must be returned.*/


public class Index{

    private Map<String, List<Resource>> index;

    public Index(){

        index = new HashMap<String, List<Resource>>();
    }

    public void add(Resource res){

        Set<String> keywordsSet = res.getType().getCollector().getKeywords(res);

        for (String keyword : keywordsSet) {

            if (index.containsKey(keyword)) {

                List<Resource> tempList = index.get(keyword);
                boolean isEqual = false;
                for(Resource temp : tempList){
                    if(temp.hashCode() == res.hashCode()) isEqual = true;
                }
                if(isEqual == true){
                    isEqual = false;
                    continue;
                }
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
        if(keyword == null) throw new NullPointerException();
        if(index.isEmpty() || !index.containsKey(keyword)) return new LinkedList<Resource>();
        else return index.get(keyword);
    }
}