package Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUNUS on 26.03.2017.
 */
public class AlertContract {
    private String alertType;
    private List<String> fields;
    private List<String> methods;

    public AlertContract() {
        fields = new ArrayList<>();
        methods = new ArrayList<>();
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public List<String> getFields() {
        return fields;
    }

    public void addFields(String field) {
        this.fields.add(field);
    }

    public List<String> getMethods() {
        return methods;
    }

    public void addMethods(String method) {
        this.methods.add(method);
    }
}
