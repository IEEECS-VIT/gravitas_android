package striker.gravitas_android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import striker.gravitas_android.R;
import striker.gravitas_android.fragments.category.CategoryFragment;
import striker.gravitas_android.models.Event;

/**
 * Created by HP on 7/26/2016.
 */
public class CategoryActivity extends AppCompatActivity {


    //CategoryActivity: tab view of all the categories.

    public static final String category_key = "category_name";
    private static String sent = "";
    List<Event> eventList;
    private CategoryFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getDataBun();
        iniView();
    }

    private void getDataBun() {
        //Events Query - returns the events array(refer api doc). Can access every event related detail through this list (refer models package and api doc)

      /*  Realm realm = Realm.getDefaultInstance();
        eventList = realm.where(Event.class).findAll();
        realm.close(); */




        //to get required category from home activity
        fragment = new CategoryFragment();
        sent = getIntent().getStringExtra(category_key);

        Bundle args = new Bundle();
        args.putCharSequence(CategoryActivity.category_key, sent);


        fragment.setArguments(args);
    }

    private void iniView() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragContent,
                fragment, CategoryFragment.class.getSimpleName()).commitAllowingStateLoss();
    }

}
