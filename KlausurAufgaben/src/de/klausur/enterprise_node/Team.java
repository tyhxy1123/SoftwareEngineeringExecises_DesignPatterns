package de.klausur.enterprise_node;

import java.util.*;

//Each team is led by a single StaffMember, the teamLeader
public class Team extends AbstractEnterpriseUnit{
    private StaffMember teamLeader;
    public Team(String name, StaffMember teamLeader){
        super(name);
        this.teamLeader = teamLeader;
    }
    public StaffMember getTeamLeader() {
        return teamLeader;
    }
    public List<StaffMember> getTeamMembers(){
        Set<StaffMember> set = teamLeader.getDirectSubordinates();
        List<StaffMember> list = new LinkedList<StaffMember>();
        list.addAll(set);
        list.sort(new Comparator<StaffMember>() {
            @Override
            public int compare(StaffMember m1, StaffMember m2) {
                return m1.compareTo(m2);
            }
        });
        return list;
    }

}
