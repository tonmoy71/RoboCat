package co.gobd.gofetch.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

import co.gobd.gofetch.model.Location;

/**
 * Created by tonmoy on 20-Apr-16.
 */
@Generated("org.jsonschema2pojo")
public class DeliveryOrder extends OrderModel {

    @SerializedName("From")
    @Expose
    public Location from;

    @SerializedName("To")
    @Expose
    public Location to;

    @SerializedName("OrderCart")
    @Expose
    public OrderCart orderCart;

    @SerializedName("Name")
    @Expose
    public String name;

    @SerializedName("Type")
    @Expose
    public String type;

    @SerializedName("PackageDescription")
    @Expose
    public String packageDescription;

    @SerializedName("NoteToDeliveryMan")
    @Expose
    public String noteToDeliveryMan;

    @SerializedName("PayloadType")
    @Expose
    public String payloadType;

    @SerializedName("UserId")
    @Expose
    public String userId;

    @SerializedName("OrderLocation")
    @Expose
    public Location orderLocation;

    @SerializedName("ETA")
    @Expose
    public int eta;

    @SerializedName("ETAMinutes")
    @Expose
    public int etaMinutes;

    @SerializedName("PaymentMethod")
    @Expose
    public String paymentMethod;

    public DeliveryOrder(String name, String type) {
        super(name, type);
    }
}