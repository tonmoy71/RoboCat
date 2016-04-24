package co.gobd.gofetch.network;

import java.util.List;

import co.gobd.gofetch.config.ApiEndpoint;
import co.gobd.gofetch.model.order.OrderModel;
import co.gobd.gofetch.model.order.SupportedOrder;
import co.gobd.gofetch.model.task.JobTask;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface Api {

    @GET(ApiEndpoint.TaskCat.GET_SUPPORTED_ORDER)
    Call<List<SupportedOrder>> getSupportedOrders();

    @POST(ApiEndpoint.TaskCat.POST_ORDER)
    Call<Void> postOrder(@Body OrderModel order);

    @GET(ApiEndpoint.TaskCat.GET_TASKS_FOR_A_JOB)
    Call<JobTask> getTasksForAJob(@Path("jobId") String jobId);

}
