package co.gobd.gofetch.model.order;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public abstract class OrderModel {

    String Name;
    String Type;
    String PayloadType;
    String User;
    String ETA;
    double ETAMinutes;

    public OrderModel(String name, String type) {
        this.Name = name;
        this.Type = type;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getPayloadType() {
        return PayloadType;
    }

    public String getUser() {
        return User;
    }

    public String getETA() {
        return ETA;
    }

    public double getETAMinutes() {
        return ETAMinutes;
    }


}
