package Core;

import java.util.ArrayList;
import java.util.List;

public class BugInstance {
    List<ClassMember> classMemberList;
    private String alertType;

    public BugInstance() {
        classMemberList = new ArrayList<>();
    }

    public void addMember(ClassMember classMember) {
        this.classMemberList.add(classMember);
    }

    public List<ClassMember> getClassMemberList(){return this.classMemberList;}

    public void removeMember(ClassMember classMember) {
        if (this.classMemberList.contains(classMember))
            this.classMemberList.remove(classMember);
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }
}
