package de.klausur.desktop_search_engine;

public class ResourceType{
    private String description;
    private KeywordCollector collector;
    public ResourceType(String desc, KeywordCollector collector){
        if(desc == null) throw new NullPointerException();
        if(collector == null) throw new NullPointerException();
        if(desc.isEmpty()) throw new IllegalArgumentException();
        this.description = desc;
        this.collector = collector;
    }
    public String getDescription(){
        return description;
    }
    public KeywordCollector getCollector(){
        return collector;
    }
}