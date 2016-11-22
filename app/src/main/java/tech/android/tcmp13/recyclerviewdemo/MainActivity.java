package tech.android.tcmp13.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find and define the recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);

        //Define the Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Define the adapter
        recyclerView.setAdapter(new BookAdapter(generateBooks(), this));
    }

    private List<Book> generateBooks() {

        List<Book> result = new ArrayList<>(400);
        for (int i = 0; i < 400; i++)
            result.add(new Book("Horrible Terrible no Good Book " + i, "Once upon a time " + i));
        return result;
    }
}
