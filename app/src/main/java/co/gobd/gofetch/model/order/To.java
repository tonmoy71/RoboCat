package co.gobd.gofetch.model.order;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class To {
    private String Address;
    private Point Point;

    public String getAddress() {
        return Address;
    }
    public Point getPoint() {
        return Point;
    }

    @Override
    public String toString() {
        return "To [Address = " + Address + ", Point = " + Point + "]";
    }
}