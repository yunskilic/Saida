package Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YUNUS on 25.03.2017.
 */
public class SaidaContract {

    private ViolationResult violationResult;

    private TemporalOperator temporalOperator;

    private TemporalOrder temporalOrder;

    private List<Event> events;

    public ViolationResult getViolationResult() {
        return violationResult;
    }

    public void setViolationResult(ViolationResult violationResult) {
        this.violationResult = violationResult;
    }

    public TemporalOperator getTemporalOperator() {
        return temporalOperator;
    }

    public void setTemporalOperator(TemporalOperator temporalOperator) {
        this.temporalOperator = temporalOperator;
    }

    public TemporalOrder getTemporalOrder() {
        return temporalOrder;
    }

    public void setTemporalOrder(TemporalOrder temporalOrder) {
        this.temporalOrder = temporalOrder;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        if (getEvents() == null) {
            setEvents(new ArrayList<>());
        }
        getEvents().add(event);
    }
}
