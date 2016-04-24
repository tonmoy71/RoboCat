package co.gobd.gofetch.model.task;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public abstract class JobTask {

    private String Type;
    private String Name;

    public JobTask(String type, String name) {
        Type = type;
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public String getName() {
        return Name;
    }
}
