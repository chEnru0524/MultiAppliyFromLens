package com.example.user.multiappliyfromlens.Poker;

public class Card
{
    public static final int CHARACTER_SELF = 0;
    public static final int CHARACTER_OPP = 1;
    public static final int CHARACTER_UNKNOWN = 2;

    public String strPoint = null;
    public String strColor = null;
    public int iCharacter = 0;

    public Card(String strPoint, String strColor) {
        this.strPoint = strPoint;
        this.strColor = strColor;
        iCharacter = CHARACTER_SELF;

    }

    public Card(String strPoint, String strColor, int iCharacter) {
        this.strPoint = strPoint;
        this.strColor = strColor;
        this.iCharacter = iCharacter;
    }

    public int getStrCharacter() {
        return iCharacter;
    }

    public void setStrCharacter(int iCharacter) {
        this.iCharacter = iCharacter;
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
