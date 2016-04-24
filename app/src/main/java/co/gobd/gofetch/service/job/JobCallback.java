package co.gobd.gofetch.service.job;

import co.gobd.gofetch.model.task.JobTask;
import co.gobd.gofetch.network.ConnectionCallback;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public interface JobCallback extends ConnectionCallback {
    void onLoadTasksSuccess(JobTask task);
    void onLoadTasksFailure();
}
