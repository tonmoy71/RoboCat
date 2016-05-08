package co.gobd.gofetch.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.gofetch.model.account.AccessToken;
import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.ui.view.LoginView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 08-May-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginView view;
    @Mock
    AccountService service;

    @Captor
    ArgumentCaptor<AccessToken> accessTokenArgumentCaptor;

    LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(service);
    }

    @Test
    public void startSupportedOrderActivityWhenLoginSuccessful() {
        when(view.getUserName()).thenReturn("fahim");
        when(view.getPassword()).thenReturn("123456");

        verify(view).startProgress();

        verify(view).startSupportedOrderActivity();

    }
}
