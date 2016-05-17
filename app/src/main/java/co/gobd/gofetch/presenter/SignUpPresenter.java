package co.gobd.gofetch.presenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import co.gobd.gofetch.model.account.UserModel;
import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.service.account.RegistrationCallback;
import co.gobd.gofetch.ui.view.SignUpView;

/**
 * Created by tonmoy on 16-May-16.
 */
public class SignUpPresenter {

    private WeakReference<SignUpView> weakSignUpView;
    private AccountService service;
    private SignUpView signUpView;

    @Inject
    public SignUpPresenter(AccountService service) {
        this.service = service;
    }

    public void initialise(SignUpView view) {
        this.weakSignUpView = new WeakReference<SignUpView>(view);

        // Gets the actual SIgnUpVIew from its weak reference
        signUpView = weakSignUpView.get();
    }

    public boolean isValidCredentials() {
        String userName = signUpView.getUserName();
        if (userName == null || userName.isEmpty()) {
            signUpView.showUserNameEmptyError();
            return false;
        }

        String password = signUpView.getPassword();
        if (password == null || password.isEmpty()) {
            signUpView.showPasswordEmptyError();
            return false;
        }

        if (password.length() < 6) {
            signUpView.showPasswordLengthError();
            return false;
        }

        String confirmPassword = signUpView.getConfirmPassword();
        if (!password.equals(confirmPassword)) {
            signUpView.showPasswordMatchError();
            return false;
        }

        String email = signUpView.getEmail();
        if (!signUpView.isEmailPatternValid()) {
            signUpView.showInvalidEmailPatterError();
            return false;
        }

        String type = signUpView.getType();
        if (type != "USER") {
            return false;
        }

        return true;
    }

    public void register() {

        signUpView.startProgress();

        UserModel userModel = getUserModel();

        service.register(userModel, new RegistrationCallback() {
            @Override
            public void onRegistrationSuccess() {
                signUpView.stopProgress();
                signUpView.startLoginActivity();
            }

            @Override
            public void onRegistrationFailure() {
                signUpView.stopProgress();
                signUpView.showRegistrationError();
            }

            @Override
            public void onConnectionError() {


            }
        });

    }

    private UserModel getUserModel() {
        return null;
    }
}
