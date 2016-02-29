package co.gobd.gofetch.model.order;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class BaseOrder {

    String name;
    String Type;
    String payloadType;
    String user;
    String ETA;
    double ETAMinutes;

    public String getName() {
        return name;
    }

    public String getType() {
        return Type;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public String getUser() {
        return user;
    }

    public String getETA() {
        return ETA;
    }

    public double getETAMinutes() {
        return ETAMinutes;
    }

    public BaseOrder(String name, String type) {
        this.name = name;
        this.Type = type;
    }


}
