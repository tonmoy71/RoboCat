package co.gobd.gofetch.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.gobd.gofetch.R;
import co.gobd.gofetch.application.GoFetchApplication;
import co.gobd.gofetch.presenter.SignUpPresenter;
import co.gobd.gofetch.ui.view.SignUpView;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @Inject
    SignUpPresenter presenter;

    @Inject
    Context context;

    // To remove ButterKnife instance on onDestroy()
    private Unbinder unbinder;

    @BindView(R.id.et_userName)
    TextInputEditText etUserName;

    @BindView(R.id.et_password)
    TextInputEditText etPassword;

    @BindView(R.id.et_confirm_password)
    TextInputEditText etConfirmPassword;

    @BindView(R.id.et_phone_number)
    TextInputEditText etPhoneNumber;

    @BindView(R.id.et_email)
    TextInputEditText etEmail;

    @BindView(R.id.btn_signup)
    Button btnSignup;

    @OnClick(R.id.btn_signup)
    public void onClick() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        unbinder = ButterKnife.bind(this);

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
