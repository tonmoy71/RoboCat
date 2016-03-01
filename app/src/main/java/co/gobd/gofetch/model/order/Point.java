package co.gobd.gofetch.model.order;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class Point {
    @SerializedName("type")
    private String type;

    @SerializedName("coordinates")
    private String[] coordinates;

    public Point(String type, String[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Point [type = " + type + ", coordinates = " + coordinates.toString() + "]";
    }
}
