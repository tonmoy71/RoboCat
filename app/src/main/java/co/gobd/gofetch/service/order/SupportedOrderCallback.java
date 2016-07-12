package co.gobd.gofetch.service.order;

import java.util.List;

import co.gobd.gofetch.model.order.SupportedOrder;
import co.gobd.gofetch.network.ConnectionCallback;

/**
 * Created by tonmoy on 19-Apr-16.
 */
public interface SupportedOrderCallback extends ConnectionCallback {
    void onReceiveOrderSuccess(List<SupportedOrder> orders);

    void onReceiveOrderFailure();
}
