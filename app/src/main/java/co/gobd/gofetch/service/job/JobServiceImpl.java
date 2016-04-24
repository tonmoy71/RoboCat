package co.gobd.gofetch.service.job;

import co.gobd.gofetch.model.JobModel;
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
        Call<JobModel> call = api.getTasksForAJob(jobId);
        call.enqueue(new Callback<JobModel>() {
            @Override
            public void onResponse(Call<JobModel> call, Response<JobModel> response) {
                if (response.isSuccessful()) {
                    // Pass JobModel into this method
                    callback.onLoadTasksSuccess(response.body());
                } else {
                    callback.onLoadTasksFailure();
                }
            }

            @Override
            public void onFailure(Call<JobModel> call, Throwable t) {
                callback.onConnectionError();
            }
        });

    }
}
