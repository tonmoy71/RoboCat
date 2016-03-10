package co.gobd.gofetch.view;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by tonmoy on 07-Mar-16.
 */
public interface RoutePlanView {

    String getStartingPointAddress();

    String getDestinationAddress();

    void setStartingPoint(LatLng latLng);

    void setDestinationPoint(LatLng latLng);

    void setFromEditTextLocation(String placeName);

    void setToEditTextLocation(String placeName);

    void showErrorOnEmptyStartingPointAddress();

    void showErrorOnEmptyDestinationAddress();

    void loadConfirmationFragment();
}
