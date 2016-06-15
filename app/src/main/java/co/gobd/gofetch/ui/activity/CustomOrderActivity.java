package co.gobd.gofetch.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.fragment.ItemDetailsFragment;
import co.gobd.gofetch.ui.view.CustomOrderView;

import static co.gobd.gofetch.ui.fragment.ItemDetailsFragment.OnItemDetailsFragmentListener;

public class CustomOrderActivity extends AppCompatActivity implements CustomOrderView, OnItemDetailsFragmentListener {

    @BindView(R.id.toolbar_no_menu)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order);
        setSupportActionBar(toolbar);

        // FIXME: Remove when implemented through presenter
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        transaction.add(R.id.custom_order_container, fragment);
        transaction.commit();
    }

    @Override
    public void loadItemDetailsFragment() {

    }

    @Override
    public void onFragmentInteraction() {

    }
}
