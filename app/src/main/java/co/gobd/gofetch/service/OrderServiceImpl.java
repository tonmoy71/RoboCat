package co.gobd.gofetch.service;

import android.util.Log;

import co.gobd.gofetch.config.ApiEndpoint;
import co.gobd.gofetch.model.order.BaseOrder;
import co.gobd.gofetch.network.OrderApi;
import co.gobd.gofetch.network.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class OrderServiceImpl {

    private static final String TAG = "OrderServiceImpl";

    public void postOrder(BaseOrder order) {
        OrderApi orderApi = RestClient.getApi(ApiEndpoint.TaskCat.BASE, OrderApi.class);
        Call<Void> call = orderApi.postOrder(order);

        Log.i(TAG, order.toString());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "POST order successful, status code: " + response.code());
                } else {
                    Log.i(TAG, "POST order unsuccessful , status code: " + response.code());
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i(TAG, "POST order failure");
            }
        });
    }
}
