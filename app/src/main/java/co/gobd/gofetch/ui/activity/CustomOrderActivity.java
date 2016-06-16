package co.gobd.gofetch.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.fragment.ItemDetailsFragment;
import co.gobd.gofetch.ui.view.CustomOrderView;

import static co.gobd.gofetch.ui.fragment.ItemDetailsFragment.OnItemDetailsFragmentListener;

public class CustomOrderActivity extends AppCompatActivity implements CustomOrderView, OnItemDetailsFragmentListener {

    @BindView(R.id.toolbar_no_menu)
    Toolbar toolbar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_custom_order, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order);
        setSupportActionBar(toolbar);

        // FIXME: Remove when testing completes
        loadItemDetailsFragment();

    }

    @Override
    public void loadItemDetailsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.custom_order_container, new ItemDetailsFragment())
                .commit();
    }

    @Override
    public void onFragmentInteraction() {

    }
}
