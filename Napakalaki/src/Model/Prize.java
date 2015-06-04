/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.PrizeView;

/**
 *
 * @author Salva
 */
public class Prize 
{
    private int levels;//numero de niveles que sube con el buen royo
    private int treasures;//numero de tesoros que consigue al vencer
    private PrizeView prizeModel;
    
    public Prize(int treasures, int levels)
    {
        if(levels <=1)
            this.levels = 1;
        else
            this.levels= levels;
        this.treasures=treasures;
        prizeModel.setPrize(this);
    }
    
    public int getLevels()
    {
        return levels;
    }
    public int getTreasures()
    {
        return treasures;
    }
    public String toString()
    {
        return "\n\tTreasures = " + Integer.toString(treasures) + " \n\tlevels = " + Integer.toString(levels);
    }
}
