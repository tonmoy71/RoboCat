package co.gobd.gofetch.presenter;

import co.gobd.gofetch.ui.view.RoutePlanView;
import co.gobd.gofetch.utility.LocationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tonmoy on 08-Mar-16.
 */
@RunWith(MockitoJUnitRunner.class) public class RoutePlanPresenterTest {

  @Mock private RoutePlanView view;

  private RoutePlanPresenter presenter;

  @Before public void setUp() throws Exception {
    presenter = new RoutePlanPresenter(view);
  }

  @Test public void showErrorWhenStartingPointEmpty() throws Exception {
    when(view.getStartingPointAddress()).thenReturn("");
    when(view.getDestinationAddress()).thenReturn("Shyamoli");
    presenter.onButtonClick();

    verify(view).showErrorOnEmptyAddress(LocationType.STARTING_POINT);
  }

  @Test public void showErrorWhenDestinationEmpty() throws Exception {
    when(view.getStartingPointAddress()).thenReturn("Banani");
    when(view.getDestinationAddress()).thenReturn("");
    presenter.onButtonClick();

    verify(view).showErrorOnEmptyAddress(LocationType.DESTINATION_POINT);
  }
}