package co.gobd.gofetch.callback;

import java.util.List;

import co.gobd.gofetch.model.Order;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public interface OnDataReceive {
    void onReceive(List<Order> orders);
}
