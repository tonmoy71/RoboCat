package co.gobd.gofetch.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.fragment.RideFragmentCallback;
import co.gobd.gofetch.ui.fragment.RoutePlanFragment;

public class RideActivity extends AppCompatActivity implements RideFragmentCallback {

    private static final String TAG = "RideActivity";
    private static final String FRAGMENT_TAG_ROUTE_PLAN = "ROUTE_PLAN_FRAGMENT";

    RoutePlanFragment routePlanFragment;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        //Override default onCreate transition
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        startRoutePlanFragment();
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

        RoutePlanFragment routePlanFragment = new RoutePlanFragment();
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(0, R.anim.push_out_right, R.anim.pull_in_right, R.anim.push_out_right)
                .replace(R.id.layout_ride_activity, routePlanFragment, FRAGMENT_TAG_ROUTE_PLAN)
                //.addToBackStack(null)
                .commit();
    }

    //Override default onBackPressed transition (by Nabil)
    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
