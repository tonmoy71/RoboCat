package co.gobd.gofetch.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.gobd.gofetch.R;
import co.gobd.gofetch.callback.RideFragmentCallback;
import co.gobd.gofetch.fragment.RoutePlanFragment;

public class RideActivity extends AppCompatActivity implements RideFragmentCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        startRoutePlanFragment();
    }

    // Fragment callback implementation
    @Override
    public void loadConfirmationFragment() {
        //TODO Start the Confirmation fragment here
    }


    private void startRoutePlanFragment() {
        RoutePlanFragment routePlanFragment = new RoutePlanFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_ride_activity, routePlanFragment)
                .commit();
    }
}
