package com.example.user.multiappliyfromlens.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.user.multiappliyfromlens.Fragment.MainFragment;
import com.example.user.multiappliyfromlens.Fragment.PokerRecommandFragment;
import com.example.user.multiappliyfromlens.R;

public class MainActivity extends AppCompatActivity
{
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private DrawerLayout dlMain;
    private Toolbar toolbar;
    private NavigationView navigation_view;

    private void initView()
    {
        dlMain = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_view = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }
    private void init()
    {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,dlMain,toolbar,R.string.drawer_open,R.string.drawer_close);
        dlMain.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        fragmentManager = getSupportFragmentManager ();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rlMainContainer,new MainFragment()).commit();
    }
    private void setListener()
    {
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                dlMain.closeDrawer(GravityCompat.START);
                int id = item.getItemId();
                if(id == R.id.nav_translate)
                {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.rlMainContainer,new MainFragment()).commit();
                    return true;
                }
                else if(id == R.id.nav_poker_command)
                {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.rlMainContainer,new PokerRecommandFragment()).commit();
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);
        initView();
        init();
        setListener();
    }
}
