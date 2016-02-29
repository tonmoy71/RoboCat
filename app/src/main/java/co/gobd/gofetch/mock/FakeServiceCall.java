package co.gobd.gofetch.mock;

import co.gobd.gofetch.model.order.BaseOrder;
import co.gobd.gofetch.model.order.From;
import co.gobd.gofetch.model.order.RideOrder;
import co.gobd.gofetch.model.order.To;
import co.gobd.gofetch.service.OrderService;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class FakeServiceCall {

    public static void postOrder() {
        OrderService service = new OrderService();
        BaseOrder order = createFakeOrder();
        service.postOrder(order);
    }

    private static BaseOrder createFakeOrder() {

        String name = "Fahim";
        String type = "Ride";
        From from = null;
        To to = null;
        String[] vehiclePreference = new String[]{"Rickshaw", "CNG"};

        BaseOrder order = new RideOrder(name, type, from, to, vehiclePreference);
        return order;
    }
}
