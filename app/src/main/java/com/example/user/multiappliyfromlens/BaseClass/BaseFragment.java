package com.example.user.multiappliyfromlens.BaseClass;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.user.multiappliyfromlens.OnFragmentInteractionListener;

public abstract class BaseFragment extends Fragment
{
    protected OnFragmentInteractionListener fragmentInteractionListener;
    protected FragmentTransaction fragmentTransaction;
    protected void initView(View initView) {setListener();}
    protected void setListener(){}
    protected void initview(){}

}
