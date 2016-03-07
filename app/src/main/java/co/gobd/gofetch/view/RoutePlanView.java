package co.gobd.gofetch.view;

import android.view.View;

/**
 * Created by tonmoy on 07-Mar-16.
 */
public interface RoutePlanView {


    void getFromLocationAddress();

    void getToLocationAddress();

    void getFromPoint();

    void getToPoint();

    void onNextButtonCLick();

    void updateFromLocation();

    void updateToLocation();
}
