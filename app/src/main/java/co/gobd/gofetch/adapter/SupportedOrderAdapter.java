package co.gobd.gofetch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.view.OnItemClickListener;
import co.gobd.gofetch.model.order.SupportedOrder;
import co.gobd.gofetch.service.order.OrderService;
import co.gobd.gofetch.service.order.SupportedOrderCallback;


/**
 * Created by tonmoy on 20-Jan-16.
 */
public class SupportedOrderAdapter extends RecyclerView.Adapter<SupportedOrderAdapter.SupportedOrderViewHolder> {


    private OrderService orderService;
    private Context context;
    private List<SupportedOrder> itemList;
    private OnItemClickListener onItemClickListener;

    public SupportedOrderAdapter(final Context context, OrderService service) {
        this.orderService = service;
        this.context = context;
        this.itemList = new ArrayList<>();

        // Downloads the supported orders and updates the adapter
        orderService.getAllSupportedOrder(new SupportedOrderCallback() {
            @Override
            public void onReceiveOrderSuccess(List<SupportedOrder> orders) {
                itemList = orders;
                notifyDataSetChanged();
            }

            @Override
            public void onReceiveOrderFailure() {
                //FIXME Remove when in production
                Toast.makeText(context, "Can't download data", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onConnectionError() {
                //FIXME Remove when in production
                Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Any UI component that needs to know the List item click and position needs to set this listener
    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public SupportedOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SupportedOrderViewHolder viewHolder = null;
        try {
            View layoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cardview_supported_order, null);
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

    public class SupportedOrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivItemImage;
        public TextView tvActionName;
        public TextView tvItemName;

        public SupportedOrderViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            ivItemImage = (ImageView) itemView.findViewById(R.id.iv_order);
            tvActionName = (TextView) itemView.findViewById(R.id.tv_action);
            tvItemName = (TextView) itemView.findViewById(R.id.tv_item);

        }

        @Override
        public void onClick(View view) {
            // Gets the clicked item's position in the view
            int position = getLayoutPosition();
            if (!itemList.isEmpty()) {
                String orderCode = itemList.get(position).getOrderCode();
                // TODO Find a way to decide which activity/workflow needs to be initiated according to the orderCode
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(view, position);
                }
            }
        }
    }


}
