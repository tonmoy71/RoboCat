package co.gobd.gofetch.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import co.gobd.gofetch.R;
import co.gobd.gofetch.adapter.SupportedOrderAdapter;
import co.gobd.gofetch.application.GoFetchApplication;
import co.gobd.gofetch.listener.OnItemClickListener;


public class SupportedOrderActivity extends AppCompatActivity implements OnItemClickListener {

    private static final String TAG = "SupportedOrderActivity";

    @Inject
    SupportedOrderAdapter supportedOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supported_order);

        // Injects dependency by Dagger
        ((GoFetchApplication) getApplication()).getAppComponent().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvSupportedOrder = (RecyclerView) findViewById(R.id.recycler_view_supported_order);
        if (rvSupportedOrder != null) {
            rvSupportedOrder.setHasFixedSize(false);
        }

        // Number of columns in the staggered grid view
        final int SPAN_COUNT = 2;

        GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT, GridLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position % 3 == 0 ? 2 : 1);
            }
        });

        if (rvSupportedOrder != null) {
            rvSupportedOrder.setLayoutManager(layoutManager);
        }

        if (rvSupportedOrder != null) {
            rvSupportedOrder.setAdapter(supportedOrderAdapter);
        }


        // Passing the activity reference to the adapter
        supportedOrderAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onClick(View view, int position) {
        Log.i(TAG, "Item position: " + position);


    }
}
