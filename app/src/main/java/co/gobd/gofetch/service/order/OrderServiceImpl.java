package co.gobd.gofetch.service.order;

import java.util.List;

import co.gobd.gofetch.model.order.SupportedOrder;
import co.gobd.gofetch.model.order.OrderModel;
import co.gobd.gofetch.network.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class OrderServiceImpl implements OrderService {

    Api api;

    // Constructed by dagger
    public OrderServiceImpl(Api api) {
        this.api = api;
    }

    @Override
    public void postOrder(OrderModel order, final PostOrderCallback callback) {
        Call<Void> call = api.postOrder(order);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onPostOrderSuccess();
                } else {
                    callback.onPostOrderFailure();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onConnectionError();
            }
        });
    }

    @Override
    public void getAllSupportedOrder(final SupportedOrderCallback callback) {
        Call<List<SupportedOrder>> call = api.getSupportedOrders();
        call.enqueue(new Callback<List<SupportedOrder>>() {
            @Override
            public void onResponse(Call<List<SupportedOrder>> call, Response<List<SupportedOrder>> response) {
                if (response.isSuccessful()) {
                    // Pass the List<SupportedOrder> to this method
                    callback.onReceiveOrderSuccess(response.body());
                } else {
                    callback.onReceiveOrderFailure();
                }
            }

            @Override
            public void onFailure(Call<List<SupportedOrder>> call, Throwable t) {
                callback.onConnectionError();
            }
        });

    }
}
