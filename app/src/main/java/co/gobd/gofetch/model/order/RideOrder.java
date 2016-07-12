package co.gobd.gofetch.model.order;

import co.gobd.gofetch.model.Location;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class RideOrder extends OrderModel {
    private Location From;
    private Location To;
    private String[] VehiclePreference;

    public RideOrder(String name, String type, Location from, Location to,
                     String[] vehiclePreference) {
        super(name, type);
        this.From = from;
        this.To = to;
        this.VehiclePreference = vehiclePreference;
    }

    public Location getFrom() {
        return From;
    }

    public void setFrom(Location from) {
        From = from;
    }

    public Location getTo() {
        return To;
    }

    public void setTo(Location to) {
        To = to;
    }

    public String[] getVehiclePreference() {
        return VehiclePreference;
    }

    public void setVehiclePreference(String[] vehiclePreference) {
        VehiclePreference = vehiclePreference;
    }
}
