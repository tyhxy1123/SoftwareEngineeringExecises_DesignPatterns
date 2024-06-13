package de.klausur.enterprise_node;

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
public class StaffMemberIterator implements EnterpriseNodeIterator<StaffMember> {
    private Set<StaffMember> allMembers;

    public StaffMemberIterator(Set<StaffMember> directSubordinates){
        allMembers = new HashSet<StaffMember>();
        allMembers.addAll(directSubordinates);
    }

    private void findSubordinatesRecursively(StaffMember m){
        Iterator<StaffMember> it = allMembers.iterator();
        while(it.hasNext()){
            StaffMember tempMember = it.next();
            if(m.compareTo(tempMember) == 0){
                return;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public StaffMember next() {
        return null;
    }
}
