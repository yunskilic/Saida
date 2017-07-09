import Tools.FindBugs;
import Tools.Pmd;
import Tools.ToolBase;
import Utils.*;

import java.io.IOException;

/**
 * Created by YUNUS on 16.04.2017.
 */
public class Generate {
    public void Create(String command, String inputCommand) throws IOException {
        ToolBase tool = null;
        if (command.equals(CodeAnalysisTools.FindBugs.toString())){
            tool=new FindBugs(inputCommand);
        }
        else if(command.equals(CodeAnalysisTools.PMD.toString())){
            tool=new Pmd(inputCommand);
        }
        else{return;}
        tool.Create();
    }
}
