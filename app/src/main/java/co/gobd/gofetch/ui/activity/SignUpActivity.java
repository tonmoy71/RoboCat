package co.gobd.gofetch.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import co.gobd.gofetch.R;
import co.gobd.gofetch.application.GoFetchApplication;
import co.gobd.gofetch.presenter.SignUpPresenter;
import co.gobd.gofetch.ui.view.SignUpView;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @Inject
    SignUpPresenter presenter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Dagger injection
        ((GoFetchApplication) getApplication()).getAppComponent().inject(this);

        presenter.initialise(this);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void showUserNameEmptyError() {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showPasswordEmptyError() {

    }

    @Override
    public void showPasswordLengthError() {

    }

    @Override
    public String getConfirmPassword() {
        return null;
    }

    @Override
    public void showPasswordMatchError() {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void showInvalidEmailPatterError() {

    }

    @Override
    public boolean isEmailPatternValid() {
        return false;
    }

    @Override
    public String getPhoneNumber() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void stopProgress() {

    }

    @Override
    public void startLoginActivity() {

    }

    @Override
    public void startProgress() {

    }

    @Override
    public void showRegistrationError() {

    }

    @Override
    public void showConnectionError() {

    }

    @Override
    public boolean isPhoneNumberValid() {
        return false;
    }

    @Override
    public void showInvalidPhoneNumberError() {

    }
}
