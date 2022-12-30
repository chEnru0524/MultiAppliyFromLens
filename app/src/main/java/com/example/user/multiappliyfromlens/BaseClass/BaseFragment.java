package com.example.user.multiappliyfromlens.BaseClass;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public abstract class BaseFragment extends Fragment
{
    protected FragmentTransaction fragmentTransaction;
    protected void initView(View initView) {}
    protected void setListener(){}
    protected void initview(){}
}
