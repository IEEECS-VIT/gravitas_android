package striker.gravitas_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import striker.gravitas_android.R;
import striker.gravitas_android.Utils.RecyclerViewOnClickListener;
import striker.gravitas_android.fragments.event.EventListAdapter;
import striker.gravitas_android.models.Event;

public class SearchActivity extends AppCompatActivity {

    private List<Event> eventList;
    private EventListAdapter eventListAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);

        //toolbar.setLogo(R.drawable.ic_action_search);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_search_results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search_ex);
        onOptionsItemSelected(searchItem);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Realm realm = Realm.getDefaultInstance();
                eventList = realm.where(Event.class).contains("name",query, Case.INSENSITIVE).findAll();
                eventListAdapter = new EventListAdapter(getApplicationContext(), eventList);
                recyclerView.setAdapter(eventListAdapter);
                eventListAdapter.setOnClickListener(new RecyclerViewOnClickListener<Event>(){

                    @Override
                    public void onItemClick(Event data) {
                        Intent intent = new Intent(getBaseContext(),DetailActivity.class)
                                .putExtra(CategoryActivity.category_key,data.getName());
                        startActivity(intent);
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Realm realm = Realm.getDefaultInstance();
                eventList = realm.where(Event.class).contains("name",newText, Case.INSENSITIVE).findAll();
                eventListAdapter = new EventListAdapter(getApplicationContext(), eventList);
                recyclerView.setAdapter(eventListAdapter);
                eventListAdapter.setOnClickListener(new RecyclerViewOnClickListener<Event>(){

                    @Override
                    public void onItemClick(Event data) {
                        Intent intent = new Intent(getBaseContext(),DetailActivity.class)
                                .putExtra(CategoryActivity.category_key,data.getName());
                        startActivity(intent);
                    }
                });
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
