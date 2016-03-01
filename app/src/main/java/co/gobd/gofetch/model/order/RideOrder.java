package co.gobd.gofetch.model.order;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class RideOrder extends BaseOrder {

    @SerializedName("From")
    private From from;

    @SerializedName("To")
    private To to;

    @SerializedName("VehiclePreference")
    private String[] vehiclePreference;

    public RideOrder(String name, String type, From from, To to, String[] vehiclePreference) {
        super(name, type);

        this.from = from;
        this.to = to;
        this.vehiclePreference = vehiclePreference;

    }


}
