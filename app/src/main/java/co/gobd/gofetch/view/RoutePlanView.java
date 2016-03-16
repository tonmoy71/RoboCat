package co.gobd.gofetch.view;

import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

import co.gobd.gofetch.enums.LocationTypeEnum;

/**
 * Created by tonmoy on 07-Mar-16.
 */
public interface RoutePlanView {

    String getStartingPointAddress();

    String getDestinationAddress();

    void setFromEditTextLocation(String placeName);

    void setToEditTextLocation(String placeName);

    void showErrorOnEmptyAddress(LocationTypeEnum locationType);

    void onReceiveRouteData(Bundle bundle);

    LatLng getStartingPoint();

    void setStartingPoint(LatLng latLng);

    LatLng getDestinationPoint();

    void setDestinationPoint(LatLng latLng);

    String getStartingPointNote();

    String getDestinationPointNote();
}
