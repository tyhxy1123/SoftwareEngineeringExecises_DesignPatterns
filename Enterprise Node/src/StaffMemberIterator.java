import java.util.*;
/*
We want to focus on the StaffMemberIterator as one concrete iterator for
the enterprise structure. Its constructor is given a Set of staff members (directSubordinates)
and additionally determines all staff members below
these directSubordinates recursively (findSubordinatesRecursively()).
Eventually, the resulting set of staff members (allMembers) is
sorted alphabetically by the name of the staff members. Afterwards,
the iterator methods mentioned above must be able to iterate over all of the directly
and indirectly given staff members in order.
 */
public class StaffMemberIterator implements EnterpriseNodeIterator{
    private Set<StaffMember> allMembers;
    private Iterator<StaffMember> it;

    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        allMembers = new TreeSet<>();
        for(StaffMember m : directSubordinates){
            findSubordinateRecursively(m);
        }
        it = allMembers.iterator();
    }

    private void findSubordinateRecursively(StaffMember m){
//        Iterator<StaffMember> it = allMembers.iterator();
//        while(it.hasNext()){
//            StaffMember tempMember = it.next();
//            if(m.compareTo(tempMember) == 0){
//                return;
//            }
//        }
//        for (StaffMember temp:
//             m.getDirectSubordinates()) {
//            if(temp.getDirectSubordinates() == null) allMembers.add(temp);
//            else{
//                allMembers.add(temp);
//                findSubordinateRecursively(temp);
//            }
//        }
        allMembers.add(m);
        if(m.getDirectSubordinates()==null) return;
        else{
            for(StaffMember temp : m.getDirectSubordinates()){
                findSubordinateRecursively(temp);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public StaffMember next() {
        if(allMembers.isEmpty())throw new NoSuchElementException();
        else{
            return it.next();
        }
    }
}
