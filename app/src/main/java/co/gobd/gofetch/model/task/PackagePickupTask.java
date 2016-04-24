package co.gobd.gofetch.model.task;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public class PackagePickupTask extends JobTask {

    private String JobTaskStateString;
    private String State;

    public PackagePickupTask(String jobTaskStateString, String state) {
        super(JobTaskTypes.PACKAGE_PICKUP, "Picking Up Package");
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
