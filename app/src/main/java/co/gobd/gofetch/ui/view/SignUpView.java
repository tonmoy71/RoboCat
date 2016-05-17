package co.gobd.gofetch.ui.view;

/**
 * Created by tonmoy on 16-May-16.
 */
public interface SignUpView {
    String getUserName();

    void showUserNameEmptyError();

    String getPassword();

    void showPasswordEmptyError();

    void showPasswordLengthError();

    String getConfirmPassword();

    void showPasswordMatchError();

    String getEmail();

    void showInvalidEmailPatterError();

    boolean isEmailPatternValid();

    String getPhoneNumber();

    String getType();

    void stopProgress();

    void startLoginActivity();

    void startProgress();

    void showRegistrationError();

    void showConnectionError();

    boolean isPhoneNumberValid();

    void showInvalidPhoneNumberError();

    String getPicUri();
}
