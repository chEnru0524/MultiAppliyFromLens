package com.example.user.multiappliyfromlens.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.user.multiappliyfromlens.BackHandlerHelper;
import com.example.user.multiappliyfromlens.BaseClass.BaseFragment;
import com.example.user.multiappliyfromlens.Control.PokerRecommandManager;
import com.example.user.multiappliyfromlens.Interface.OnFragmentInteractionListener;
import com.example.user.multiappliyfromlens.Poker.Card;
import com.example.user.multiappliyfromlens.R;

import java.util.List;


public class Poker_RecommandFragment extends BaseFragment
{
    private Button btnCameraInput = null;
    private Button btnSelfInput = null;
    private ImageButton imgbtnShowSelf = null;
    private ImageButton imgbtnShowOpp = null;
    private ImageButton imgbtnShowUnknown = null;
    private List<Button> list_showDetailCard = null;
    private OnFragmentInteractionListener fragmentInteractionListener;
    private PokerRecommandManager managerPokerCard;
    @Override
    public void initView(View initView)
    {
        btnCameraInput = (Button)initView.findViewById(R.id.btnInputCamera);
        btnSelfInput = (Button)initView.findViewById(R.id.btnInputSelf);
        imgbtnShowSelf  = (ImageButton) initView.findViewById(R.id.imgbtnSelf);
        imgbtnShowOpp  = (ImageButton) initView.findViewById(R.id.imgbtnOpp);
        imgbtnShowUnknown  = (ImageButton) initView.findViewById(R.id.imgbtnBoard);
        fragmentTransaction = getFragmentManager().beginTransaction();
        managerPokerCard  = new PokerRecommandManager();
        setListener();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View viewPokerCommandInit = inflater.inflate(R.layout.poker_recommand_fragment, container, false);
        initView(viewPokerCommandInit);
        return viewPokerCommandInit;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected void setListener()
    {
        super.setListener();
        btnSelfInput.setOnClickListener(clickListener);
        btnCameraInput.setOnClickListener(clickListener);
        imgbtnShowSelf.setOnClickListener(clickListener);
        imgbtnShowOpp.setOnClickListener(clickListener);
        imgbtnShowUnknown.setOnClickListener(clickListener);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentInteractionListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    private View.OnClickListener clickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {

            if(v.getId() == R.id.imgbtnOpp)
            {
                fragmentInteractionListener.changeFragment(new Poker_ShowCardFragment(Card.CHARACTER_OPP,managerPokerCard));
            }
            else  if(v.getId() == R.id.imgbtnBoard)
            {
                fragmentInteractionListener.changeFragment(new Poker_ShowCardFragment(Card.CHARACTER_UNKNOWN,managerPokerCard));
            }
            else  if(v.getId() == R.id.imgbtnSelf)
            {
                fragmentInteractionListener.changeFragment(new Poker_ShowCardFragment(Card.CHARACTER_SELF,managerPokerCard));
            }
            else  if(v.getId() == R.id.btnInputCamera)
            {
                fragmentInteractionListener.changeFragment(new CameraFragment());
            }
            else  if(v.getId() == R.id.btnInputSelf)
            {
                fragmentInteractionListener.changeFragment(new Poker_InputSelfFragment());
            }


        }
    };

    @Override
    public boolean onBackPressed() {
         return BackHandlerHelper.handleBackPress(this);
    }
}
