package co.gobd.gofetch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.gobd.gofetch.R;
import co.gobd.gofetch.callback.OnOrderDataReceive;
import co.gobd.gofetch.model.SupportedOrder;
import co.gobd.gofetch.service.SupportedOrderService;
import co.gobd.gofetch.view.SupportedOrderViewHolder;


/**
 * Created by tonmoy on 20-Jan-16.
 */
public class SupportedOrderAdapter extends RecyclerView.Adapter<SupportedOrderViewHolder> implements OnOrderDataReceive {

    private List<SupportedOrder> itemList;
    private Context context;


    public SupportedOrderAdapter(Context context) {
        this.context = context;
        this.itemList = new ArrayList<>();

        // Calls the service to download the JSON
        SupportedOrderService service = new SupportedOrderService(this);
        service.loadSupportedOrder();
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

        // Updates the view
        if (!itemList.isEmpty()) {
            holder.tvActionName.setText(itemList.get(position).getActionName());
            holder.tvItemName.setText(itemList.get(position).getOrderName());

            // Downloads and updates the image view with Picasso
            Picasso
                    .with(context)
                    .load(itemList.get(position).getImageUrl())
                    .into(holder.ivItemImage);


        }
    }


    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


    @Override
    public void onReceive(List<SupportedOrder> supportedOrders) {

        // Carries the data from OrderService and updates the data set
        this.itemList = supportedOrders;
        notifyDataSetChanged();
    }
}
