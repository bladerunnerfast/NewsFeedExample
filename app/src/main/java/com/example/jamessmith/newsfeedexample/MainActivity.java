package com.example.jamessmith.newsfeedexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jamessmith.newsfeedexample.fragments.RecyclerFragment;

public class MainActivity extends AppCompatActivity {

    private String[] tabs = { "Front Page", "World", "Sports", "Business" };
    private int position;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        for(String tab: tabs){
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                selectUrl(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        }
        );
    }

    private void selectUrl(int index){
        String urlPart;

        switch (index){
            case 0:
                urlPart = "11831";
                break;
            case 1:
                urlPart = "11916";
                break;
            case 2:
                urlPart = "12791";
                break;
            case 3:
                urlPart = "11981";
                break;
            default:
                urlPart = "11831";
                break;
        }
        fragmentTransitioning(urlPart);
    }

    private void fragmentTransitioning(String urlPart){
        Fragment fragment = new RecyclerFragment();

        if(fragment != null){
            Bundle bundle = new Bundle();
            bundle.putString("urlPart", urlPart);
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment, null).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentTransitioning("11831");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selectedTab", position);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("selectedTab");

        if(tabLayout != null) {
            tabLayout.getTabAt(position).select();
        }

        selectUrl(position);
    }
}