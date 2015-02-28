/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
/**
 *
 * @author xehartnort
 */
public class BadConsequence 
{
    private String text; 
    private int levels;
    private int nVisisbleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;    
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.text = text;
        this.levels = levels;
        this.nVisisbleTreasures = 0;
        this.nHiddenTreasures = nHidden;
        this.death = false;
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
    }
    public BadConsequence(String text, boolean death)
    {
        this.text = text;
        this.levels = 0;
        this.nVisisbleTreasures = 0;
        this.nHiddenTreasures = 0;    
        this.death = death;
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
    }
    public BadConsequence(String text , int levels,
                            ArrayList<TreasureKind> tVisible,
                            ArrayList<TreasureKind> tHidden)
    {
        this.text = text;
        this.levels = 0;
        this.nVisisbleTreasures = 0;
        this.nHiddenTreasures = 0;    
        this.death = death;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    public String getText()
    {
        return text;
    }
    public int getLevels()
    {
        return levels;
    }
    public int getnVisisbleTreasures()
    {
        return nVisisbleTreasures;
    }
    public int getnHiddenTreasures()
    {
        return nHiddenTreasures;
    }
    public boolean getDeath()
    {
        return death;
    }
    public String toString()
    {
        String textoInicial = "Text = " + text + 
                " Levels = " + Integer.toString(levels) + 
                " Number of Visible Treasures = " + Integer.toString(nVisisbleTreasures) +
                " Number of Hidden Treasures = " + Integer.toString(nHiddenTreasures) +
                " Death = " + Boolean.toString(death);
        String textoArrayHiddenTreasures = " Array Specific Hidden Treasures: ";
        String textoArrayVisibleTreasures = " Array Specific Visible Treasures: ";
        for (TreasureKind tk : specificHiddenTreasures) // también se puede implementar con iteradores
            textoArrayHiddenTreasures += tk.toString(); // añade al texto cada valor del array
        for (TreasureKind tk : specificVisibleTreasures)
            textoArrayVisibleTreasures += tk.toString();
        return textoInicial + textoArrayHiddenTreasures + textoArrayVisibleTreasures;
    }

}
