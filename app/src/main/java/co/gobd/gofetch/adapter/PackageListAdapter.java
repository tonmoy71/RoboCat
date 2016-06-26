package co.gobd.gofetch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import co.gobd.gofetch.R;
import co.gobd.gofetch.model.order.PackageList;
import java.util.List;

/**
 * Created by tonmoy on 05-Jun-16.
 */
public class PackageListAdapter extends RecyclerView.Adapter<PackageListAdapter.ViewHolder> {

  private List<PackageList> packageLists;

  public void setPackageLists(List<PackageList> packageLists) {
    this.packageLists = packageLists;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recyclerview_item_package_list, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    PackageList packageList = packageLists.get(position);

    // setText() expects an int or String object. If int is passed, it tries to match the int
    // with the R.string file. So, it should be converted to String before.
    holder.tvItemName.setText(String.valueOf(packageList.item));
    holder.tvQuantity.setText(String.valueOf(packageList.quantity));

    holder.btnDelete.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Toast.makeText(v.getContext(), "To be implemented", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override public int getItemCount() {
    return this.packageLists.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    TextView tvItemName;
    TextView tvQuantity;
    ImageButton btnDelete;

    public ViewHolder(View itemView) {

      super(itemView);

      tvItemName = (TextView) itemView.findViewById(R.id.tv_item_name);
      tvQuantity = (TextView) itemView.findViewById(R.id.tv_quantity);
      btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete_item);
    }
  }
}
