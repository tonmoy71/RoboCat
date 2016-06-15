package co.gobd.gofetch.model.order;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class PackageList {

    @NonNull
    @SerializedName("Item")
    @Expose
    public String item;

    @NonNull
    @SerializedName("Quantity")
    @Expose
    public int quantity;

    @SerializedName("PicUrl")
    @Expose
    public String picUrl;

    @SerializedName("TotalPlusVAT")
    @Expose
    public int totalPlusVAT;

    @SerializedName("VATAmount")
    @Expose
    public int vatAmount;

    @SerializedName("Price")
    @Expose
    public int price;

    @SerializedName("VAT")
    @Expose
    public int vat;

    @SerializedName("Total")
    @Expose
    public int total;

    @SerializedName("Weight")
    @Expose
    public int weight;


    public PackageList(@NonNull String item, @NonNull int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
