
package de.klausur.enterprise_node;

import java.util.*;
/* The class StaffMember keeps track of the directSubordinates of the respective person.
   The method addDirectSubordinate() and removeDirectSubordinate() work analogous to
   AbstractUnit‘s add() and remove()*/
/*StaffMember objects can be compared to other objects of their kind by calling compareTo().
* This method implements the behavior defined by the interface java.lang.Comparable<T>
* regarding the alphabetic order of the compared staff members’ names.
* Implementing this interface makes the class StaffMember more flexible allowing different
* data structures to store and manage its objects */
public class StaffMember implements EnterpriseNode, java.lang.Comparable<StaffMember>{
    private String name;
    private String job;
    private Set<StaffMember> directSubordinates;

    public StaffMember(String name, String job){
        this.name = name;
        this.job = job;
    }

    public String getJob(){
        return job;
    }

    public boolean addDirectSubordinate(StaffMember subordinate){
        if(subordinate == null) throw new NullPointerException();
        if(subordinate.getName().isEmpty() || subordinate.getJob().isEmpty()) throw new IllegalArgumentException();
        if(directSubordinates != null){
            if(directSubordinates.contains(subordinate)) return false;
            directSubordinates.add(subordinate);
            return true;
        }
        directSubordinates = new HashSet<StaffMember>();
        directSubordinates.add(subordinate);
        return true;
    }

    public boolean removeDirectSubordinate(StaffMember subordinate){
        if(subordinate == null) throw new NullPointerException();
        if(subordinate.getName().isEmpty() || subordinate.getJob().isEmpty()) throw new IllegalArgumentException();
        if(directSubordinates.contains(subordinate)) {
            directSubordinates.remove(subordinate);
            return true;
        }
        return false;
    }

    public Set<StaffMember> getDirectSubordinates(){
        return directSubordinates;
    }

    @Override
    public int compareTo(StaffMember o) {
        //Compare names of staffMember alphabetically
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffMember)) return false;
        StaffMember that = (StaffMember) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(job, that.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + " " + getJob();
    }
}
