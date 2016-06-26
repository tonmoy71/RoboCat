package co.gobd.gofetch.service.order;

import co.gobd.gofetch.model.order.OrderModel;

/**
 * Created by tonmoy on 19-Apr-16.
 */
public interface OrderService {
  void postOrder(OrderModel order, PostOrderCallback callback);

  void getAllSupportedOrder(SupportedOrderCallback callback);
}
