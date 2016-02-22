package co.gobd.gofetch.service;

import android.util.Log;

import java.util.List;

import co.gobd.gofetch.callback.OnDataReceive;
import co.gobd.gofetch.model.Order;
import co.gobd.gofetch.network.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Call<List<Order>> call = client.getSupportedOrderApi().getSupportedOrders();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccess()) {
                    onDataReceive.onReceive(response.body());
                    Log.i(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

            }
        });

    }
}
