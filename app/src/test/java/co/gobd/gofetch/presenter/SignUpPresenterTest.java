package co.gobd.gofetch.presenter;

import co.gobd.gofetch.model.account.UserModel;
import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.service.account.RegistrationCallback;
import co.gobd.gofetch.ui.view.SignUpView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 16-May-16.
 */
@RunWith(MockitoJUnitRunner.class) public class SignUpPresenterTest {

  @Mock SignUpView view;

  @Mock AccountService service;

  private SignUpPresenter presenter;

  @Captor private ArgumentCaptor<RegistrationCallback> registrationCallbackArgumentCaptor;

  @Before public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    presenter = new SignUpPresenter(service);
    presenter.initialise(view);
  }

  @Test public void shouldShowUserNameEmptyErrorWhenUserNameIsBlank() {
    when(view.getUserName()).thenReturn("");
    presenter.isValidCredentials();
    verify(view).showUserNameEmptyError();
  }

  @Test public void shouldShowUserNameEmptyErrorWhenUserNameIsNull() {
    when(view.getUserName()).thenReturn(null);
    presenter.isValidCredentials();
    verify(view).showUserNameEmptyError();
  }

  @Test public void shouldShowErrorWhenUserNameHasBlankSpace() {
    when(view.getUserName()).thenReturn("hello world");
    presenter.isValidCredentials();
    verify(view).showUserNameHasSpaceError();
  }

  @Test public void shouldShowPasswordEmptyErrorWhenPasswordIsBlank() {
    when(view.getUserName()).thenReturn("abcde");
    when(view.getPassword()).thenReturn("");
    presenter.isValidCredentials();
    verify(view).showPasswordEmptyError();
  }

  @Test public void shouldShowPasswordEmptyErrorWhenPasswordIsNull() {
    when(view.getUserName()).thenReturn("abcde");
    when(view.getPassword()).thenReturn(null);
    presenter.isValidCredentials();
    verify(view).showPasswordEmptyError();
  }

  @Test public void shouldShowPasswordLengthError() {
    when(view.getUserName()).thenReturn("abcds");
    when(view.getPassword()).thenReturn("12345");
    presenter.isValidCredentials();
    verify(view).showPasswordLengthError();
  }

  @Test public void shouldShowErrorWhenPasswordAndConfirmPasswordDoNotMatch() {
    when(view.getUserName()).thenReturn("user");

    // Must be at least 6 char length to pass length test
    when(view.getPassword()).thenReturn("abcdef");
    when(view.getConfirmPassword()).thenReturn("123456");
    presenter.isValidCredentials();

    verify(view).showPasswordMatchError();
  }

  @Test public void shouldShowErrorOnInvalidEmailPattern() {
    when(view.getUserName()).thenReturn("user");
    when(view.getPassword()).thenReturn("abcdef");
    when(view.getConfirmPassword()).thenReturn("abcdef");
    when(view.isPhoneNumberValid()).thenReturn(true);
    when(view.isEmailPatternValid()).thenReturn(false);
    presenter.isValidCredentials();

    verify(view).showInvalidEmailPatterError();
  }

  @Test public void shouldShowErrorOnInvalidPhoneNumber() {
    when(view.getUserName()).thenReturn("user");
    when(view.getPassword()).thenReturn("abcdef");
    when(view.getConfirmPassword()).thenReturn("abcdef");
    when(view.isEmailPatternValid()).thenReturn(true);
    when(view.isPhoneNumberValid()).thenReturn(false);
    presenter.isValidCredentials();

    verify(view).showInvalidPhoneNumberError();
  }

  @Test public void shouldPassWhenCredentialsAreValid() {
    when(view.getUserName()).thenReturn("user");
    when(view.getPassword()).thenReturn("abcdef");
    when(view.getConfirmPassword()).thenReturn("abcdef");
    when(view.isEmailPatternValid()).thenReturn(true);
    when(view.isPhoneNumberValid()).thenReturn(true);
    when(view.getType()).thenReturn("USER");

    assertEquals(presenter.isValidCredentials(), true);
  }

  @Test public void shouldStartLoginActivityWhenSignUpSuccessful() {
    presenter.register();
    verify(view).startProgress();
    verify(service).register(any(UserModel.class), registrationCallbackArgumentCaptor.capture());
    registrationCallbackArgumentCaptor.getValue().onRegistrationSuccess();
    verify(view).stopProgress();
    verify(view).startLoginActivity();
  }

  @Test public void shouldShowErrorWhenSignUpFails() {
    presenter.register();
    verify(view).startProgress();
    verify(service).register(any(UserModel.class), registrationCallbackArgumentCaptor.capture());
    registrationCallbackArgumentCaptor.getValue().onRegistrationFailure();
    verify(view).stopProgress();
    verify(view).showRegistrationError();
  }

  @Test public void shouldShowErrorWhenNoConnectivity() {
    presenter.register();
    verify(view).startProgress();
    verify(service).register(any(UserModel.class), registrationCallbackArgumentCaptor.capture());
    registrationCallbackArgumentCaptor.getValue().onConnectionError();
    verify(view).stopProgress();
    verify(view).showConnectionError();
  }
}
