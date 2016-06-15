package co.gobd.gofetch.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.view.CustomOrderView;

public class CustomOrderActivity extends AppCompatActivity implements CustomOrderView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order);
    }
}
