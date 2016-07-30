package striker.gravitas_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import striker.gravitas_android.R;
import striker.gravitas_android.Utils.RecyclerViewOnClickListener;
import striker.gravitas_android.fragments.Wishlist.WishlistAdapter;
import striker.gravitas_android.models.Favourites;

public class Wishlist extends AppCompatActivity {

    List<Favourites> favourites;
    RecyclerView recyclerView;
    TextView textView;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Wishlist");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_wishlist);
        textView = (TextView) findViewById(R.id.noFav);

        realm = Realm.getDefaultInstance();
        favourites = realm.where(Favourites.class).findAll();
        if (favourites.size() == 0) {
            textView.setText("There are no favourites!");
            recyclerView.setVisibility(View.GONE);
        } else {
            Log.d("Fav", favourites.toString());
            textView.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            WishlistAdapter wishlistAdapter = new WishlistAdapter(favourites, this);
            wishlistAdapter.setOnClickListener(new RecyclerViewOnClickListener<Favourites>() {

                @Override
                public void onItemClick(Favourites data) {
                    Intent intent = new Intent(Wishlist.this, DetailActivity.class)
                            .putExtra(CategoryActivity.category_key, data.getName());
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(wishlistAdapter);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStop() {
        realm.close();
        super.onStop();
    }


}
