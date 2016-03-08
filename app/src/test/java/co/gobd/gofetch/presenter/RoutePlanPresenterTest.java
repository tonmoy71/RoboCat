package co.gobd.gofetch.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.gofetch.view.RoutePlanView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 08-Mar-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RoutePlanPresenterTest {

    @Mock
    private RoutePlanView view;

    private RoutePlanPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new RoutePlanPresenter(view);
    }

    @Test
    public void showErrorWhenStartingPointEmpty() throws Exception {
        when(view.getStartingPointAddress()).thenReturn("");
        presenter.onButtonClick();

        verify(view).showErrorOnEmptyStartingPointAddress();

    }

    @Test
    public void showErrorWhenDestinationEmpty() throws Exception {
        when(view.getStartingPointAddress()).thenReturn("Banani");
        when(view.getDestinationAddress()).thenReturn("");
        presenter.onButtonClick();

        verify(view).showErrorOnEmptyDestinationAddress();

    }
}