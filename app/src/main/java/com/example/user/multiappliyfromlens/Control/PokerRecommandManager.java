package com.example.user.multiappliyfromlens.Control;

import com.example.user.multiappliyfromlens.BaseClass.BaseManager;
import com.example.user.multiappliyfromlens.Poker.Card;
import com.example.user.multiappliyfromlens.PokerRecommandModel.PokerRecommandConnecter;

import java.util.ArrayList;
import java.util.List;

public class PokerRecommandManager extends BaseManager
{

    private static  PokerRecommandConnecter connecter = new PokerRecommandConnecter();
    public static final String POKERHANDINSERT = "/fcupokerhandinsert";
    public static final String POKERTABLEINSERT = "/fcupokertableinsert";
    public static final String POKERRECOMMAND = "/fcupokerrecommend";
    public static final String POKEROWNPLAY = "/fcupokerownplay";
    public static final String POKEROTHERPLAY = "/fcupokerotherplay";
    public static final String POKEROWNFOLD = "/fcupokerownfold";
    public static final String POKEROTHERFOLD = "/fcupokerotherfold";
    public static final String POKEROWNSCORE = "/fcupokerownscore";
    public static final String POKEROTHERSCORE = "/fcupokerotherscore";
    public static final String POKERREGISTER = "/fcupokerregister";
    public static final String POKERHANDSHOW = "/fcupokerhandshow";
    public static final String POKERTABLESHOW = "/fcupokertableshow";
    public static final String POKERREST = "/fcupokerreset";
    private void initData()
    {

    }
    public PokerRecommandManager()
    {
        initData();
    }


    //must the number of list 12
    public static void insertHandCards(String strMessage)
    {
        connecter.sendGET(POKERHANDINSERT,strMessage);

    }
    public static void insertTableCards(String strMessage)
    {
        connecter.sendGET(POKERTABLEINSERT,strMessage);

    }
    public static String recommandCard()
    {
        connecter.sendGET(POKERRECOMMAND);
        return connecter.getResponse();

    }
    public static void playOwn(String strMessage)
    {
        connecter.sendGET(POKEROWNPLAY,strMessage);

    }
    public static void playOther(String strMessage)
    {
        connecter.sendGET(POKEROTHERPLAY,strMessage);

    }
    public static void foldOwn(String strMessage)
    {
        connecter.sendGET(POKEROWNFOLD,strMessage);
    }
    public static void foldOther(String strMessage)
    {
        connecter.sendGET(POKEROTHERFOLD,strMessage);

    }
    public static String getOwnScore()
    {
        connecter.sendGET(POKEROWNSCORE);
        return connecter.getResponse();

    }
    public static  String getOtherScore()
    {
        connecter.sendGET(POKEROTHERSCORE);
        return connecter.getResponse();

    }
    public static String getUnknown()
    {
        connecter.sendGET(POKERREGISTER);
        return connecter.getResponse();

    }
    public static String getHandShow()
    {
        connecter.sendGET(POKERHANDSHOW);
        return connecter.getResponse();

    }
    public static String getTableShow()
    {
        connecter.sendGET(POKERTABLESHOW);
        return connecter.getResponse();

    }
    public static void reset()
    {
        connecter.sendGET(POKERREST);
    }


    public static String getRequsetMessage(List<Card> listMessage)
    {
        String strRequestMessage = "";
        for(int i = 0;i<listMessage.size();i++)
        {
            strRequestMessage += ","+listMessage.get(i).toString();
        }
        return strRequestMessage;
    }

}
