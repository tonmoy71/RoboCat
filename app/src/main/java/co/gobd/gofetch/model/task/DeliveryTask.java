package co.gobd.gofetch.model.task;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public class DeliveryTask extends JobTask {
    private String JobTaskStateString;
    private String State;

    public DeliveryTask(String jobTaskStateString, String state) {
        super(JobTaskTypes.DELIVERY, "Delivering Package");
        JobTaskStateString = jobTaskStateString;
        State = state;
    }

    public String getJobTaskStateString() {
        return JobTaskStateString;
    }

    public String getState() {
        return State;
    }
}
