package co.gobd.gofetch.model;

import java.util.List;

import co.gobd.gofetch.model.task.JobTask;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public class JobModel {
    private String Name;
    private String State;
    private List<JobTask> Tasks;

    public JobModel(String name, String state, List<JobTask> tasks) {
        Name = name;
        State = state;
        Tasks = tasks;
    }
}
