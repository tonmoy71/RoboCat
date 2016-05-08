package co.gobd.gofetch.service.account;

/**
 * Created by tonmoy on 08-May-16.
 */
public interface LoginCallback extends co.gobd.gofetch.network.ConnectionCallback {
    void onLoginSuccess(String accessToken);

    void onLoginFailure();

    void onUserNameError();

    void onPasswordError();
}
