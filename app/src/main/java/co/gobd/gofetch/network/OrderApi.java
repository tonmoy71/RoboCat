package co.gobd.gofetch.network;

import java.util.List;

import co.gobd.gofetch.config.ApiEndpoint;
import co.gobd.gofetch.model.order.OrderModel;
import co.gobd.gofetch.model.order.SupportedOrder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface OrderApi {

    @GET(ApiEndpoint.TaskCat.GET_SUPPORTED_ORDER)
    Call<List<SupportedOrder>> getSupportedOrders();

    @POST(ApiEndpoint.TaskCat.POST_ORDER)
    Call<Void> postOrder(@Body OrderModel order);

}
