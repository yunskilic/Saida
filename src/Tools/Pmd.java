package Tools;

import Core.BugInstance;

import java.util.List;

/**
 * Created by YUNUS on 16.04.2017.
 */
public class Pmd extends ToolBase {
    public Pmd(String inputPath) {
        super(inputPath);
    }

    @Override
    protected List<BugInstance> ParseAlerts() {

        return null;
    }
}
