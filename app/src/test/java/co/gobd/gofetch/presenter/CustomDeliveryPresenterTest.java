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

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldPopulatePackageList() {

        packageLists = new ArrayList<>();
        packageLists.add(new PackageList("Baklava from At-teen restaurant", 6));
        packageLists.add(new PackageList("2kg Rice from Agora", 6));

        assertEquals(2, packageLists.size());


    }
}
