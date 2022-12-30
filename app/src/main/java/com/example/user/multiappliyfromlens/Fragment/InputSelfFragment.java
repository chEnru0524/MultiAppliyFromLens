package com.example.user.multiappliyfromlens.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.R;

public class InputSelfFragment extends BaseFragment implements View.OnClickListener
{
    private Button btnConfirm = null;

    @Override
    public void initView(View initView)
    {
        btnConfirm = initView.findViewById(R.id.btnInputConfirm);
        btnConfirm.setOnClickListener(this);
        fragmentTransaction = getFragmentManager().beginTransaction();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View viewPokerCommandInit = inflater.inflate(R.layout.input_self_popupwindow, container, false);
        initView(viewPokerCommandInit);
        return viewPokerCommandInit;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onClick(View v) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rlMainContainer,new PokerRecommandFragment());
        fragmentTransaction.commitNowAllowingStateLoss();
    }
}
