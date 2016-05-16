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
}
