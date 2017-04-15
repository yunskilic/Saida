package Core;

import java.util.ArrayList;
import java.util.List;

public class BugInstance {
    List<ClassMember> classMemberList;

    public BugInstance() {
        classMemberList = new ArrayList<>();
    }

    public void addMember(ClassMember classMember) {
        this.classMemberList.add(classMember);
    }

    public void removeMember(ClassMember classMember) {
        if (this.classMemberList.contains(classMember))
            this.classMemberList.remove(classMember);
    }
}
