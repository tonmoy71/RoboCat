package co.gobd.gofetch.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.gobd.gofetch.R;
import co.gobd.gofetch.application.GoFetchApplication;
import co.gobd.gofetch.presenter.LoginPresenter;
import co.gobd.gofetch.ui.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.et_userName)
    TextInputEditText etUserName;

    @BindView(R.id.et_password)
    TextInputEditText etPassword;

    @BindView(R.id.btn_signin)
    Button btnSignin;

    @BindView(R.id.btn_signup)
    Button btnSignup;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.input_layout_userName)
    TextInputLayout inputLayoutUserName;

    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;

    @Inject
    LoginPresenter presenter;

    @Inject
    Context context;

    // To remove ButterKnife instance on onDestroy()
    private Unbinder unbinder;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);

        // Dagger injection
        ((GoFetchApplication) getApplication()).getAppComponent().inject(this);

        presenter.initialise(this);
    }

    @OnClick({R.id.btn_signin, R.id.btn_signup})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_signin:
                if (presenter.isValidCredentials()) {
                    presenter.login();
                }
                break;
            case R.id.btn_signup:
                startSignUpActivity();
                break;
        }
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showUserNameError() {
        etUserName.setError(getString(R.string.msg_error_userName));
    }

    @Override
    public void showPasswordError() {
        etPassword.setError(getString(R.string.msg_error_password));
    }

    @Override
    public void startProgress() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void stopProgress() {
        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void startSupportedOrderActivity() {
        Intent intent = new Intent(this, SupportedOrderActivity.class);
        startActivity(intent);
    }

    @Override
    public void startSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(context, R.string.msg_error_connection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(context, R.string.msg_error_login, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordLengthError() {
        Toast.makeText(context, R.string.msg_error_minimum_length_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNameEmptyError() {
        etUserName.setError(getString(R.string.msg_error_userName_empty));
    }

    @Override
    public void showPasswordEmptyError() {
        etPassword.setError(getString(R.string.msg_error_password_empty));
    }
}
