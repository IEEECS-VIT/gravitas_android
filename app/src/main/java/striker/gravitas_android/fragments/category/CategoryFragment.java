package striker.gravitas_android.fragments.category;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import striker.gravitas_android.R;
import striker.gravitas_android.activities.CategoryActivity;

/**
 * Created by HP on 7/26/2016.
 */
public class CategoryFragment extends Fragment {
    ViewPager viewpager;
    CategoryPagerAdapter categoryAdapter;
    private String text;
    private int categoryCount;
    private String tabCategories[];
    public CategoryFragment() {
    }

    public static CategoryFragment getInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences prfs = getActivity().getSharedPreferences(CategoryActivity.category_key, Context.MODE_PRIVATE);
        String text = prfs.getString(CategoryActivity.category_key,null);

        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        viewpager = (ViewPager) view.findViewById(R.id.view_pager_categories);
        categoryAdapter = new CategoryPagerAdapter(getActivity().getSupportFragmentManager(), getActivity());
        viewpager.setAdapter(categoryAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs_category);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setCurrentItem(getCategory(text), true);
        return view;
    }

    private int getCategory(String text){
        tabCategories = getContext().getResources().getStringArray(R.array.Categories);
        categoryCount = getContext().getResources().getStringArray(R.array.Categories).length;
        int i;
        for (i=0; i<categoryCount; i++) {
            if (text.equalsIgnoreCase(tabCategories[i])) {
                break;
            }
        }
        return i;
    }
}
