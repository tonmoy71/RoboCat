package co.gobd.gofetch.service;

import android.util.Log;

import java.util.List;

import co.gobd.gofetch.callback.OnOrderDataReceive;
import co.gobd.gofetch.config.Url;
import co.gobd.gofetch.model.SupportedOrder;
import co.gobd.gofetch.network.OrderApi;
import co.gobd.gofetch.network.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class SupportedOrderService {

    private static final String TAG = "SupportedOrderService";

    OnOrderDataReceive onOrderDataReceive;

    public SupportedOrderService(OnOrderDataReceive onOrderDataReceive) {
        this.onOrderDataReceive = onOrderDataReceive;
    }

    public void loadSupportedOrder() {
        OrderApi api = RestClient.getApi(Url.BASE_URL, OrderApi.class);
        Call<List<SupportedOrder>> call = api.getSupportedOrders();
        call.enqueue(new Callback<List<SupportedOrder>>() {
            @Override
            public void onResponse(Call<List<SupportedOrder>> call, Response<List<SupportedOrder>> response) {
                if (response.isSuccess()) {
                    onOrderDataReceive.onReceive(response.body());
                    Log.i(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<SupportedOrder>> call, Throwable t) {
                //Notify users if data is failed to load
            }
        });

    }
}
