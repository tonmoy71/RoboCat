package co.gobd.gofetch.service.order;

import co.gobd.gofetch.model.order.SupportedOrder;
import co.gobd.gofetch.network.ConnectionCallback;
import java.util.List;

/**
 * Created by tonmoy on 19-Apr-16.
 */
public interface SupportedOrderCallback extends ConnectionCallback {
  void onReceiveOrderSuccess(List<SupportedOrder> orders);

  void onReceiveOrderFailure();
}
