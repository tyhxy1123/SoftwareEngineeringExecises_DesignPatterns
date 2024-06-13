package de.klausur.enterprise_node;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractUnit extends AbstractEnterpriseUnit{
    private List<AbstractEnterpriseUnit> childNodes;
    public AbstractUnit(String name){
        super(name);
        childNodes = new LinkedList<AbstractEnterpriseUnit>();
    }
    public boolean add(AbstractEnterpriseUnit childNode){
        if(childNode == null) throw new NullPointerException();
        if(childNode.getName().isEmpty()) throw new IllegalArgumentException();
        for (AbstractEnterpriseUnit u: childNodes
             ) {
            if(u.getName() == childNode.getName())return false;
        }
        childNodes.add(childNode);
        return true;
    }
    public boolean remove(AbstractEnterpriseUnit childNode){
        if(childNode == null) throw new NullPointerException();
        if(childNode.getName().isEmpty()) throw new IllegalArgumentException();
        for (AbstractEnterpriseUnit u: childNodes
             ) {
            if(u.getName() == childNode.getName()){
                childNodes.remove(childNode);
                return true;
            }
        }
        return false;
    }
    public List<AbstractEnterpriseUnit> getChildNodes(){
        return childNodes;
    }
}
