package co.gobd.gofetch.view;

import android.widget.EditText;

/**
 * Created by tonmoy on 13-Jan-16.
 */
public interface RoutePlanView {

    String getFromLocation();

    String getToLocation();

    void showEmptyFieldError();

}