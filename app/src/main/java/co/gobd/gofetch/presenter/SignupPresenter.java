package co.gobd.gofetch.presenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import co.gobd.gofetch.service.account.AccountService;
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
        if (userName == null || userName == "") {
            signUpView.showUserNameEmptyError();
            return false;
        }

        String password = signUpView.getPassword();
        if (password == null || password == "") {
            signUpView.showPasswordEmptyError();
            return false;
        }

        return true;
    }
}
