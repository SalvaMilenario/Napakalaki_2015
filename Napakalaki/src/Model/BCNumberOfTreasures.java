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
public class BCNumberOfTreasures extends BadConsequence
{
    private int nVisibleTreasures;
    private int nHiddenTreasures;
        
    public BCNumberOfTreasures(String text, int levels, int nVisible, int nHidden)
    {
        super(text, levels, false);
        this.badConsequenceModel.setBadConsequence(this);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t)
    {
        nVisibleTreasures = (nVisibleTreasures-1) < 0 ? 0 : nVisibleTreasures-1 ;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
        nHiddenTreasures = (nHiddenTreasures-1) < 0 ? 0 : nHiddenTreasures-1 ;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        //Número de tesoros visibles a quitar
        int minVisibleTreasures = nVisibleTreasures > v.size() ? v.size() : nVisibleTreasures;
        int minHiddenTreasures = nHiddenTreasures > h.size() ? h.size() : nHiddenTreasures;
        return new BCNumberOfTreasures(text, 0, minVisibleTreasures, minHiddenTreasures);
    }
    
    @Override
    public boolean isEmpty()
    {
    return levels==0 &&
            nVisibleTreasures==0 &&
            nHiddenTreasures==0 ;
    }
    
    @Override
    public String toString()
    {
        return  textoIntroduccion + "\n\tText = " + text + 
                " \n\tLevels = " + Integer.toString(levels) + 
                " \n\tNumber of Visible Treasures = " + Integer.toString(nVisibleTreasures) +
                " \n\tNumber of Hidden Treasures = " + Integer.toString(nHiddenTreasures) ;
    }
    
    public int getNVisibleTreasures()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures()
    {
        return nHiddenTreasures;
    }
}
