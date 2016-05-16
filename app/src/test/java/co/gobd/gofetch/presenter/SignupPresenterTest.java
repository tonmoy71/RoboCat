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
    public void shouldShowUserNameEmptyError() {
        when(view.getUserName()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showUserNameEmptyError();
    }

    @Test
    public void shouldShowPasswordEmptyError()
    {
        when(view.getUserName()).thenReturn("abcde");
        when(view.getPassword()).thenReturn("");
        presenter.isValidCredentials();
        verify(view).showPasswordEmptyError();
    }

}
