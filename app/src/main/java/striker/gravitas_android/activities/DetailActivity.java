package striker.gravitas_android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import striker.gravitas_android.R;
import striker.gravitas_android.fragments.detail.DetailPagerAdapter;
import striker.gravitas_android.fragments.detail.coordinator.CoordinatorFragment;
import striker.gravitas_android.fragments.detail.description.DescriptionFragment;

/**
 * Created by HP on 7/29/2016.
 */
public class DetailActivity extends AppCompatActivity {

    ViewPager viewpager;
    DetailPagerAdapter detailAdapter;
    private View imgContainer;
    FloatingActionButton myFab;
    boolean isFab = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        viewpager = (ViewPager) findViewById(R.id.view_pager_details);
        detailAdapter = new DetailPagerAdapter(this.getSupportFragmentManager());
        detailAdapter.addFragment(new DescriptionFragment(),"Description");
        detailAdapter.addFragment(new CoordinatorFragment(),"Coordinator");
        viewpager.setAdapter(detailAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_details);
        tabLayout.setupWithViewPager(viewpager);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        collapsingToolbarLayout.setTitle("Collapsing");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this,R.color.colorPrimary));

        NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.scroll);
        scrollView.setFillViewport (true);


        myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doMyThing();
            }
        });
    }

    private void doMyThing() {
        myFab.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_fav_white));
        Snackbar.make(findViewById(R.id.root_coordinator), "Success", Snackbar.LENGTH_LONG).show();
    }
}
