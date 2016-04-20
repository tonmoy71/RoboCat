package co.gobd.gofetch.model;

/**
 * Created by tonmoy on 20-Apr-16.
 */
public class Location {

    private Point Point;
    private String Address;

    public Location(co.gobd.gofetch.model.Point point, String address) {
        Point = point;
        Address = address;
    }

    public co.gobd.gofetch.model.Point getPoint() {
        return Point;
    }

    public void setPoint(co.gobd.gofetch.model.Point point) {
        Point = point;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
