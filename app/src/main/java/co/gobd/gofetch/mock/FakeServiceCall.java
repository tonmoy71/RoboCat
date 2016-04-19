package co.gobd.gofetch.mock;

import co.gobd.gofetch.model.order.BaseOrder;
import co.gobd.gofetch.model.order.From;
import co.gobd.gofetch.model.order.Point;
import co.gobd.gofetch.model.order.RideOrder;
import co.gobd.gofetch.model.order.To;
import co.gobd.gofetch.service.BaseTrackerService;
import co.gobd.gofetch.service.OrderServiceImpl;
import co.gobd.gofetch.service.SignalRService;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class FakeServiceCall {

    // Start SignalR service
    public static void startSignalR() {
        BaseTrackerService trackerService = new SignalRService();
        trackerService.setup();
        trackerService.startConnection();
        trackerService.receiveData();
    }


    public static void postOrder() {
        OrderServiceImpl service = new OrderServiceImpl();
        BaseOrder order =  createFakeOrder();

    }

    private static BaseOrder createFakeOrder() {
        String name = "Fahim";
        String type = "Ride";
        From from = new From("Banani", new Point("Point", new String[]{"90", "21"}));
        To to = new To("Mohammadpur", new Point("Point", new String[]{"90", "21"}));
        String[] vehiclePreference = new String[]{"Rickshaw", "CNG"};

        BaseOrder order = new RideOrder(name, type, from, to, vehiclePreference);
        return order;
    }
}
