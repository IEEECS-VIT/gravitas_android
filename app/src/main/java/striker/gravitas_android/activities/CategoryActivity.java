package striker.gravitas_android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import striker.gravitas_android.R;
import striker.gravitas_android.fragments.category.CategoryFragment;

/**
 * Created by HP on 7/26/2016.
 */
public class CategoryActivity extends AppCompatActivity {


    //CategoryActivity: tab view of all the categories.

    private CategoryFragment fragment;
    private static String sent = "";
    public static final String category_key="category_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getDataBun();
        iniView();
    }

    private void getDataBun() {
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
