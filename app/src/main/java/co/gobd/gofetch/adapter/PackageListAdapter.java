package co.gobd.gofetch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.gobd.gofetch.R;
import co.gobd.gofetch.model.order.PackageList;

/**
 * Created by tonmoy on 05-Jun-16.
 */
public class PackageListAdapter extends RecyclerView.Adapter<PackageListAdapter.ViewHolder> {

    private List<PackageList> packageLists;

    public void setPackageLists(List<PackageList> packageLists) {
        this.packageLists = packageLists;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_package_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PackageList packageList = packageLists.get(position);
        holder.etPackageList.setText(packageList.item);

    }

    @Override
    public int getItemCount() {
        return this.packageLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_package_list)
        EditText etPackageList;

        @BindView(R.id.numberPicker_quantity)
        NumberPicker numberPicker;

        @BindView(R.id.btn_item_delete)
        Button btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
