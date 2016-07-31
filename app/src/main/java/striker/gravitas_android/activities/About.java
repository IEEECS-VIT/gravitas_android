package striker.gravitas_android.activities;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import striker.gravitas_android.R;

public class About extends AppCompatActivity {

    int height,width;
    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        width = size.x;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.app_bar_about);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(width,height/3));

        bottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.about_coordinator),findViewById(R.id.about_nested_scrolling),savedInstanceState);
        bottomBar.setMaxFixedTabs(2);
        bottomBar.noTopOffset();
        bottomBar.setItems(R.menu.bottombar_about);

        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(int menuItemId) {

            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {

            }
        });

        bottomBar.mapColorForTab(0,ContextCompat.getColor(this,R.color.colorPrimary));
        bottomBar.mapColorForTab(1,ContextCompat.getColor(this,R.color.colorPrimary));
        bottomBar.mapColorForTab(2,ContextCompat.getColor(this,R.color.colorPrimary));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }

}
