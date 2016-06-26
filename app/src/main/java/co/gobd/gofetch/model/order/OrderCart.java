package co.gobd.gofetch.model.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class OrderCart {

  @SerializedName("PackageList") @Expose public List<PackageList> packageList =
      new ArrayList<PackageList>();

  @SerializedName("TotalVATAmount") @Expose public int totalVATAmount;

  @SerializedName("SubTotal") @Expose public int subTotal;

  @SerializedName("ServiceCharge") @Expose public int serviceCharge;

  @SerializedName("TotalWeight") @Expose public int totalWeight;

  @SerializedName("TotalToPay") @Expose public int totalToPay;
}
