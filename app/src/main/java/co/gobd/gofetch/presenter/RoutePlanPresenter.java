package co.gobd.gofetch.presenter;

import com.google.android.gms.location.places.Place;

import co.gobd.gofetch.view.RoutePlanView;

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
     * @param place       Place received from Google Place Picker
     * @param requestCode Code to determine which EditText is selected
     */
    //FIXME Make requestCode as Enum
    public void onPlaceDataReceived(Place place, int requestCode) {
        switch (requestCode) {
            case REQUEST_CODE_STARTING_POINT:
                routePlanView.setFromEditTextLocation(place.getName().toString());
                routePlanView.setStartingPoint(place.getLatLng());
                break;

            case REQUEST_CODE_DESTINATION_POINT:
                routePlanView.setToEditTextLocation(place.getName().toString());
                routePlanView.setDestinationPoint(place.getLatLng());
                break;
        }
    }


    public void onButtonClick() {
        // TODO Implement the "Next" button click behavior here
        String startingPointAddress = routePlanView.getStartingPointAddress();
        if (startingPointAddress.isEmpty()) {
            routePlanView.showErrorOnEmptyStartingPointAddress();
            return;
        }

        String destinationAddress = routePlanView.getDestinationAddress();
        if (destinationAddress.isEmpty()) {
            routePlanView.showErrorOnEmptyDestinationAddress();
            return;
        }

    }

}
