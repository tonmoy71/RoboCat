package co.gobd.gofetch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.gobd.gofetch.R;
import co.gobd.gofetch.model.SupportedOrder;
import co.gobd.gofetch.view.SupportedOrderViewHolder;



/**
 * Created by tonmoy on 20-Jan-16.
 */
public class SupportedOrderAdapter extends RecyclerView.Adapter<SupportedOrderViewHolder> {

    private List<SupportedOrder> itemList;
    private Context context;


    public SupportedOrderAdapter(Context context, List<SupportedOrder> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SupportedOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SupportedOrderViewHolder viewHolder = null;
        try {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_supported_order, null);
            viewHolder = new SupportedOrderViewHolder(layoutView);
        } catch (InflateException e) {
            e.printStackTrace();
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SupportedOrderViewHolder holder, int position) {
        holder.tvActionName.setText(itemList.get(position).getActionName());
        holder.tvItemName.setText(itemList.get(position).getItemName());
        holder.ivItemImage.setImageResource(itemList.get(position).getResourceId());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
