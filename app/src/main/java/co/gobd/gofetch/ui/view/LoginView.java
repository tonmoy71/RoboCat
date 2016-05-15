package co.gobd.gofetch.ui.view;

/**
 * Created by tonmoy on 08-May-16.
 */
public interface LoginView {
    String getUserName();

    String getPassword();

    void showUserNameError();

    void showPasswordError();

    void startProgress();

    void stopProgress();

    void startSupportedOrderActivity();

    void startSignupActivity();

    void showConnectionError();

    void showLoginError();
}
