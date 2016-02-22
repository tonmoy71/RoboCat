package co.gobd.gofetch.network;

import java.util.List;

import co.gobd.gofetch.config.Url;
import co.gobd.gofetch.model.Order;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface ISupportedOrderApi {

    @GET(Url.PATH_SUPPORTED_ORDER)
    Call<List<Order>> getSupportedOrders();

}
