package co.gobd.gofetch.service.job;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public interface JobService {
    void getTasksForAJob(String jobId, JobCallback callback);
}
