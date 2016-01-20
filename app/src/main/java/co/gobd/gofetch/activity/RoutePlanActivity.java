package co.gobd.gofetch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.gobd.gofetch.R;
import co.gobd.gofetch.presenter.RoutePlanPresenter;
import co.gobd.gofetch.view.RoutePlanView;

public class RoutePlanActivity extends AppCompatActivity implements RoutePlanView {

    private EditText etFrom;
    private EditText etTo;
    private Button btnRequestRyde;

    private RoutePlanPresenter routePlanPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_plan);

        setupUi();

        routePlanPresenter = new RoutePlanPresenter(this);

    }

    private void setupUi() {
        etFrom = (EditText) findViewById(R.id.et_from);
        etTo = (EditText) findViewById(R.id.et_to);
        btnRequestRyde = (Button) findViewById(R.id.btn_request_ryde);
    }

    @Override
    public String getFromLocation() {
        return etFrom.getText().toString();

    }

    @Override
    public String getToLocation() {
        return etTo.getText().toString();
    }

    @Override
    public void showEmptyFieldError() {
        Toast.makeText(this, "Empty location", Toast.LENGTH_SHORT).show();
    }

    public void onRequestRydeClicked(View view) {
        routePlanPresenter.onRequestRydeClicked();
    }
}
