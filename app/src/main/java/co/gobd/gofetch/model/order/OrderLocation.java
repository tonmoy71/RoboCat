package co.gobd.gofetch.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

import co.gobd.gofetch.model.Point;

@Generated("org.jsonschema2pojo")
public class OrderLocation {

    @SerializedName("Address")
    @Expose
    public String address;

    @SerializedName("PostalCode")
    @Expose
    public String postalCode;

    @SerializedName("Floor")
    @Expose
    public String floor;

    @SerializedName("HouseNumber")
    @Expose
    public String houseNumber;

    @SerializedName("AddressLine1")
    @Expose
    public String addressLine1;

    @SerializedName("AddressLine2")
    @Expose
    public String addressLine2;

    @SerializedName("Country")
    @Expose
    public String country;

    @SerializedName("City")
    @Expose
    public String city;

    @SerializedName("State")
    @Expose
    public String state;

    @SerializedName("Locality")
    @Expose
    public String locality;

    @SerializedName("Point")
    @Expose
    public Point point;

    @SerializedName("Provider")
    @Expose
    public String provider;

}
