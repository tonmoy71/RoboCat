package co.gobd.gofetch.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gobd.gofetch.R;
import co.gobd.gofetch.view.RoutePlanView;

public class RoutePlanFragment extends Fragment implements RoutePlanView {

    private static final String TAG = "RoutePlanFragment";

    /* Initialize Google Place Picker*/
    final int FROM_PLACE_PICKER_REQUEST = 1;
    final int TO_PLACE_PICKER_REQUEST = 2;
    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

    /* Initialize view */
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
    void onBtnRouteNextClick() {
        //TODO implement
    }


    // Google Place Picker returns the result here
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FROM_PLACE_PICKER_REQUEST:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Place place = PlacePicker.getPlace(getContext(), data);
                        Log.i(TAG, place.getName().toString());
                        break;
                }
            case TO_PLACE_PICKER_REQUEST:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Place place = PlacePicker.getPlace(getContext(), data);
                        Log.i(TAG, place.getName().toString());
                        break;
                }

        }
    }

    @OnClick(R.id.et_from_location)
    void onFromClick() {
        try {
            startActivityForResult(builder.build(getActivity()),
                    FROM_PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.et_to_location)
    void onToClick() {
        try {
            startActivityForResult(builder.build(getActivity()),
                    TO_PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getFromLocationAddress() {

    }

    @Override
    public void getToLocationAddress() {

    }

    @Override
    public void getFromPoint() {

    }

    @Override
    public void getToPoint() {

    }

    @Override
    public void onNextButtonCLick() {

    }

    @Override
    public void updateFromLocation() {

    }

    @Override
    public void updateToLocation() {

    }
}
