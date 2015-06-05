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
public class BCSpecificTreasures extends BadConsequence
{
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    public BCSpecificTreasures(String text , int levels,
                            ArrayList<TreasureKind> tVisible,
                            ArrayList<TreasureKind> tHidden)
    {
        super(text, levels, false);
        this.badConsequenceModel.setBadConsequence(this);
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
        
    @Override
    public void substractVisibleTreasure(Treasure t)
    {
        specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
        specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
        ArrayList<TreasureKind> newHiddenTreasuresBad = new ArrayList<>();
        ArrayList<TreasureKind> newVisibleTreasuresBad = new ArrayList<>();
        ArrayList<TreasureKind> copyOfspecificVisibleTreasures = (ArrayList<TreasureKind>)specificVisibleTreasures.clone();
        ArrayList<TreasureKind> copyOfspecificHiddenTreasures = (ArrayList<TreasureKind>)specificHiddenTreasures.clone();
        for(Treasure t : v) // Visible a ajustar
            if(copyOfspecificVisibleTreasures.contains(t.getType()))
            {
                newVisibleTreasuresBad.add(t.getType());
                copyOfspecificVisibleTreasures.remove(t.getType());
            }
        for(Treasure t : h) // Oculto a ajustar
            if(copyOfspecificHiddenTreasures.contains(t.getType()))
            {
                newHiddenTreasuresBad.add(t.getType());
                copyOfspecificHiddenTreasures.remove(t.getType());    
            }
        return new BCSpecificTreasures(text, 0, newVisibleTreasuresBad, newHiddenTreasuresBad);
    }
    
    @Override
    public boolean isEmpty()
    {
    return levels==0 &&
            specificVisibleTreasures.isEmpty() &&
            specificHiddenTreasures.isEmpty();
    }
    
    @Override
    public String toString()
    {
        String textoInicial = "\n\tText = " + text + 
                              " \n\tLevels = " + Integer.toString(levels);
        String textoArrayHiddenTreasures = " \n\tArray Specific Hidden Treasures: ";
        String textoArrayVisibleTreasures = " \n\tArray Specific Visible Treasures: ";
        for (TreasureKind tk : specificHiddenTreasures)
            textoArrayHiddenTreasures += (tk.toString() + " ");
        for (TreasureKind tk : specificVisibleTreasures)
            textoArrayVisibleTreasures += (tk.toString() + " ");
        return textoIntroduccion + textoInicial + textoArrayVisibleTreasures + textoArrayHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures()
    {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures()
    {
        return specificHiddenTreasures;
    }
}
