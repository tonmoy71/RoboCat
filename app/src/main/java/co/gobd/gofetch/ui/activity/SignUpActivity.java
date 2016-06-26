package co.gobd.gofetch.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.gobd.gofetch.R;
import co.gobd.gofetch.application.GoFetchApplication;
import co.gobd.gofetch.presenter.SignUpPresenter;
import co.gobd.gofetch.ui.view.SignUpView;
import javax.inject.Inject;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

  @Inject SignUpPresenter presenter;

  @Inject Context context;

  @BindView(R.id.et_userName) TextInputEditText etUserName;

  @BindView(R.id.et_password) TextInputEditText etPassword;

  @BindView(R.id.et_confirm_password) TextInputEditText etConfirmPassword;

  @BindView(R.id.et_phone_number) TextInputEditText etPhoneNumber;

  @BindView(R.id.et_email) TextInputEditText etEmail;

  @BindView(R.id.btn_signup) Button btnSignUp;

  @BindView(R.id.progressBar) ProgressBar progressBar;

  // Keeps an instance of ButterKnife,
  // so that it can be unregistered when the activity is destroyed
  private Unbinder unbinder;

  @OnClick(R.id.btn_signup) public void onClick() {
    if (presenter.isValidCredentials()) {
      presenter.register();
    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
    unbinder.unbind();
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);
    unbinder = ButterKnife.bind(this);

    // Dagger injection
    ((GoFetchApplication) getApplication()).getAppComponent().inject(this);

    presenter.initialise(this);
  }

  @Override public String getUserName() {
    return etUserName.getText().toString().trim();
  }

  @Override public void showUserNameEmptyError() {
    etUserName.setError(getString(R.string.msg_error_userName_empty));
  }

  @Override public String getPassword() {
    return etPassword.getText().toString();
  }

  @Override public void showPasswordEmptyError() {
    etPassword.setError(getString(R.string.msg_error_password_empty));
  }

  @Override public void showPasswordLengthError() {
    etPassword.setError(getString(R.string.msg_error_minimum_length_password));
  }

  @Override public String getConfirmPassword() {
    return etConfirmPassword.getText().toString();
  }

  @Override public void showPasswordMatchError() {
    etPassword.setError(getString(R.string.msg_error_password_match));
  }

  @Override public String getEmail() {
    return etEmail.getText().toString();
  }

  @Override public void showInvalidEmailPatterError() {
    etEmail.setError(getString(R.string.msg_error_email_pattern));
  }

  @Override public boolean isEmailPatternValid() {
    return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
  }

  @Override public String getPhoneNumber() {
    return etPhoneNumber.getText().toString();
  }

  @Override public String getType() {
    // In future, it may be a dropdown of Asset/User, for now it works.
    return "USER";
  }

  @Override public void stopProgress() {
    if (progressBar != null) {
      progressBar.setVisibility(View.INVISIBLE);
    }
  }

  @Override public void startLoginActivity() {
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }

  @Override public void startProgress() {
    if (progressBar != null) {
      progressBar.setVisibility(View.VISIBLE);
    }
  }

  @Override public void showRegistrationError() {
    Toast.makeText(context, R.string.msg_error_register, Toast.LENGTH_SHORT).show();
  }

  @Override public void showConnectionError() {
    Toast.makeText(context, R.string.msg_error_connection, Toast.LENGTH_SHORT).show();
  }

  @Override public boolean isPhoneNumberValid() {
    return Patterns.PHONE.matcher(getPhoneNumber()).matches();
  }

  @Override public void showInvalidPhoneNumberError() {
    etPhoneNumber.setError(getString(R.string.msg_error_invalid_phone_number));
  }

  @Override public String getPicUri() {
    return null;
  }

  @Override public void showUserNameHasSpaceError() {
    etUserName.setError(getString(R.string.msg_error_userName_has_space));
  }
}
