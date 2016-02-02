package co.gobd.gofetch.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import co.gobd.gofetch.R;
import co.gobd.gofetch.adapter.SupportedOrderAdapter;


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

        GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT, GridLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });

        rvSupportedOrder.setLayoutManager(layoutManager);

        SupportedOrderAdapter supportedOrderAdapter = new SupportedOrderAdapter(SupportedOrderActivity.this);
        rvSupportedOrder.setAdapter(supportedOrderAdapter);

    }


}
