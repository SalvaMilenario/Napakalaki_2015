/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.TreasureView;

/**
 *
 * @author xehartnort
 */
public class Treasure implements Card
{
    private String name;
    private int goldBonus;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    private TreasureView treasureModel;
    
    public Treasure(String n, int g, int min, int max, TreasureKind t)
    {
        this.name = n;
        this.goldBonus = g;
        this.minBonus = min;
        this.maxBonus = max;
        this.type = t;
        this.treasureModel = new TreasureView();
        this.treasureModel.setTreasure(this);
    }

    public String getName()
    {
        return name;
    }

    public int getGoldCoins()
    {
        return goldBonus;
    }
    
    @Override
    public int getBasicValue()
    {
        return minBonus;
    }
    
    @Override
    public int getSpecialValue()
    {
        return maxBonus;
    }
    
    public TreasureKind getType()
    {
        return type;
    }
    @Override
    public String toString()
    {
        return "\n\tTesoro: " + name + 
               "\n\t\tGoldBonus: " + Integer.toString(goldBonus) + 
               "\n\t\tMinBonus: " + Integer.toString(minBonus) + 
               "\n\t\tMaxBonus: " + Integer.toString(maxBonus) +
               "\n\t\tTreasureKind: " + type;
    }
}