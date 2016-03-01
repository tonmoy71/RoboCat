package co.gobd.gofetch.model.order;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tonmoy on 29-Feb-16.
 */
public class BaseOrder {

    @SerializedName("Name")
    String name;

    @SerializedName("Type")
    String type;

    @SerializedName("PayloadType")
    String payloadType;

    @SerializedName("User")
    String user;

    @SerializedName("ETA")
    String eta;

    @SerializedName("ETAMinutes")
    double etaMinutes;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public String getUser() {
        return user;
    }

    public String getEta() {
        return eta;
    }

    public double getEtaMinutes() {
        return etaMinutes;
    }

    public BaseOrder(String name, String type) {
        this.name = name;
        this.type = type;
    }


}
