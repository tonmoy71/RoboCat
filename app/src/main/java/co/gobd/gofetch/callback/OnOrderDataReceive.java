package co.gobd.gofetch.callback;

import java.util.List;

import co.gobd.gofetch.model.SupportedOrder;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface OnOrderDataReceive {
    void onReceive(List<SupportedOrder> supportedOrders);
}
