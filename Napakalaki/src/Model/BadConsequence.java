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

public abstract class BadConsequence 
{
    protected String text;   // Todos tienen nombre
    protected int levels;    // Todos tienen niveles
    protected boolean death; // Todos tienen un valor de muerte
    protected String textoIntroduccion = "\n\tEsto es un mal rollo con el siguiente contenido:"; // Estará aquí hasta las versiones finales
    
    public BadConsequence(String text, int levels, boolean death)
    {
        this.text = text;
        this.levels = levels;   
        this.death = death;
    }
    
    public String getText()
    {
        return text;
    }
    
    public int getLevels()
    {
        return levels;
    }
        
    public boolean kills()
    {
        return death;
    }
        
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    @Override
    public abstract String toString();
}
