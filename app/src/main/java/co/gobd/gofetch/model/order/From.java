package co.gobd.gofetch.model.order;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class From {
    @SerializedName("Address")
    private String address;

    @SerializedName("Point")
    private Point point;

    public From(String address, co.gobd.gofetch.model.order.Point point) {
        this.address = address;
        this.point = point;
    }

    public String getAddress() {
        return address;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "From [Address = " + address + ", Point = " + point + "]";
    }
}