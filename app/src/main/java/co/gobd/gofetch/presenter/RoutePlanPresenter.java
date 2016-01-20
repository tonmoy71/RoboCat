package co.gobd.gofetch.presenter;

import android.util.Log;

import co.gobd.gofetch.view.RoutePlanView;

/**
 * Created by tonmoy on 13-Jan-16.
 */
public class RoutePlanPresenter {

    private static final String LOG_TAG = RoutePlanPresenter.class.getSimpleName();
    private RoutePlanView view;

    public RoutePlanPresenter(RoutePlanView view) {
        this.view = view;
    }

    public void onRequestRydeClicked() {
        String from = view.getFromLocation();
        String to = view.getToLocation();

        Log.i(LOG_TAG, from + ", " + to);

        if (from.isEmpty()) {
            view.showEmptyFieldError();
            return;
        }

        if (to.isEmpty()) {
            view.showEmptyFieldError();
            return;
        }
    }

}
