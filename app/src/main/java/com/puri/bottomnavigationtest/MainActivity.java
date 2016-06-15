package com.puri.bottomnavigationtest;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private PageFragment currentFragment;
    private BottomNaviViewPageAdapter adapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    //UI -> in activity_main.xml
    private AHBottomNavigationViewPager viewPager;
    private AHBottomNavigation bottomNavigation;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI(){
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        viewPager = (AHBottomNavigationViewPager) findViewById(R.id.view_pager);

//        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Map", R.drawable.ic_near_me_black_24dp, R.color.color_tab_1);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Map", R.drawable.ic_near_me_black_24dp, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Feed", R.drawable.ic_format_list_bulleted_black_24dp, R.color.color_tab_2);
//        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Feed", R.drawable.ic_format_list_bulleted_black_24dp, R.color.color_tab_2);

        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item1);

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(bottomNavigation,"Fifew",Snackbar.LENGTH_LONG).show();
            }
        });


        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setAccentColor(getResources().getColor(R.color.colorAccent));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        viewPager.setOffscreenPageLimit(4);
        adapter = new BottomNaviViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        currentFragment = adapter.getCurrentFragment();


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if(position==0){
                    fab.setVisibility(View.VISIBLE);
                }else{
                    fab.setVisibility(View.INVISIBLE);
                }


                if (currentFragment != null) {
                    currentFragment.willBeHidden();
                }

                viewPager.setCurrentItem(position, false);
                currentFragment = adapter.getCurrentFragment();
                currentFragment.willBeDisplayed();

                if (wasSelected) {
                    currentFragment.refresh();
                    return true;
                }
                return true;
            }
        });

    }
}
