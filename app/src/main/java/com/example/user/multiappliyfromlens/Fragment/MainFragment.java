package com.example.user.multiappliyfromlens.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.multiappliyfromlens.Activity.MainActivity;
import com.example.user.multiappliyfromlens.BackHandlerHelper;
import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.R;

public class MainFragment extends BaseFragment implements View.OnClickListener {
    Button btnStartPoker = null;
    Button btnStartTranslate = null;



     @Override
    public void initView(View initView)
    {
        fragmentTransaction = getFragmentManager().beginTransaction();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View viewMainInit = inflater.inflate(R.layout.main_fragment, container, false);
        btnStartPoker = (Button)viewMainInit.findViewById(R.id.btn_start_poker);
        btnStartPoker.setOnClickListener(this);
        btnStartTranslate = (Button)viewMainInit.findViewById(R.id.btn_start_translate);
        btnStartTranslate.setOnClickListener(this);
        return viewMainInit;
    }
    @Override
    public void onClick(View v) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        if(R.id.btn_start_poker == v.getId())
            fragmentTransaction.replace(R.id.rlMainContainer,new Poker_RecommandFragment());
        else if(R.id.btn_start_translate == v.getId())
            fragmentTransaction.replace(R.id.rlMainContainer,new CameraFragment(MainActivity.MAINFRAGMENT));
        fragmentTransaction.commitNowAllowingStateLoss();
    }


    @Override
    public boolean onBackPressed() {
        return BackHandlerHelper.handleBackPress(this);
    }
}
