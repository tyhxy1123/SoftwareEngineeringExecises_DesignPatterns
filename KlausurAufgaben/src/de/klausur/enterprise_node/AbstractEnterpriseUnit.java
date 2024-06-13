package de.klausur.enterprise_node;

public abstract class AbstractEnterpriseUnit implements EnterpriseNode{
    private String name;
    public AbstractEnterpriseUnit(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
