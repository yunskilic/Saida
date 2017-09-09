package Tools;

import Core.BugInstance;
import Core.ClassMember;
import Core.Field;
import Data.Constant;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import static Utils.Constants.OutputFolder;

public abstract class ToolBase {
    private String inputPath;

    public ToolBase(String inputPath){
        setInputPath(inputPath);
    }
    public void Create() throws IOException {
        List<BugInstance> alerts = ParseAlerts();
        for (BugInstance alert: alerts) {
            String mopPath = FindMopPath(alert.getAlertType());
            if (mopPath.equals(StringUtils.EMPTY)){
                System.out.println("There is not rule definition for this alert type");
                continue;
            }
            int fieldCount = StringUtils.countMatches(FileUtils.readFileToString(new File(mopPath)
                                                                                , Charset.defaultCharset())
                                                                                , Constant.FIELDINFO);
            List<ClassMember> fields = alert.getClassMemberList()
                    .stream()
                    .filter(x -> x.getClass().getName().equals(Field.class.getName()))
                    .collect(Collectors.toList());
            if (fieldCount == fields.size()) {
                for (int i = 0; i < fieldCount; i++) {
                    Field field = (Field)fields.get(i);
                    String newStr = FileUtils.readFileToString(new File(mopPath)
                                                            ,Charset.defaultCharset()).replaceFirst(Constant.FIELDINFO
                                                            ,String.format("%s %s.%s",field.getSignature()
                                                            ,field.getClassName()
                                                            ,field.getName()));
                    FileUtils.writeStringToFile(new File(mopPath), newStr, Charset.defaultCharset());
                }
            } else {
                Field field = (Field)fields.get(0);
                String newStr = FileUtils.readFileToString(new File(mopPath), Charset.defaultCharset())
                        .replace(Constant.FIELDINFO, String.format("%s %s.%s",field.getSignature(),field.getClassName(),field.getName()));
                FileUtils.writeStringToFile(new File(mopPath), newStr, Charset.defaultCharset());
            }
        }
    }

    private String FindMopPath(String alertType) {
        String path = String.format("%s\\%s.mop", OutputFolder, alertType);
        File file = new File(path);
        if (file.exists())
            return path;
        return StringUtils.EMPTY;
    }

    protected abstract List<BugInstance> ParseAlerts();

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
}
