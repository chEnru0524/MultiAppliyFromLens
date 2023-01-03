package com.example.user.multiappliyfromlens.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.user.multiappliyfromlens.BackHandlerHelper;
import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.Control.PokerRecommandManager;
import com.example.user.multiappliyfromlens.Poker.Card;
import com.example.user.multiappliyfromlens.R;

import java.util.ArrayList;
import java.util.List;

public class Poker_InputSelfFragment extends BaseFragment implements View.OnClickListener
{
    private Button btnConfirm = null;
    private List<Card> alCards = new ArrayList<Card>();
    private Spinner spFunction;
    private EditText etInputCards;

    @Override
    public void initView(View initView)
    {
        spFunction = initView.findViewById(R.id.spFunctionType);
        etInputCards = initView.findViewById(R.id.etInputcards);
        btnConfirm = initView.findViewById(R.id.btnInputConfirm);
        btnConfirm.setOnClickListener(this);
        fragmentTransaction = getFragmentManager().beginTransaction();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View viewPokerCommandInit = inflater.inflate(R.layout.poker_input_self_fragment, container, false);
        initView(viewPokerCommandInit);
        return viewPokerCommandInit;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onClick(View v) {
        insertCards();
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.rlMainContainer,new Poker_RecommandFragment());
        fragmentTransaction.commitNowAllowingStateLoss();
    }
    @Override
    public boolean onBackPressed() {
        fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.rlMainContainer,new Poker_RecommandFragment());
        fragmentTransaction.commit();
        return BackHandlerHelper.handleBackPress(this);
    }
    private void insertCards()
    {
        String strFunction = spFunction.getSelectedItem().toString();
        String strInputCardsMessage = etInputCards.getText().toString();
        if(getString(R.string.sp_user)==strFunction)
        {
            //test case
            //strInputCardsMessage = "As,3s,8c,9c,Jc,6h,Th,Jh,3d,6d,Qd,Kd";
            PokerRecommandManager.insertHandCards(strInputCardsMessage);
        }
        else if(getString(R.string.sp_table)==strFunction)
        {
            PokerRecommandManager.insertTableCards(strInputCardsMessage);
        }
        else if(getString(R.string.sp_own_play)==strFunction)
        {
            PokerRecommandManager.playOwn(strInputCardsMessage);
        }
        else if(getString(R.string.sp_other_play)==strFunction)
        {
            PokerRecommandManager.playOther(strInputCardsMessage);
        }
        else if(getString(R.string.sp_own_fold)==strFunction)
        {
            PokerRecommandManager.foldOwn(strInputCardsMessage);
        }
        else if(getString(R.string.sp_other_fold)==strFunction)
        {
            PokerRecommandManager.foldOther(strInputCardsMessage);
        }
    }
}
