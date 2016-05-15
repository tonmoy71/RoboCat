package co.gobd.gofetch.presenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.service.account.LoginCallback;
import co.gobd.gofetch.ui.view.LoginView;

/**
 * Created by tonmoy on 08-May-16.
 */
public class LoginPresenter {

    private WeakReference<LoginView> view;
    private AccountService service;

    @Inject
    public LoginPresenter(AccountService service) {
        this.service = service;
    }

    public void initialise(LoginView view) {
        this.view = new WeakReference<>(view);
    }

    public void validateCredentials() {
        if (view != null) {
            // Gets the actual loginView from its WeakReference
            final LoginView loginView = view.get();

            String userName = loginView.getUserName();
            if (userName == null || userName.isEmpty()) {
                loginView.showUserNameError();
                return;
            }

            String password = loginView.getPassword();
            if (password == null || password.isEmpty()) {
                loginView.showPasswordError();
                return;
            }

            loginView.startProgress();

            service.login(userName, password, new LoginCallback() {
                @Override
                public void onLoginSuccess(String accessToken) {
                    loginView.stopProgress();
                    loginView.startSupportedOrderActivity();
                }

                @Override
                public void onLoginFailure() {
                    loginView.stopProgress();
                    loginView.showLoginError();
                }

                @Override
                public void onUserNameError() {
                    loginView.stopProgress();
                    loginView.showUserNameError();
                }

                @Override
                public void onPasswordError() {
                    loginView.stopProgress();
                    loginView.showPasswordError();
                }

                @Override
                public void onConnectionError() {
                    loginView.stopProgress();
                    loginView.showConnectionError();
                }
            });
        }

    }

    public void onDestroy() {
        view = null;
    }

}
