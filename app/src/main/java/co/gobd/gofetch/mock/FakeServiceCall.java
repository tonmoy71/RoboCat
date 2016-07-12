package co.gobd.gofetch.mock;

import co.gobd.gofetch.model.Location;
import co.gobd.gofetch.model.Point;
import co.gobd.gofetch.model.order.OrderModel;
import co.gobd.gofetch.model.order.RideOrder;
import co.gobd.gofetch.service.tracker.BaseTrackerService;
import co.gobd.gofetch.service.tracker.SignalRService;

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

    }

    public static OrderModel createFakeOrder() {
        String name = "Fahim";
        String type = "Ride";
        Location from = new Location(new Point("Point", new String[]{"90", "21"}), "Banani");
        Location to = new Location(new Point("Point", new String[]{"90", "21"}), "Mohammadpur");
        String[] vehiclePreference = new String[]{"Rickshaw", "CNG"};

        return new RideOrder(name, type, from, to, vehiclePreference);
    }
}
