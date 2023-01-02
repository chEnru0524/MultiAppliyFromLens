package com.example.user.multiappliyfromlens.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.user.multiappliyfromlens.Adapter.PokerShowAdapter;
import com.example.user.multiappliyfromlens.BackHandlerHelper;
import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.Control.PokerRecommandManager;
import com.example.user.multiappliyfromlens.Poker.Card;
import com.example.user.multiappliyfromlens.R;

public class Poker_ShowCardFragment extends BaseFragment
{

    private String[] arrayPoint = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    private ListView lvPoint = null;
    private ListView lvRedNumber = null;
    private ListView lvBlackNumber = null;
    private int iCharacter = Card.CHARACTER_SELF;
    private PokerRecommandManager managerCard = null;
    public Poker_ShowCardFragment() {
    }

    @SuppressLint("ValidFragment")
    public Poker_ShowCardFragment(int iCharacter,PokerRecommandManager managerCard)
    {
        this.iCharacter = iCharacter;
        this.managerCard = managerCard;
    }

    @Override
    public void initView(View initView)
    {
        lvPoint = initView.findViewById(R.id.lvPoint);
        lvRedNumber = initView.findViewById(R.id.lv_red_number);
        lvBlackNumber = initView.findViewById(R.id.lv_black_number);
        initListView();
        fragmentTransaction = getFragmentManager().beginTransaction();
        setListener();
    }
    private void initListView()
    {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PokerShowAdapter adapterShow = new PokerShowAdapter(arrayPoint,inflater);
        lvPoint.setAdapter(adapterShow);
        lvRedNumber.setAdapter(adapterShow);
        lvBlackNumber.setAdapter(adapterShow);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View viewPokerShowInit = inflater.inflate(R.layout.show_total_card_fragment, container, false);
        initView(viewPokerShowInit);
        return viewPokerShowInit;
    }
    @Override
    public boolean onBackPressed() {
        return BackHandlerHelper.handleBackPress(this);
    }
}
