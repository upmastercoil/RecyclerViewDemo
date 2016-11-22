package tech.android.tcmp13.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tcmp13-t on 11/9/2016.
 */
public class BookViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;

    /**
     * Creates a new item view holder.
     *
     * @param itemView The view that each item in the list holds (hint: findViewById will be called on this view)
     */
    public BookViewHolder(View itemView) {

        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.linearListItemTextView);
    }
}
