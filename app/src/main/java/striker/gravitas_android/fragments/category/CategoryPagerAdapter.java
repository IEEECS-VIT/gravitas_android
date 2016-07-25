package striker.gravitas_android.fragments.category;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import striker.gravitas_android.R;
import striker.gravitas_android.fragments.event.EventListFragment;

/**
 * Created by HP on 7/26/2016.
 */
public class CategoryPagerAdapter extends FragmentStatePagerAdapter {

    private int categoryCount;
    private String tabCategories[];
    private Context context;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public CategoryPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context=context;
        this.tabCategories = context.getResources().getStringArray(R.array.Categories);
        this.categoryCount = context.getResources().getStringArray(R.array.Categories).length;
    }

    @Override
    public Fragment getItem(int position) {
        return EventListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return categoryCount ;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabCategories[position];
    }

    /*
    public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }*/

}
