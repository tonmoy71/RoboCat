package co.gobd.gofetch.model.order;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class Point {
    private String type;
    private String[] coordinates;

    public String getType() {
        return type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Point [Type = " + type + ", coordinates = " + coordinates + "]";
    }
}
