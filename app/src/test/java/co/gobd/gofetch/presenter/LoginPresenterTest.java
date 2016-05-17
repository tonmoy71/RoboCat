package co.gobd.gofetch.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.service.account.LoginCallback;
import co.gobd.gofetch.ui.view.LoginView;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 15-May-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    AccountService service;

    @Mock
    LoginView view;

    @Captor
    ArgumentCaptor<LoginCallback> loginCallbackArgumentCaptor;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(service);
        presenter.initialise(view);
    }

    @Test
    public void shouldShowUsernameEmptyErrorWhenUserNameIsBlank(){
        when(view.getUserName()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showUserNameEmptyError();
    }

    @Test
    public void shouldShowUsernameEmptyErrorWhenUserNameIsNull(){
        when(view.getUserName()).thenReturn(null);
        presenter.isValidCredentials();
        verify(view).showUserNameEmptyError();
    }

    @Test
    public void shouldShowPasswordEmptyErrorWhenPasswordIsBlank(){

        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showPasswordEmptyError();

    }

    @Test
    public void shouldShowPasswordEmptyErrorWhenPasswordIsNull(){
        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn(null);
        presenter.isValidCredentials();
        verify(view).showPasswordEmptyError();

    }

    @Test
    public void shouldShowPasswordLengthError(){

        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn("123");
        presenter.isValidCredentials();
        verify(view).showPasswordLengthError();
    }

    @Test
    public void shouldReturnTrueWhenValidCredentials(){
        when(view.getUserName()).thenReturn("fahim");
        when(view.getPassword()).thenReturn("123456");
        presenter.isValidCredentials();
        assertEquals(presenter.isValidCredentials(), true);
    }

    @Test
    public void shouldStartActivityWhenSuccessfulLogin()
    {
        String accessToken = "access_token";

        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn("123456");

        presenter.login();

        // Let's call the callback. ArgumentCaptor.capture() works like a matcher.
        verify(service).login(anyString(), anyString(), loginCallbackArgumentCaptor.capture());

        loginCallbackArgumentCaptor.getValue().onLoginSuccess(accessToken);

        verify(view).stopProgress();
        verify(view).startSupportedOrderActivity();
    }



    @After
    public void tearDown() throws Exception {

    }
}