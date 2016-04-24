package co.gobd.gofetch.model.task;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public class FetchDeliveryManTask extends JobTask {

    private String JobTaskStateString;
    private String State;

    public FetchDeliveryManTask(String jobTaskStateString, String state) {
        super(JobTaskTypes.FETCH_DELIVERYMAN, "Fetching Delivery Guy");
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
