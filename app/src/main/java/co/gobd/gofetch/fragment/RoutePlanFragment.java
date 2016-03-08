package co.gobd.gofetch.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;

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
import co.gobd.gofetch.presenter.RoutePlanPresenter;
import co.gobd.gofetch.view.RoutePlanView;

import static co.gobd.gofetch.utility.Constant.*;

public class RoutePlanFragment extends Fragment implements RoutePlanView {

    private static final String TAG = "RoutePlanFragment";

    /* Initialize Google Place Picker*/
    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

    /* Presenter */
    RoutePlanPresenter routePlanPresenter;

    /* Starting point and destination positions */
    LatLng startingPoint;
    LatLng destinationPoint;

    /* Initialize view with ButterKnife */
    @Bind(R.id.cv_from)
    CardView cvFrom;
    @Bind(R.id.tv_title_from)
    TextView tvTitleFrom;
    @Bind(R.id.et_from_location)
    MaterialEditText etFromLocation;
    @Bind(R.id.et_note_from)
    MaterialEditText etNoteFrom;
    @Bind(R.id.cv_to)
    CardView cvTo;
    @Bind(R.id.tv_title_to)
    TextView tvTitleTo;
    @Bind(R.id.et_to_location)
    MaterialEditText etToLocation;
    @Bind(R.id.et_note_to)
    MaterialEditText etNoteTo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_route_plan, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        routePlanPresenter = new RoutePlanPresenter(this);
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
        switch (requestCode) {
            case REQUEST_CODE_STARTING_POINT:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Place place = PlacePicker.getPlace(getContext(), data);
                        routePlanPresenter.onPlaceDataReceived(place, REQUEST_CODE_STARTING_POINT);
                        break;
                }
                break;

            case REQUEST_CODE_DESTINATION_POINT:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Place place = PlacePicker.getPlace(getContext(), data);
                        routePlanPresenter.onPlaceDataReceived(place, REQUEST_CODE_DESTINATION_POINT);
                        break;
                }
                break;
        }
    }

    @OnClick(R.id.et_from_location)
    void onFromClick() {
        // Starts Google Place Picker UI control
        try {
            startActivityForResult(builder.build(getActivity()),
                    REQUEST_CODE_STARTING_POINT);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.et_to_location)
    void onToClick() {
        // Starts Google Place Picker UI control
        try {
            startActivityForResult(builder.build(getActivity()),
                    REQUEST_CODE_DESTINATION_POINT);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getStartingPointAddress() {
        return etFromLocation.getText().toString();
    }

    @Override
    public String getDestinationAddress() {
        return etToLocation.getText().toString();
    }

    @Override
    public void setStartingPoint(LatLng latLng) {
        startingPoint = latLng;
    }

    @Override
    public void setDestinationPoint(LatLng latLng) {
        destinationPoint = latLng;
    }


    @Override
    public void setFromEditTextLocation(String placeName) {
        etFromLocation.setText(placeName);
    }

    @Override
    public void setToEditTextLocation(String placeName) {
        etToLocation.setText(placeName);
    }

    @Override
    public void showErrorOnEmptyStartingPointAddress() {
        //TODO Implement a shake animation on etFromLocation
    }

    @Override
    public void showErrorOnEmptyDestinationAddress() {
        //TODO Implement a shake animation on etToLocation
    }
}
