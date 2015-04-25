/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
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
    { // hay que darle aún más repasos a esta implementación
//       Caso problemático -> Arreglado, ahora funciona
//       v := ONEHAND, ONEHAND, HELMET
//       specificVisibleTreasures := ONEHAND, HELMET
//       Además los casos restantes también furulan bien
        ArrayList<TreasureKind> newHiddenTreasuresBad = new ArrayList<>();
        ArrayList<TreasureKind> newVisibleTreasuresBad = new ArrayList<>();
        if(!specificVisibleTreasures.isEmpty() || !specificHiddenTreasures.isEmpty())
        { // solo tesoros especificos
            ArrayList<Treasure> newVisibleTreasuresPlayer = new ArrayList<>();
            ArrayList<Treasure> newHiddenTreasuresPlayer = new ArrayList<>();
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
                            newVisibleTreasuresPlayer.add(t);
                            newVisibleTreasuresBad.add(t.getType());
                        }
                    }else{
                        newVisibleTreasuresPlayer.add(t);
                        newVisibleTreasuresBad.add(t.getType());
                    }
                }
            //Una vez que conocemos el ajuste, lo asignamos a v
            v = newVisibleTreasuresPlayer.isEmpty() ? v : newVisibleTreasuresPlayer;
        //    v.removeAll(newVisibleTreasuresPlayer);
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
                            newHiddenTreasuresPlayer.add(t);
                            newHiddenTreasuresBad.add(t.getType());
                        }
                    }else{
                        newHiddenTreasuresPlayer.add(t);
                        newHiddenTreasuresBad.add(t.getType());
                    }
                }
            //Una vez que conocemos el ajuste, lo asignamos a h
            h = newHiddenTreasuresPlayer.isEmpty() ? h : newHiddenTreasuresPlayer;
        }
        else
        {
            //Número de tesoros visibles a quitar
            int minVisibleTreasures = nVisibleTreasures > v.size() ? v.size() : nVisibleTreasures;
            for(int i=0;i<minVisibleTreasures;i++)
            {
                newVisibleTreasuresBad.add(v.get(i).getType());
            }
            //Número de tesoros ocultos a quitar
            int minHiddenTreasures = nHiddenTreasures > h.size() ? h.size() : nHiddenTreasures;
            for(int i=0;i<minHiddenTreasures;i++)
            {
                newHiddenTreasuresBad.add(h.get(i).getType());
            }
        }
        return new BadConsequence(text, levels, newVisibleTreasuresBad, newHiddenTreasuresBad);
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
