package co.gobd.gofetch.presenter;

import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.service.account.LoginCallback;
import co.gobd.gofetch.ui.view.LoginView;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/**
 * Created by tonmoy on 08-May-16.
 */
public class LoginPresenter {

  private WeakReference<LoginView> weakLoginView;
  private AccountService service;
  private LoginView loginView;

  @Inject public LoginPresenter(AccountService service) {
    this.service = service;
  }

  public void initialise(LoginView view) {
    this.weakLoginView = new WeakReference<>(view);

    // Gets the actual loginView from its WeakReference
    loginView = this.weakLoginView.get();
  }

  public boolean isValidCredentials() {
    if (loginView != null) {

      String userName = loginView.getUserName();
      if (userName == null || userName.isEmpty()) {
        loginView.showUserNameEmptyError();
        return false;
      }

      String password = loginView.getPassword();
      if (password == null || password.isEmpty()) {
        loginView.showPasswordEmptyError();
        return false;
      }

      if (password.length() < 6) {
        loginView.showPasswordLengthError();
        return false;
      }
      return true;
    }

    return false;
  }

  public void login() {

    String userName = loginView.getUserName();
    String password = loginView.getPassword();

    loginView.startProgress();

    service.login(userName, password, new LoginCallback() {
      @Override public void onLoginSuccess(String accessToken) {
        loginView.stopProgress();
        loginView.startSupportedOrderActivity();
      }

      @Override public void onLoginFailure() {
        loginView.stopProgress();
        loginView.showLoginError();
      }

      @Override public void onConnectionError() {
        loginView.stopProgress();
        loginView.showConnectionError();
      }
    });
  }

  public void onDestroy() {
    weakLoginView = null;
  }
}
