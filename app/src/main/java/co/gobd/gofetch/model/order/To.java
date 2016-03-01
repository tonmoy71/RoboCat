package co.gobd.gofetch.model.order;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class To {

    @SerializedName("Address")
    private String address;

    @SerializedName("Point")
    private Point point;

    public To(String address, Point point) {
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
        return "To [address = " + address + ", point = " + point + "]";
    }
}