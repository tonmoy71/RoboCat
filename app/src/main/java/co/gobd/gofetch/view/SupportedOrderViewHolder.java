package co.gobd.gofetch.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import co.gobd.gofetch.R;
import co.gobd.gofetch.activity.RideActivity;

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
        //FIXME Need to find a better way to handle RecyclerView item click
        // Check this out: http://antonioleiva.com/recyclerview-listener/
        Context context = v.getContext();
        context.startActivity(new Intent(v.getContext(), RideActivity.class));
    }
}
