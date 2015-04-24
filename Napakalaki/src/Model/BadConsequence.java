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

// Como todos los atributos de un BadConsequence 
// permanecen inmutables a lo largo de su existencia
// resulta interesante marcarlos como constantes (final)
// Una excepción son los dos ArrayList
public class BadConsequence 
{
    final private String text; 
    final private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    final private boolean death;   
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures; 
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
    }
    public BadConsequence(String text, boolean death)
    {
        this.text = text;
        this.levels = 0;
        this.nVisibleTreasures = 0;
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
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;    
        this.death = false;
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
    
    public int getNVisisbleTreasures()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures()
    {
        return nHiddenTreasures;
    }
    
    public boolean kills()
    {
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures()
    {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures()
    {
        return specificHiddenTreasures;
    }
    
    public boolean isEmpty()
    {
        return levels==0 &&
                specificVisibleTreasures.isEmpty() &&
                specificHiddenTreasures.isEmpty() &&
                nVisibleTreasures==0 &&
                nHiddenTreasures==0 &&
                death==false;
                
    }
    
    public void substractVisibleTreasure(Treasure t)
    {
        if(nVisibleTreasures==0)
            specificVisibleTreasures.remove(t.getType());
        else
            nVisibleTreasures = (nVisibleTreasures-1) < 0 ? 0 : nVisibleTreasures-1 ;
            // variable  =        if(            "       ){ " }else{       "      } 
    }
    
    public void substractHiddenTreasure(Treasure t)
    {
        if(nHiddenTreasures==0)
            specificHiddenTreasures.remove(t.getType());
        else
            nHiddenTreasures = (nHiddenTreasures-1) < 0 ? 0 : nHiddenTreasures-1 ;   
            // variable  =        if(            "     ){ " }else{       "      } 
           
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
//       Caso problemático -> Arreglado, ahora funciona
//       v := ONEHAND, ONEHAND, HELMET
//       specificVisibleTreasures := ONEHAND, HELMET
//       Además los casos restantes también furulan bien
        BadConsequence newBadConsequence;
        if(nVisibleTreasures==0 && nHiddenTreasures==0)
        { // solo tesoros especificos
            ArrayList<TreasureKind> newVisibleTreasures = new ArrayList<>();
            ArrayList<TreasureKind> newHiddenTreasures = new ArrayList<>();
            boolean onlyOneV, onlyOneSpecific, add = true;
            for(Treasure t : v) // Visible a ajustar
                if(specificVisibleTreasures.contains(t.getType()))
                {
                    onlyOneV = v.lastIndexOf(t)==v.indexOf(t);
                    onlyOneSpecific = 
                            specificVisibleTreasures.lastIndexOf(t.getType()) ==
                            specificVisibleTreasures.indexOf(t.getType());
                    if(!onlyOneV && onlyOneSpecific)
                    {
                        if(add)
                        {
                            add = false;
                            newVisibleTreasures.add(t.getType());
                        }
                    }else
                        newVisibleTreasures.add(t.getType());
                }
            add = true;    
            
            for(Treasure t : h) // Oculto a ajustar
                if(specificHiddenTreasures.contains(t.getType()))
                {
                    onlyOneV = h.lastIndexOf(t)==h.indexOf(t);
                    onlyOneSpecific = 
                            specificHiddenTreasures.lastIndexOf(t.getType()) ==
                            specificHiddenTreasures.indexOf(t.getType());
                    if(!onlyOneV && onlyOneSpecific)
                    {
                        if(add)
                        {
                            add = false;
                            newHiddenTreasures.add(t.getType());
                        }
                    }else
                        newHiddenTreasures.add(t.getType());
                }         
            
            newBadConsequence = new BadConsequence(text, levels, newVisibleTreasures, newHiddenTreasures);
        }
        else
        {
           int minVisibleTreasures = nVisibleTreasures > v.size() ? v.size() : nVisibleTreasures ;
           int minHiddenTreasures = nHiddenTreasures > h.size() ? h.size() : nHiddenTreasures ;
           // variable  =        if(            "                ){   "   }else{       "      } 
           newBadConsequence = new BadConsequence(text, levels, minVisibleTreasures, minHiddenTreasures);
        }
        return newBadConsequence;
    }
    
    @Override
    public String toString()
    {
        String textoInicial = "\n\tText = " + text + 
                " \n\tLevels = " + Integer.toString(levels) + 
                " \n\tNumber of Visible Treasures = " + Integer.toString(nVisibleTreasures) +
                " \n\tNumber of Hidden Treasures = " + Integer.toString(nHiddenTreasures) +
                " \n\tDeath = " + Boolean.toString(death);
        String textoArrayHiddenTreasures = " \n\tArray Specific Hidden Treasures: ";
        String textoArrayVisibleTreasures = " \n\tArray Specific Visible Treasures: ";
        if(!specificHiddenTreasures.isEmpty())
        {
            for (TreasureKind tk : specificHiddenTreasures)
                textoArrayHiddenTreasures += (tk.toString() + " ");
        }
        else
        {
            textoArrayHiddenTreasures += "No pierde ningún tesoro específico.";
        }
        
        if(!specificVisibleTreasures.isEmpty())
        {
            for (TreasureKind tk : specificVisibleTreasures)
                textoArrayVisibleTreasures += (tk.toString() + " ");
        }
        else
        {
            textoArrayVisibleTreasures += "No pierde ningún tesoro específico.";
        }
        return textoInicial + textoArrayHiddenTreasures + textoArrayVisibleTreasures;
    }
}
