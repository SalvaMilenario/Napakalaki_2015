/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class Player {
    
    final private static int MAXHIDDENTREASURES = 4;
    private boolean dead;
    private String name;
    private int level;
    private ArrayList <Treasure> visibleTreasures;
    private ArrayList <Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name)
    {
        this.level = 1;
        this.visibleTreasures = new ArrayList();
        this.hiddenTreasures = new ArrayList();
        this.pendingBadConsequence = new BadConsequence("Vacio", false);
        this.name=name;
        this.dead=true;
    }
    
    private void bringToLife()
    {
//        this.level = 1;
        this.dead = false;
        /*
        int tirada = Dice.getInstance().nextNumber(), numeroTesoros=2;
        if(tirada==6)
            numeroTesoros = 3;
        else if (tirada == 1)
            numeroTesoros = 1;
        
        for(int i = 0;i<numeroTesoros;i++)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        */
    }
    
    private void incrementLevels(int l)
    {
        level = level + l;
    }
    private void decrementLevels(int l)
    {
        level = level - l;
    }
    private void setPendingBadConsequence(BadConsequence b)
    {
        this.pendingBadConsequence = b;
    }
    private void die()
    {
        this.dead= true;
    }
    private void discardNecklaceIfVisible()
    {
        
    }
    private void dieIfNoTreasures()
    {
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead=true;
    }
    
    private boolean canIBuyLevels(int l)
    {
        if(level + l <= 9)
            return true;
        else
            return false;
    }
    protected float computeGoldCoinsValue(ArrayList<Treasure> t)
    {
        float niveles = 0;
        for (Treasure i : t)
            niveles = niveles + (i.getGoldCoins()) / 1000;
        return niveles;
    }
//    public void applyPrize(Prize p)
//    {
//        
//    }
//    public CombatResult combat(Monster m)
//    {
//        /* Idea de como van los combates
//        if(getCombatLevel() > m.getCombatLevel())
//            if(level == 9)
//                return CombatResult.WINANDWINGAME;
//            else
//                return CombatResult.WIN;
//        else if(Dice.getInstance().nextNumber()>4)
//            return CombatResult.LOSEANDESCAPE;
//        else if(m.getBadConsequence().kills())
//            return CombatResult.LOSEANDDIE;
//        else
//            return CombatResult.LOSE;
//        
//        return CombatResult.LOSE;
//        */
//    }
//    public void applyBadConsequence(BadConsequence bad)
//    {
//        /* Idea de como aplicar mal rollos
//        if(bad.kills())
//            this.die();
//        else if(bad.getLevels()!=0)
//            this.decrementLevels(bad.getLevels());
//        else if(bad.getNHiddenTreasures()!=0)
//        {
//            for (int i = 0;i<bad.getNHiddenTreasures();i++)
//                discardHiddenTreasure(hiddenTreasures.get(i));
//            if(bad.getNVisisbleTreasures()!=0)
//                for (int i = 0;i<bad.getNVisisbleTreasures();i++)
//                    discardVisibleTreasure(visibleTreasures.get(i));
//        }
//        else
//        {
//            if(!bad.getSpecificHiddenTreasures().isEmpty())
//                for(TreasureKind b : bad.getSpecificHiddenTreasures())
//                    for(Treasure t : hiddenTreasures)
//                        if(t.getType()==b)
//                            discardHiddenTreasure(t);
//            if(!bad.getSpecificVisibleTreasures().isEmpty())
//                for(TreasureKind b : bad.getSpecificVisibleTreasures())
//                    for(Treasure t : visibleTreasures)
//                        if(t.getType()==b)
//                            discardHiddenTreasure(t);
//        }
//        pendingBadConsequence = new BadConsequence("Vacio", false);  
//        */
//    }
//    public boolean makeTreasureVisible(Treasure t)
//    {
//        return true;
//    }
//    public boolean canMakeTreasureVisible(Treasure t)
//    {
//        return true;
//    }
//    public void discardVisibleTreasure(Treasure t)
//    {
//
//    }
//    public void discardHiddenTreasure(Treasure t)
//    {
//        for(Treasure T : this.hiddenTreasures)
//            if (T.getName()==t.getName())
//                hiddenTreasures.remove(T);
//    }
//    public boolean buyLevels(Treasure [] visible, Treasure [] hidden)
//    {
//        return true;
//    }
    public int getCombatLevel()
    {
        int combatLevel = level, combatLevelCollar = level;
        boolean collar=false;
        for (Treasure T : visibleTreasures)
        {
            combatLevel += T.getMinBonus();
            combatLevelCollar += T.getMaxBonus();
            if(T.getType()==TreasureKind.NECKLACE)
                collar = true;
        }
        if(collar)
            return combatLevelCollar;
        else
            return combatLevel;
    }
    public boolean validState()
    {
        if(hiddenTreasures.size()<4 && pendingBadConsequence.isEmpty())
            return false;
        else
            return true;
        
        /* idea que comprueba si cumple las reglas de los tesoros visibles
        else
        {
            for (int i = 0;i<6;i++)
                valido[i]=false;
            for(Treasure t : visibleTreasures)
            {
                if(t.getType()==TreasureKind.ARMOR)
                {
                    if(valido[0])
                        valid = false;
                    else
                        valido[0]=true;
                }
                else if(t.getType()==TreasureKind.BOTHHANDS)
                {   
                    if(valido[3]||valido[4])
                        valid = false;
                    else
                    {
                        valido[3]=true;
                        valido[4]=true;
                    }
                }
                else if(t.getType()==TreasureKind.HELMET)
                {
                    if(valido[1])
                        valid = false;
                    else
                        valido[1]=true;
                }
                else if(t.getType()==TreasureKind.NECKLACE)
                {
                    if(valido[2])
                        valid = false;
                    else
                        valido[2]=true;
                }
                else if(t.getType()==TreasureKind.ONEHAND)
                {
                    if(valido[3])
                        if(valido[4])
                            valid=false;
                        else
                            valido[4]=true;
                    else
                        valido[3]=true;
                }
                else
                {
                    if(valido[5])
                        valid = false;
                    else
                        valido[5]=true;
                }
            }
        }*/
//        return valid;
    }
//    public boolean initTreasures()
//    {
//        return true;
//    }
    public boolean isDead()
    {
        return dead;
    }
    public boolean hasVisibleTreasures()
    {
        return !visibleTreasures.isEmpty();
    }
    public ArrayList <Treasure> getVisibleTreasures()
    {
        return visibleTreasures;
    }
    public ArrayList <Treasure> getHiddenTreasures()
    {
        return hiddenTreasures;
    }
}
