package co.gobd.gofetch.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.ui.view.SignUpView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 16-May-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class SignUpPresenterTest {

    @Mock
    SignUpView view;

    @Mock
    AccountService service;

    private SignUpPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new SignUpPresenter(service);
        presenter.initialise(view);
    }

    @Test
    public void shouldShowUserNameEmptyErrorWhenUserNameIsBlank() {
        when(view.getUserName()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showUserNameEmptyError();
    }

    @Test
    public void shouldShowUserNameEmptyErrorWhenUserNameIsNull() {
        when(view.getUserName()).thenReturn(null);
        presenter.isValidCredentials();
        verify(view).showUserNameEmptyError();
    }

    @Test
    public void shouldShowPasswordEmptyErrorWhenPasswordIsBlank()
    {
        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showPasswordEmptyError();
    }

    @Test
    public void shouldShowPasswordEmptyErrorWhenPasswordIsNull()
    {
        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn(null);
        presenter.isValidCredentials();
        verify(view).showPasswordEmptyError();
    }

    @Test
    public void shouldShowPasswordLengthError()
    {
        when(view.getUserName()).thenReturn("abcds");
        when(view.getPassword()).thenReturn("12345");
        presenter.isValidCredentials();
        verify(view).showPasswordLengthError();
    }

    @Test
    public void shouldShowErrorWhenPasswordAndConfirmPasswordDoNotMatch()
    {
        when(view.getUserName()).thenReturn("user");

        // Must be at least 6 char length to pass length test
        when(view.getPassword()).thenReturn("abcdef");
        when(view.getConfirmPassword()).thenReturn("123456");
        presenter.isValidCredentials();

        verify(view).showPasswordMatchError();
    }

}
