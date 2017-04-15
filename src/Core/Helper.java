package Core;

import Data.*;
import org.antlr.v4.runtime.Token;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.EnumUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static SaidaContract CreateMopContract(List<Token> tokens) {
        SaidaContract contract = new SaidaContract();
        tokens.remove(tokens.size() - 1);
        for (Token t : tokens) {
            if (EnumUtils.isValidEnum(ViolationResult.class, t.getText())) {
                contract.setViolationResult(Enum.valueOf(ViolationResult.class, t.getText()));
            }
            if (EnumUtils.isValidEnum(TemporalOperator.class, t.getText())) {
                contract.setTemporalOperator(Enum.valueOf(TemporalOperator.class, t.getText()));
            }
            if (EnumUtils.isValidEnum(TemporalOrder.class, t.getText())) {
                contract.setTemporalOrder(Enum.valueOf(TemporalOrder.class, t.getText()));
            }
            if (EnumUtils.isValidEnum(Event.class, t.getText())) {
                contract.addEvent(Enum.valueOf(Event.class, t.getText()));
            }
        }
        return contract;
    }

    public static String CreateMopFile(SaidaContract contract, File source, File dest) throws IOException {
        String fileName = getFileNameWithoutExtension(getFileNameFromPath(source.getAbsolutePath()));
        StringBuilder sb = new StringBuilder();
        sb.append("import java.io.*;\n");
        sb.append("import java.util.*;\n");
        sb.append(fileName);
        sb.append("\n");
        sb.append("{\n");
        List<String> eventNames = new ArrayList<>();
        for (Event event : contract.getEvents()) {
            String eventName = String.format("%s_event%d", fileName, eventNames.size());
            eventNames.add(eventName);
            sb.append(String.format("event %s after : ", eventName));

            switch (event) {
                case FieldGet:
                    sb.append("get(@FIELDINFO);");
                    break;
                case FieldSet:
                    sb.append("set(@FIELDINFO);");
                    break;
                case MethodCall:
                    sb.append("call(@METHODINFO);");
                    break;
            }
        }
        sb.append("\nltl: ");
        switch (contract.getTemporalOperator()) {
            case Never:
                sb.append("![]");
                break;
            case Always:
                sb.append("[]");
                break;
        }
        if (eventNames.size() == 1) {
            sb.append(String.format("%s;\n", eventNames.get(0)));
        } else if (eventNames.size() == 2) {
            switch (contract.getTemporalOrder()) {
                case Before:
                    sb.append(String.format("%s => %s", eventNames.get(0), eventNames.get(1)));
                    break;
                case After:
                    sb.append(String.format("%s => %s", eventNames.get(1), eventNames.get(0)));
                    break;
            }
        }
        sb.append(String.format("@Violation{System.out.println(%s bug reported is %s);}", fileName, contract.getViolationResult()));
        sb.append("\n}");
        FileUtils.writeStringToFile(new File(String.format("%s\\%s.mop", dest, fileName)), sb.toString(), Charset.defaultCharset());
        return String.format("%s\\%s.mop", dest, fileName);
    }

    public static String getFileNameFromPath(String path) {
        return path.substring(path.lastIndexOf('\\') + 1);
    }

    public static String getFileNameWithoutExtension(String fileName) {
        String result = fileName;
        if (result.contains(".")) {
            result = result.substring(0, result.indexOf("."));
        }
        return result;
    }
}
