import java.util.*;

//Each team is led by a single StaffMember, the teamLeader
public class Team extends AbstractEnterpriseUnit{
    private StaffMember teamLeader;

    public Team(String name, StaffMember teamLeader){
        super(name);
        if(teamLeader == null) throw new NullPointerException();
        this.teamLeader = teamLeader;
    }

    public StaffMember getTeamLeader() {
        return teamLeader;
    }

    public List<StaffMember> getTeamMembers(){
        Set<StaffMember> set = teamLeader.getDirectSubordinates();
        List<StaffMember> list = new LinkedList<>();
        list.add(teamLeader);
        Iterator<StaffMember> it = new StaffMemberIterator(set);
        while(it.hasNext()){
            list.add(it.next());
        }
//        list.addAll(set);
        list.sort(new Comparator<StaffMember>() {
            @Override
            public int compare(StaffMember m1, StaffMember m2) {
                return m1.compareTo(m2);
            }
        });
        return list;
    }
}
