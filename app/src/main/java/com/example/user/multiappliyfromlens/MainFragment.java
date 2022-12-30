package com.example.user.multiappliyfromlens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends BaseFragment implements View.OnClickListener {
    Button btnstart = null;
    private FragmentManager fmManger;



     @Override
    public void initView(View initView)
    {
        fragmentTransaction = getFragmentManager().beginTransaction();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View viewMainInit = inflater.inflate(R.layout.main_fragment, container, false);
        btnstart = (Button)viewMainInit.findViewById(R.id.btn_start);
        btnstart.setOnClickListener(this);

        return viewMainInit;
    }
    @Override
    public void onClick(View v) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rlMainContainer,new PokerRecommandFragment());
        fragmentTransaction.commitNowAllowingStateLoss();
    }


}
