package co.gobd.gofetch.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import co.gobd.gofetch.R;

/**
 * Created by tonmoy on 20-Jan-16.
 */
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
    public void onClick(View v) {

        Toast.makeText(v.getContext(), "Item clicked", Toast.LENGTH_SHORT).show();
    }
}
