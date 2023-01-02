package com.example.user.multiappliyfromlens.Poker;

public class Card
{
    public String strPoint = null;
    public String strColor = null;

    public Card(String strPoint, String strColor) {
        this.strPoint = strPoint;
        this.strColor = strColor;
    }

    public String getStrPoint() {
        return strPoint;
    }

    public void setStrPoint(String strPoint) {
        this.strPoint = strPoint;
    }

    public String getStrColor() {
        return strColor;
    }

    public void setStrColor(String strColor) {
        this.strColor = strColor;
    }
}
