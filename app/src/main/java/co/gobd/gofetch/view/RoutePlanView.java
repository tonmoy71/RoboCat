package co.gobd.gofetch.view;

import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

import co.gobd.gofetch.enums.LocationTypeEnum;

/**
 * Created by tonmoy on 07-Mar-16.
 */
public interface RoutePlanView {

    /* Starting point information */
    LatLng getStartingPoint();
    void setStartingPoint(LatLng latLng);

    void setStartingLocationText(String placeName);
    String getStartingPointAddress();
    String getStartingPointNote();



    /* Destination information */
    LatLng getDestinationPoint();
    void setDestinationPoint(LatLng latLng);

    void setDestinationLocationText(String placeName);
    String getDestinationAddress();
    String getDestinationPointNote();

    void showErrorOnEmptyAddress(LocationTypeEnum locationType);

    void onReceiveRouteData(Bundle bundle);


}
