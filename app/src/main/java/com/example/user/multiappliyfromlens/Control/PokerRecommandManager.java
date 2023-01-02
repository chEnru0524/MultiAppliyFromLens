package com.example.user.multiappliyfromlens.Control;

import com.example.user.multiappliyfromlens.BaseClass.BaseManager;
import com.example.user.multiappliyfromlens.Poker.Card;

import java.util.ArrayList;
import java.util.List;

public class PokerRecommandManager extends BaseManager
{
    private List<Card> alUserCards = null;
    private List<Card> alOppCards= null;
    private List<Card> alAllUnknowCards= null;
    private void initData()
    {
        alUserCards = new ArrayList<>();
        alOppCards = new ArrayList<>();
        alAllUnknowCards = new ArrayList<>();
    }
    public PokerRecommandManager()
    {
        initData();
    }

    public PokerRecommandManager(List<Card> alUserCards, List<Card> alOppCards, List<Card> alAllUnknowCards) {
        this.alUserCards = alUserCards;
        this.alOppCards = alOppCards;
        this.alAllUnknowCards = alAllUnknowCards;
    }

    public List<Card> getAlUserCards() {
        return alUserCards;
    }

    public void setAlUserCards(List<Card> alUserCards) {
        this.alUserCards = alUserCards;
    }

    public List<Card> getAlOppCards() {
        return alOppCards;
    }

    public void setAlOppCards(List<Card> alOppCards) {
        this.alOppCards = alOppCards;
    }

    public List<Card> getAlAllUnknowCards() {
        return alAllUnknowCards;
    }

    public void setAlAllUnknowCards(List<Card> alAllUnknowCards) {
        this.alAllUnknowCards = alAllUnknowCards;
    }
}
