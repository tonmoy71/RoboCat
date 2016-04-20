package co.gobd.gofetch.model;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class Point {

    private String type;
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
