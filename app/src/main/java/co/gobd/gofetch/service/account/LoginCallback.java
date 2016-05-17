package co.gobd.gofetch.service.account;

import co.gobd.gofetch.network.ConnectionCallback;

/**
 * Created by tonmoy on 08-May-16.
 */
public interface LoginCallback extends ConnectionCallback {
    void onLoginSuccess(String accessToken);

    void onLoginFailure();

}
