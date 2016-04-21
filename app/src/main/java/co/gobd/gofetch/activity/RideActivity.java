package co.gobd.gofetch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.fragment.RideFragmentCallback;
import co.gobd.gofetch.ui.fragment.RoutePlanFragment;


public class RideActivity extends AppCompatActivity implements RideFragmentCallback {

    private static final String TAG = "RideActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        startRoutePlanFragment();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    // Fragment callback implementation
    @Override
    public void loadConfirmationFragment(Bundle bundle) {
        Log.i(TAG, bundle.toString());
    }


    private void startRoutePlanFragment() {
        RoutePlanFragment routePlanFragment = new RoutePlanFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_ride_activity, routePlanFragment)
                .commit();
    }
}
