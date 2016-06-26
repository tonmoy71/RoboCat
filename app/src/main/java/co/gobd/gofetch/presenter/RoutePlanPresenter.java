package co.gobd.gofetch.presenter;

import android.os.Bundle;
import co.gobd.gofetch.ui.view.RoutePlanView;
import co.gobd.gofetch.utility.Constant;
import co.gobd.gofetch.utility.LocationType;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;

import static co.gobd.gofetch.utility.Constant.REQUEST_CODE_DESTINATION_POINT;
import static co.gobd.gofetch.utility.Constant.REQUEST_CODE_STARTING_POINT;

/**
 * Created by tonmoy on 07-Mar-16.
 */
public class RoutePlanPresenter {

  private RoutePlanView routePlanView;

  public RoutePlanPresenter(RoutePlanView routePlanView) {
    this.routePlanView = routePlanView;
  }

  /**
   * Updates the EditText with respective place name, also
   * sets the starting and destination point.
   *
   * @param place Place received from Google Place Picker
   * @param requestCode Code to determine which EditText is selected
   */
  public void onPlaceDataReceived(Place place, int requestCode) {
    if (place != null) {
      if (requestCode == REQUEST_CODE_STARTING_POINT) {
        routePlanView.setStartingLocationText(place.getName().toString());
        routePlanView.setStartingPoint(place.getLatLng());
      } else if (requestCode == REQUEST_CODE_DESTINATION_POINT) {
        routePlanView.setDestinationLocationText(place.getName().toString());
        routePlanView.setDestinationPoint(place.getLatLng());
      }
    }
  }

  public void onButtonClick() {

    String startingPointAddress = routePlanView.getStartingPointAddress();
    if (startingPointAddress.isEmpty()) {
      routePlanView.showErrorOnEmptyAddress(LocationType.STARTING_POINT);
    }

    String destinationPointAddress = routePlanView.getDestinationAddress();
    if (destinationPointAddress.isEmpty()) {
      routePlanView.showErrorOnEmptyAddress(LocationType.DESTINATION_POINT);
    }

    LatLng startingPoint = routePlanView.getStartingPoint();
    LatLng destinationPoint = routePlanView.getDestinationPoint();

    String startingPointNote = routePlanView.getStartingPointNote();
    String destinationPointNote = routePlanView.getDestinationPointNote();

    if (startingPoint != null && destinationPoint != null) {
      Bundle bundle = new Bundle();

      bundle.putParcelable(Constant.KEY_START_LATLNG, startingPoint);
      bundle.putParcelable(Constant.KEY_DESTINATION_LATLNG, destinationPoint);

      bundle.putString(Constant.KEY_START_ADDRESS, startingPointAddress);
      bundle.putString(Constant.KEY_DESTINATION_ADDRESS, destinationPointAddress);

      bundle.putString(Constant.KEY_START_NOTE, startingPointNote);
      bundle.putString(Constant.KEY_DESTINATION_NOTE, destinationPointNote);

      routePlanView.onReceiveRouteData(bundle);
    }
  }
}
