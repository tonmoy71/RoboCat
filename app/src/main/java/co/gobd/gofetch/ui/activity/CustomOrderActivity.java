package co.gobd.gofetch.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.view.CustomOrderView;

public class CustomOrderActivity extends AppCompatActivity implements CustomOrderView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order);
        setSupportActionBar(toolbar);
    }
}
