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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Poker_ShowCardFragment extends BaseFragment
{

    private  List<String> arrayPoint = new ArrayList<>( Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
    private List<String> listResult = new ArrayList<>();
    private ListView lvPoint = null;
    private ListView lvRedNumber = null;
    private ListView lvBlackNumber = null;
    private int iCharacter = Card.CHARACTER_SELF;
    public Poker_ShowCardFragment() {
    }

    @SuppressLint("ValidFragment")
    public Poker_ShowCardFragment(int iCharacter)
    {
        this.iCharacter = iCharacter;
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
        getData();
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PokerShowAdapter adapterShow = new PokerShowAdapter(arrayPoint,inflater);
        lvPoint.setAdapter(adapterShow);
        PokerShowAdapter adapterShowRed = new PokerShowAdapter(listResult,inflater);
        lvRedNumber.setAdapter(adapterShowRed);
        PokerShowAdapter adapterShowBlack = new PokerShowAdapter(listResult,inflater);
        lvBlackNumber.setAdapter(adapterShowBlack);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View viewPokerShowInit = inflater.inflate(R.layout.show_total_card_fragment, container, false);
        initView(viewPokerShowInit);
        return viewPokerShowInit;
    }
    @Override
    public boolean onBackPressed() {
        fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.rlMainContainer,new Poker_RecommandFragment());
        fragmentTransaction.commit();
        return BackHandlerHelper.handleBackPress(this);
    }
    //HandShow  Register  TableShow
    private void getData()
    {
        Type token = new TypeToken<Collection<Card>>() {}.getType();
        Gson gson = new Gson();

        String strMessage = "";
        if(Card.CHARACTER_SELF == iCharacter)
        {
            strMessage = PokerRecommandManager.getHandShow();
        }
        else if(Card.CHARACTER_UNKNOWN == iCharacter)
        {
            strMessage = PokerRecommandManager.getTableShow();
        }
        //因傳輸延遲，未成功抓取資料
//        if(!strMessage.isEmpty()) {
//            System.out.println("get json message:" + strMessage);
//            try {
//                JSONArray jsonArray = new JSONArray(strMessage);
//                for(int i = 0;i<jsonArray.length();i++)
//                {
//                    JSONObject tempObject = jsonArray.getJSONObject(i);
//                    String strPoker = tempObject.getString("poker");
//                    listResult.add(strPoker);
//                    System.out.println(strPoker);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}
