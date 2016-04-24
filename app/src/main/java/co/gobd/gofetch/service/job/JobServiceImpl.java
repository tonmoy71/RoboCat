package co.gobd.gofetch.service.job;

import co.gobd.gofetch.model.task.JobTask;
import co.gobd.gofetch.network.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 24-Apr-16.
 */
public class JobServiceImpl implements JobService {

    Api api;

    // Constructed by Dagger
    public JobServiceImpl(Api api) {
        this.api = api;
    }

    @Override
    public void getTasksForAJob(String jobId, final JobCallback callback) {
        Call<JobTask> call = api.getTasksForAJob(jobId);
        call.enqueue(new Callback<JobTask>() {
            @Override
            public void onResponse(Call<JobTask> call, Response<JobTask> response) {
                if (response.isSuccessful()) {
                    // Pass List<JobTask> into this method
                    callback.onLoadTasksSuccess(response.body());
                } else {
                    callback.onLoadTasksFailure();
                }
            }

            @Override
            public void onFailure(Call<JobTask> call, Throwable t) {
                callback.onConnectionError();
            }
        });

    }
}
