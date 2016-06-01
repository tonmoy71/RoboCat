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

    }

    @Test
    public void shouldAddItemToPackageList() {

        packageLists = new ArrayList<>();
        packageLists.add(new PackageList("Baklava from At-teen restaurant", 5));
        packageLists.add(new PackageList("2kg Rice from Agora", 1));
        packageLists.add(new PackageList("Laptop charger from my house", 1));

        assertEquals(3, packageLists.size());
    }

    @Test
    public void shouldGetPackageFromList()
    {
        packageLists = new ArrayList<>();
        packageLists.add(new PackageList("Baklava from At-teen restaurant", 5));
        packageLists.add(new PackageList("2kg Rice from Agora", 1));
        packageLists.add(new PackageList("Laptop charger from my house", 1));

        PackageList item = packageLists.get(0);
        assertEquals(5, item.quantity);

    }


}
