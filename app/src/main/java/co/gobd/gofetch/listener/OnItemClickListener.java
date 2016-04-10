package co.gobd.gofetch.listener;

import android.view.View;

/**
 * Created by tonmoy on 23-Mar-16.
 * Handles click events on RecyclerView
 */
public interface OnItemClickListener {
    void onClick(View view, int position);
}
