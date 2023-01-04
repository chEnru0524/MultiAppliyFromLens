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
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.user.multiappliyfromlens.BackHandlerHelper;
import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.Fragment.CameraFragment;
import com.example.user.multiappliyfromlens.Fragment.MainFragment;
import com.example.user.multiappliyfromlens.Fragment.Poker_RecommandFragment;
import com.example.user.multiappliyfromlens.Interface.OnFragmentInteractionListener;
import com.example.user.multiappliyfromlens.R;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener
{

    public static final int MAINFRAGMENT = 0;
    public static final int POKERRECOMMANDFRAGMENT = 1;

    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private DrawerLayout dlMain = null;
    private Toolbar toolbar = null;
    private NavigationView navigation_view = null;
    private void initView()
    {
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        navigation_view = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }
    private void initData()
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

                    changeFragment(new CameraFragment(MAINFRAGMENT));
                    return true;
                }
                else if(id == R.id.nav_poker_command)
                {
                    changeFragment(new Poker_RecommandFragment());
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
        initData();
        setListener();
    }

    @Override
    public void changeFragment(BaseFragment fragment)
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rlMainContainer,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (!BackHandlerHelper.handleBackPress(this)) {

            //
            // super.onBackPressed();
        }
    }
}
