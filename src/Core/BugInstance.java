package Core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUNUS on 15.04.2017.
 */
public class BugInstance {
    List<ClassMember> classMemberList;
    public BugInstance(){
        classMemberList=new ArrayList<>();
    }

    public void addMember(ClassMember classMember){ this.classMemberList.add(classMember);}

    public void removeMember(ClassMember classMember){
        if (this.classMemberList.contains(classMember))
            this.classMemberList.remove(classMember);
    }
}
