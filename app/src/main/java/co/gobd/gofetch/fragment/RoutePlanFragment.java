package co.gobd.gofetch.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gobd.gofetch.R;
import co.gobd.gofetch.callback.RideFragmentCallback;
import co.gobd.gofetch.enums.LocationTypeEnum;
import co.gobd.gofetch.presenter.RoutePlanPresenter;
import co.gobd.gofetch.utility.Constant;
import co.gobd.gofetch.view.RoutePlanView;

import static co.gobd.gofetch.utility.Constant.*;

public class RoutePlanFragment extends Fragment implements RoutePlanView {

    private static final String TAG = "RoutePlanFragment";

    /* Initialize view with ButterKnife */
    @Bind(R.id.et_start_location)
    MaterialEditText etStartingLocation;

    @Bind(R.id.et_start_address)
    MaterialEditText etStartAddress;

    @Bind(R.id.et_start_note)
    MaterialEditText etStartNote;

    @Bind(R.id.et_destination_location)
    MaterialEditText etDestinationLocation;

    @Bind(R.id.et_destination_address)
    MaterialEditText etDestinationAddress;

    @Bind(R.id.et_destination_note)
    MaterialEditText etNoteDestination;

    /* Flag to determine whether GooglePlacePicker is already opened or not */
    boolean isGooglePlacePickerAlreadyOpen;

    /* Initialize Google Place Picker*/
    private PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

    /* Presenter */
    private RoutePlanPresenter routePlanPresenter;

    /* Starting point and destination positions */
    private LatLng startingPoint;
    private LatLng destinationPoint;

    /* Callback to update activity */
    private RideFragmentCallback callback;

    public RoutePlanFragment() {
        //Empty constructor for fragment initialization
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route_plan, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        routePlanPresenter = new RoutePlanPresenter(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Casting the context into RideFragmentCallback
        // to update it's attached activity
        callback = (RideFragmentCallback) context;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_route_next)
    void onButtonClick() {
        routePlanPresenter.onButtonClick();
    }

    // Google Place Picker returns the result here
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_STARTING_POINT) {
            isGooglePlacePickerAlreadyOpen = false;
            if (resultCode == Activity.RESULT_OK) {
                Place place = PlacePicker.getPlace(getContext(), data);
                routePlanPresenter.onPlaceDataReceived(place, REQUEST_CODE_STARTING_POINT);

            }

        } else if (requestCode == REQUEST_CODE_DESTINATION_POINT) {
            isGooglePlacePickerAlreadyOpen = false;
            if (resultCode == Activity.RESULT_OK) {
                Place place = PlacePicker.getPlace(getContext(), data);
                routePlanPresenter.onPlaceDataReceived(place, REQUEST_CODE_DESTINATION_POINT);

            }

        }
    }

    @OnClick(R.id.et_start_location)
    void onFromClick() {
        // Starts Google Place Picker UI control
        try {
            if (!isGooglePlacePickerAlreadyOpen) {
                isGooglePlacePickerAlreadyOpen = true;
                startActivityForResult(builder.build(getActivity()),
                        REQUEST_CODE_STARTING_POINT);
            }
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.et_destination_location)
    void onToClick() {
        // Starts Google Place Picker UI control
        try {
            if (!isGooglePlacePickerAlreadyOpen) {
                isGooglePlacePickerAlreadyOpen = true;
                startActivityForResult(builder.build(getActivity()),
                        REQUEST_CODE_DESTINATION_POINT);
            }
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getStartingPointAddress() {
        return etStartAddress.getText().toString();
    }

    @Override
    public String getDestinationAddress() {
        return etDestinationAddress.getText().toString();
    }

    @Override
    public LatLng getDestinationPoint() {
        return destinationPoint;
    }

    @Override
    public void setDestinationPoint(LatLng latLng) {
        destinationPoint = latLng;
    }

    @Override
    public void setDestinationLocationText(String placeName) {
        etDestinationLocation.setText(placeName);
    }

    @Override
    public String getStartingPointNote() {
        return etStartNote.getText().toString();
    }

    @Override
    public String getDestinationPointNote() {
        return etNoteDestination.getText().toString();
    }

    @Override
    public void showErrorOnEmptyAddress(LocationTypeEnum locationType) {
        if (locationType == LocationTypeEnum.STARTING_POINT) {
            //TODO Shake etStartLocation
        } else if (locationType == LocationTypeEnum.DESTINATION_POINT) {
            //TODO Shake etDestinationLocation
        }
    }

    @Override
    public void onReceiveRouteData(Bundle bundle) {
        callback.loadConfirmationFragment(bundle);
    }

    @Override
    public LatLng getStartingPoint() {
        return startingPoint;
    }

    @Override
    public void setStartingPoint(LatLng latLng) {
        startingPoint = latLng;
    }

    @Override
    public void setStartingLocationText(String placeName) {
        etStartingLocation.setText(placeName);
    }


}
