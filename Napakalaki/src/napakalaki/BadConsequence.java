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
        if( levels==0 &&
            specificVisibleTreasures.isEmpty() &&
            specificHiddenTreasures.isEmpty() &&
            nVisibleTreasures==0 &&
            nHiddenTreasures==0 &&
            !death )
           return true;
        else 
           return false;
                
    }
    
    public void substractVisibleTreasure(Treasure t)//de un modo o de otro
    {
        if(nVisibleTreasures==0)
            specificVisibleTreasures.remove(t.getType());
        else
            nVisibleTreasures = (nVisibleTreasures-1) < 0 ? 0 : nVisibleTreasures-1 ;
    }
    
    public void substractHiddenTreasure(Treasure t)//one way or another
    {
        if(nHiddenTreasures==0)
            specificHiddenTreasures.remove(t.getType());
        else
            nHiddenTreasures = (nHiddenTreasures-1) < 0 ? 0 : nHiddenTreasures-1 ;     
    }
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)//MAL
    {
        BadConsequence newBadConsequence;
        if(nVisibleTreasures==0 && nHiddenTreasures==0)
        { // solo tesoros especificos
            ArrayList<TreasureKind> newVisibleTreasures = new ArrayList<>();
            ArrayList<TreasureKind> newHiddenTreasures = new ArrayList<>();
            boolean add = true;
            for(Treasure t : v) // Visible a ajustar
                if(specificVisibleTreasures.contains(t.getType())) // TODO Si está en los dos mirar casos repetidos
                {
                    if(specificVisibleTreasures.lastIndexOf(t) == specificVisibleTreasures.indexOf(t))
                    {//Quiere decir que solo hau un objeto de este tipo en el array
                        newVisibleTreasures.add(t.getType());
                    }
                    else if(add){// si entra aquí quiere decir que hay dos objetos ONEHAND
                        add = false;
                        newVisibleTreasures.add(t.getType());
                    }
                }          
            add = true;                                           
            for(Treasure t : h) // Oculto a ajustar 
                if(specificHiddenTreasures.contains(t.getType())) // TODO Si está en los dos mirar casos repetidos
                {
                    if(specificHiddenTreasures.lastIndexOf(t) == specificHiddenTreasures.indexOf(t))
                    {//Quiere decir que solo hau un objeto de este tipo en el array
                        newHiddenTreasures.add(t.getType());
                    }
                    else if(add){// si entra aquí quiere decir que hay dos objetos ONEHAND
                        add = false;
                        newHiddenTreasures.add(t.getType());
                    }
                }          
            
            newBadConsequence = new BadConsequence(text, levels, newVisibleTreasures, newHiddenTreasures);
        }
        else
        {
           int minVisibleTreasures = nVisibleTreasures > v.size() ? v.size() : nVisibleTreasures ;
           int minHiddenTreasures = nHiddenTreasures > v.size() ? v.size() : nHiddenTreasures ;
           // variable  = if            "              {   "   }else{   s    "      } 
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
            for (TreasureKind tk : specificHiddenTreasures) // también se puede implementar con iteradores
                textoArrayHiddenTreasures += (tk.toString() + " "); // añade al texto cada valor del array
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