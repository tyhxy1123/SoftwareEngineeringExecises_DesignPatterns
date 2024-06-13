package de.klausur.desktop_search_engine;

import java.util.Objects;

public class Resource{
    private String name;
    private String path;
    private ResourceType rt;
    public Resource(String name, String path, ResourceType rt){
        if(name == null) throw new NullPointerException();
        if(path == null) throw new NullPointerException();
        if(rt == null) throw new NullPointerException();
        if(name.isEmpty()) throw new IllegalArgumentException();
        if(path.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
        this.path = path;
        this.rt = rt;
    }
    public String getName(){
        return name;
    }
    public String getPath(){
        return path;
    }
    public ResourceType getType(){
        return rt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource resource = (Resource) o;
        return Objects.equals(name, resource.name) &&
                Objects.equals(path, resource.path) &&
                Objects.equals(rt, resource.rt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, path, rt);
    }
}