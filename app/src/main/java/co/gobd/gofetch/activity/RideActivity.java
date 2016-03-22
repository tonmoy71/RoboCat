package co.gobd.gofetch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import co.gobd.gofetch.R;
import co.gobd.gofetch.callback.RideFragmentCallback;
import co.gobd.gofetch.fragment.RoutePlanFragment;

public class RideActivity extends AppCompatActivity implements RideFragmentCallback {

    private static final String TAG = "RideActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);
        //Override Default Transition
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        startRoutePlanFragment();

    }

    // Fragment callback implementation
    @Override
    public void loadConfirmationFragment(Bundle bundle) {
        Log.i(TAG, bundle.toString());
    }


    private void startRoutePlanFragment() {
        RoutePlanFragment routePlanFragment = new RoutePlanFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_ride_activity, routePlanFragment)
                .commit();
    }
}
