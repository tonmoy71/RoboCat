package co.gobd.gofetch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import co.gobd.gofetch.R;
import co.gobd.gofetch.adapter.SupportedOrderAdapter;
import co.gobd.gofetch.model.SupportedOrder;

public class SupportedOrderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supported_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvSupportedOrder = (RecyclerView) findViewById(R.id.recycler_view_supported_order);
        rvSupportedOrder.setHasFixedSize(false);

        // Number of columns in the staggered grid view
        final int SPAN_COUNT = 2;

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        rvSupportedOrder.setLayoutManager(staggeredGridLayoutManager);

        List<SupportedOrder> supportedOrderList = getListItemData();

        SupportedOrderAdapter supportedOrderAdapter = new SupportedOrderAdapter(SupportedOrderActivity.this, supportedOrderList);
        rvSupportedOrder.setAdapter(supportedOrderAdapter);

    }

    private List<SupportedOrder> getListItemData() {

        List<SupportedOrder> list = new ArrayList<>();

        list.add(new SupportedOrder("GET", "FOOD", R.drawable.background_food_1));
        list.add(new SupportedOrder("RIDE", "TAXI", R.drawable.background_taxi_1));
        list.add(new SupportedOrder("GET", "CNG", R.drawable.background_cng_1));
        list.add(new SupportedOrder("GET", "GROCERY", R.drawable.background_grocery_1));

        list.add(new SupportedOrder("GET", "FOOD", R.drawable.background_food_1));
        list.add(new SupportedOrder("RIDE", "TAXI", R.drawable.background_taxi_1));
        list.add(new SupportedOrder("GET", "CNG", R.drawable.background_cng_1));
        list.add(new SupportedOrder("GET", "GROCERY", R.drawable.background_grocery_1));

        list.add(new SupportedOrder("GET", "FOOD", R.drawable.background_food_1));
        list.add(new SupportedOrder("RIDE", "TAXI", R.drawable.background_taxi_1));
        list.add(new SupportedOrder("GET", "CNG", R.drawable.background_cng_1));
        list.add(new SupportedOrder("GET", "GROCERY", R.drawable.background_grocery_1));


        return list;
    }

}
