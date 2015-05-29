/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author xehartnort
 */
public class BCDeath extends BadConsequence
{
    BCDeath(String text, boolean death)
    {
        super(text, 0, death);
    }
    @Override
    public void substractVisibleTreasure(Treasure t)
    {
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
    }
    
    @Override
    public boolean isEmpty()
    {
        return !death;
    }
    
    @Override
    public String toString()
    {
        return  textoIntroduccion + "\n\tText = " + text + 
                " \n\tLevels = " + Integer.toString(levels) + 
                " \n\tDeath = " + death ;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
        return this;
    }
}
