package com.xqs.videodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;

import com.xqs.videodemo.activity.TestActivity;
import com.xqs.videodemo.base.BaseActivity;
import com.xqs.videodemo.base.BasePresenter;
import com.xqs.videodemo.business.community.CommunityFragment;
import com.xqs.videodemo.business.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = "MainActivity";

    private static final int NAV_INDEX_HOME = 0;
    private static final int NAV_INDEX_COMMUNITY = 1;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private List<Fragment> fragments = new ArrayList<>();
    private int currentIndex = 0;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemTextColor(getResources().getColorStateList(R.drawable.nav_menu_text_color));
        navigationView.setItemIconTintList(null);

        initFragments();

        startActivity(new Intent(this, TestActivity.class));
    }

    private void initFragments(){

        fragments.add(HomeFragment.newInstance());
        fragments.add(CommunityFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void toggleDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            changeFragment(NAV_INDEX_HOME);
        } else if (id == R.id.nav_gallery) {
            changeFragment(NAV_INDEX_COMMUNITY);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(int index) {
        currentIndex = index;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (null != mCurrentFragment) {
            ft.hide(mCurrentFragment);
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragments.get(currentIndex).getClass().getName());

        if (null == fragment) {
            fragment = fragments.get(index);
        }
        mCurrentFragment = fragment;

        if (!fragment.isAdded()) {
            ft.add(R.id.fl_content, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
    }
}
