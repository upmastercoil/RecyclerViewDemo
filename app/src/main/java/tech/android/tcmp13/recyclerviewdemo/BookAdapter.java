package tech.android.tcmp13.recyclerviewdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tcmp13-t on 11/9/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<Book> books;
    private BookClickListener bookClickListener;
    Context context;

    public BookAdapter(List<Book> books, Context context) {

        this.books = books;
        bookClickListener = new MyClickListener();
        this.context = context;
    }

    /**
     * Will be called on a new (not recycled) view holder should be created. NO MORE getView!!!
     *
     * @param parent   The recycler view
     * @param viewType Used to mark different kinds of view holders.
     * @return The desired ViewHolder
     */
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_list_item, parent, false);
        return new BookViewHolder(view);
    }

    /**
     * Called every time a new item should appear.
     *
     * @param holder The ViewHolder that holds the references
     * @param position The position in the layout (not data).
     */
    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {

        // In anonymous class variables must be final. to not change the method's signature we create a final copy of the position and call it
        final int pos = position;
        Book book = books.get(position);
        holder.titleTextView.setText(book.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                bookClickListener.onBookClicked(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    private class MyClickListener implements BookClickListener {


        @Override
        public void onBookClicked(int position) {
            final int pos = position;
            Book book = books.get(pos);

            new AlertDialog.Builder(context)
                    .setTitle("Delete book - " + book.getTitle())
                    .setMessage("Are you sure you want to delete this book?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                            books.remove(pos);
                            //Just Recreate everything
                            //notifyDataSetChanged();
                            notifyItemRemoved(pos);
                            //Update the Layout manager positions
                            notifyItemRangeChanged(pos, books.size());
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


        }
    }
}
