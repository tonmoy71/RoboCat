package co.gobd.gofetch.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public abstract class OrderModel {

    @SerializedName("Name")
    @Expose
    public String name;

    @SerializedName("From")
    @Expose
    public OrderLocation from;

    @SerializedName("To")
    @Expose
    public OrderLocation to;

    @SerializedName("Type")
    @Expose
    public String type;

    @SerializedName("PayloadType")
    @Expose
    public String payloadType;

    @SerializedName("UserId")
    @Expose
    public String userId;

    @SerializedName("OrderLocation")
    @Expose
    public OrderLocation orderLocation;

    @SerializedName("ETA")
    @Expose
    public String eTA;

    @SerializedName("ETAMinutes")
    @Expose
    public int eTAMinutes;

    @SerializedName("PaymentMethod")
    @Expose
    public String paymentMethod;

    @SerializedName("Description")
    @Expose
    public String description;

    @SerializedName("OrderCart")
    @Expose
    public OrderCart orderCart;

    public OrderModel(String name, String type) {
        this.name = name;
        this.type = type;
    }

}
