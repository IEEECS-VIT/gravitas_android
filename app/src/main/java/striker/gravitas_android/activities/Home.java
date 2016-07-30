package striker.gravitas_android.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.szugyi.circlemenu.view.CircleImageView;
import com.szugyi.circlemenu.view.CircleLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import striker.gravitas_android.R;
import striker.gravitas_android.models.Event;
import striker.gravitas_android.navigationDrawer.adapter.CustomExpandableListAdapter;
import striker.gravitas_android.navigationDrawer.datasource.ExpandableListDataSource;

public class Home extends AppCompatActivity {

    Toolbar toolbar = null;
    int height,width;
    SharedPreferences sharedprefs;
    SharedPreferences.Editor editor;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private ExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableListAdapter;
    private List<String> mExpandableListTitle;
    private Map<String, List<String>> mExpandableListData;
    private TextView mSelectedItemView;
    private List<Event> eventList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNavigationDrawer();

        de.hdodenhof.circleimageview.CircleImageView civMiddle = (de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.circleImageViewMiddle);
        civMiddle.setPadding(50,(height/3)-width*3/10,50,(2*height/3)-width*3/10);
        civMiddle.setImageResource(R.drawable.graivtas16);

        CircleLayout cl = (CircleLayout)findViewById(R.id.circle_layout);
        CoordinatorLayout.LayoutParams clParams = new CoordinatorLayout.LayoutParams(width+100,width+100);
        clParams.setMargins(-50,0,0,0);
        cl.setLayoutParams(clParams);

        final String[] subCategories = getResources().getStringArray(R.array.Categories);
        final int[] iconsCategories = {R.mipmap.ic_category_workshop,R.mipmap.ic_category_debate_discussion,R.mipmap.ic_category_chemical_bio,R.mipmap.ic_category_robotics,R.mipmap.ic_category_circuitrix,R.mipmap.ic_category_builtrix,R.mipmap.ic_category_quiz,R.mipmap.ic_category_applied_engineering,R.mipmap.ic_category_online, R.mipmap.ic_category_informals,R.mipmap.ic_category_bits_and_bytes};

        for(int i=0;i<subCategories.length;i++){
            final CircleImageView civ = new CircleImageView(getApplicationContext());
            civ.setLayoutParams(new CircleLayout.LayoutParams(125,125));
            civ.setImageResource(iconsCategories[i]);
            civ.setContentDescription(subCategories[i]);
            cl.addView(civ);

            civ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Snackbar.make(view,"HEY THERE",Snackbar.LENGTH_LONG).show();
                    sharedprefs = getSharedPreferences(CategoryActivity.category_key, Context.MODE_PRIVATE);
                    editor = sharedprefs.edit();
                    editor.putString(CategoryActivity.category_key,civ.getContentDescription().toString());
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), CategoryActivity.class).putExtra(CategoryActivity.category_key,civ.getContentDescription());
                    startActivity(intent);
                }
            });

        }

    }

    private void setNavigationDrawer() {
        setContentView(R.layout.activity_home);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;
        width = size.x;

        AppBarLayout appBarLayout = (AppBarLayout)findViewById(R.id.app_bar_layout);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(width,height/3));
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("graVITas2k16");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        mExpandableListView = (ExpandableListView) findViewById(R.id.navList);
        //mSelectedItemView = (TextView) findViewById(R.id.selected_item);

        LayoutInflater inflater = getLayoutInflater();
        //View listHeaderView = inflater.inflate(R.layout.nav_header, null, false);
        //mExpandableListView.addHeaderView(listHeaderView);

        mExpandableListData = ExpandableListDataSource.getData(this);
        mExpandableListTitle = new ArrayList(mExpandableListData.keySet());

        addDrawerItems();
        setupDrawer();



    }

    private void addDrawerItems() {
        mExpandableListAdapter = new CustomExpandableListAdapter(this, mExpandableListTitle, mExpandableListData);
        mExpandableListView.setAdapter(mExpandableListAdapter);
        //  mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(mExpandableListTitle.get(groupPosition).equals("Categories")){

                }else if(mExpandableListTitle.get(groupPosition).equals("Contact Us")){
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setType("plain/text");
                    sendIntent.setData(Uri.parse("test@gmail.com"));
                    sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "test@gmail.com" });
                    try {
                        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback :: Gravitas'16 Android App" + getPackageManager().getPackageInfo(getPackageName(),0).versionName);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(sendIntent);
                }else if(mExpandableListTitle.get(groupPosition).equals("About Gravitas")){
                    Intent i = new Intent(getBaseContext(),AboutGravitas.class);
                    startActivity(i);
                } else if (mExpandableListTitle.get(groupPosition).equals("Wishlist")) {
                    Intent i = new Intent(getBaseContext(), Wishlist.class);
                    startActivity(i);
                }

                //getSupportActionBar().setTitle(mExpandableListTitle.get(groupPosition).toString());
                //mSelectedItemView.setText(mExpandableListTitle.get(groupPosition).toString());
                //
            }
        });

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String selectedItem = ((List) (mExpandableListData.get(mExpandableListTitle.get(groupPosition))))
                        .get(childPosition).toString();
                //mSelectedItemView.setText(mExpandableListTitle.get(groupPosition).toString() + " -> " + selectedItem);

                sharedprefs = getSharedPreferences(CategoryActivity.category_key, Context.MODE_PRIVATE);
                editor = sharedprefs.edit();
                editor.putString(CategoryActivity.category_key,selectedItem);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                        //.putExtra(CategoryActivity.category_key,selectedItem);
                startActivity(intent);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
