package co.gobd.gofetch.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.ui.view.LoginView;

import static junit.framework.TestCase.assertEquals;
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

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(service);
        presenter.initialise(view);
    }

    @Test
    public void shouldShowUsernameEmptyError(){

        when(view.getUserName()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showUserNameEmptyError();

    }

    @Test
    public void shouldShowPasswordEmptyError(){

        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn("");
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

    @After
    public void tearDown() throws Exception {

    }
}