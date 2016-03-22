package co.gobd.gofetch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import co.gobd.gofetch.R;
import co.gobd.gofetch.callback.RideFragmentCallback;
import co.gobd.gofetch.fragment.RoutePlanFragment;

public class RideActivity extends AppCompatActivity implements RideFragmentCallback {

    private static final String TAG = "RideActivity";
    private final String FRAGMENT_TAG_ROUTE_PLAN = "ROUTE_PLAN_FRAGMENT";

    RoutePlanFragment routePlanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        // If savedInstanceState is not null, fragment may exist
        if (savedInstanceState != null) {
            // Look up the fragment that already exists by tag
            routePlanFragment = (RoutePlanFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_ROUTE_PLAN);
        }
        else if (routePlanFragment == null)
        {
            // Only create fragment if they haven't been instantiated already
            startRoutePlanFragment();
        }


    }

    // Fragment callback implementation
    @Override
    public void loadConfirmationFragment(Bundle bundle) {
        Log.i(TAG, bundle.toString());
    }


    /**
     * Creates a new instance of the RoutePlanFragment and adds it to the activity
     * Tag is given so that it can be found if fragment already exists
     */
    private void startRoutePlanFragment() {
        routePlanFragment = new RoutePlanFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_ride_activity, routePlanFragment, FRAGMENT_TAG_ROUTE_PLAN)
                .commit();
    }
}
