package co.gobd.gofetch.network;

import java.util.List;

import co.gobd.gofetch.config.Url;
import co.gobd.gofetch.model.SupportedOrder;
import co.gobd.gofetch.model.order.BaseOrder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface OrderApi {

    @GET(Url.PATH_SUPPORTED_ORDER)
    Call<List<SupportedOrder>> getSupportedOrders();

    @POST(Url.PATH_POST_ORDER)
    Call<Void> postOrder(@Body BaseOrder order);

}
