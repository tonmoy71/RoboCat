package co.gobd.gofetch.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import co.gobd.gofetch.model.order.PackageList;

import static org.junit.Assert.assertEquals;

/**
 * Created by tonmoy on 01-Jun-16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomDeliveryPresenterTest {

    List<PackageList> packageLists;

    private CustomDeliveryPresenter presenter;

    @Before
    public void setUp() throws Exception {

        presenter = new CustomDeliveryPresenter();

        String item1 = "Baklava from At-teen restaurant";
        String item2 = "2kg Rice from Agora";
        int quantity = 5;

        packageLists = new ArrayList<>();
        packageLists.add(new PackageList(item1, quantity));
        packageLists.add(new PackageList(item2, quantity));
    }

    @Test
    public void shouldPopulatePackageList() {
        packageLists.add(new PackageList("Laptop charger from my house", 1));
        assertEquals(3, packageLists.size());
    }


}
