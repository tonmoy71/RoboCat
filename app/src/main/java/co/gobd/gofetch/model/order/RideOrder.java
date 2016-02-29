package co.gobd.gofetch.model.order;

import java.util.Arrays;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class RideOrder extends BaseOrder {


    // FIXME Use SerializedName
    private From From;
    private To To;
    private String[] VehiclePreference;

    @Override
    public String toString() {
        return "RideOrder{" +
                "From=" + From +
                ", To=" + To +
                ", VehiclePreference=" + Arrays.toString(VehiclePreference) +
                '}';
    }

    public RideOrder(String name, String type, From from, To to, String[] vehiclePreference) {
        super(name, type);

        this.From = from;
        this.To = to;
        this.VehiclePreference = vehiclePreference;


    }
}
