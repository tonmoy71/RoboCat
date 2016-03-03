package co.gobd.gofetch;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class RoutePlanFragment extends Fragment  {

    @Bind(R.id.cv_from) CardView cvFrom;
    @Bind(R.id.tv_title_from) TextView tvTitleFrom;
    @Bind(R.id.et_from_location) MaterialEditText etFromLocation;
    @Bind(R.id.et_note_from) MaterialEditText etNoteFrom;
    @Bind(R.id.cv_to) CardView cvTo;
    @Bind(R.id.tv_title_to) TextView tvTitleTo;
    @Bind(R.id.et_to_location) MaterialEditText etToLocation;
    @Bind(R.id.et_note_to) MaterialEditText etNoteTo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_route_plan, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_route_next) void onBtnRouteNextClick() {
        //TODO implement
    }

    @OnLongClick(R.id.btn_route_next) boolean onBtnRouteNextLongClick() {
        //TODO implement
        return true;
    }
}
