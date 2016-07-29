package striker.gravitas_android.fragments.detail;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 7/29/2016.
 */
public class DetailPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public DetailPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public DetailPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    public void addFragment(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
}
