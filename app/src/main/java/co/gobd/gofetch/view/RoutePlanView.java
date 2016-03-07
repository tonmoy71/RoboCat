package co.gobd.gofetch.view;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by tonmoy on 07-Mar-16.
 */
public interface RoutePlanView {

    void getFromLocationAddress();

    void getToLocationAddress();

    void setStartingPoint(LatLng latLng);

    void setDestinationPoint(LatLng latLng);

    void setFromEditTextLocation(String placeName);

    void setToEditTextLocation(String placeName);
}
