package co.gobd.gofetch.network;

import java.util.List;

import co.gobd.gofetch.config.Url;
import co.gobd.gofetch.model.Order;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface SupportedOrderApi {

    @GET(Url.PATH_SUPPORTED_ORDER)
    void getSupportedOrders(Callback<List<Order>> orders);

}
