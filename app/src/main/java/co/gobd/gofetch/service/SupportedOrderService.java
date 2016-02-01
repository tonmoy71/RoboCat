package co.gobd.gofetch.service;

import android.util.Log;

import java.util.List;

import co.gobd.gofetch.callback.OnDataReceive;
import co.gobd.gofetch.model.Order;
import co.gobd.gofetch.network.RestClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class SupportedOrderService {

    private static final String TAG = "SupportedOrderService";

    OnDataReceive onDataReceive;

    public SupportedOrderService(OnDataReceive onDataReceive) {
        this.onDataReceive = onDataReceive;
    }

    public void loadSupportedOrder() {
        RestClient client = new RestClient();
        client.getSupportedOrderApi().getSupportedOrders(new Callback<List<Order>>() {
            @Override
            public void success(List<Order> orders, Response response) {
                onDataReceive.onReceive(orders);
                Log.i(TAG, orders.toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
