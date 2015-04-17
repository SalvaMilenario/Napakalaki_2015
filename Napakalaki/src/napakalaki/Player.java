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
        dead = false;
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
        pendingBadConsequence = b;
    }
    private void die()
    {
        level=1;
        for(Treasure t: visibleTreasures)
            discardVisibleTreasure(t);
        for(Treasure t: hiddenTreasures)
            discardHiddenTreasure(t);
        dead= true;
    }
    private void discardNecklaceIfVisible()
    {
        for(Treasure t :visibleTreasures)
        {
            if(t.getType()==TreasureKind.NECKLACE)
            {
                CardDealer.getInstance().giveTreasureBack(t);
                visibleTreasures.remove(t);
            }
        }
    }
    private void dieIfNoTreasures()
    {
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            die();
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

//    public boolean buyLevels(Treasure [] visible, Treasure [] hidden)
//    {
//        return true;
//    }

    public void applyPrize(Prize p)
    {
        incrementLevels(p.getLevels());
        for(int i = 0;i<p.getTreasures();i++)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
    }
    public CombatResult combat(Monster m)
    {
        CombatResult combate = CombatResult.LOSEANDESCAPE;
        if(getCombatLevel() > m.getCombatLevel())
        {
            applyPrize(m.getPrize());
            if(level > 9)
                combate = CombatResult.WINANDWINGAME;
            else
                combate = CombatResult.WIN;
        }
        else if(Dice.getInstance().nextNumber()<5)
        {
            if(m.getBadConsequence().kills())
            {
                die();
                combate = CombatResult.LOSEANDDIE;
            }
            else
            {
                applyBadConsequence(m.getBadConsequence());
                combate = CombatResult.LOSE;
            }
        }
        discardNecklaceIfVisible();
        return combate;
    }
    public void applyBadConsequence(BadConsequence bad)
    {
        if(bad.getLevels()!=0)
            decrementLevels(bad.getLevels());
        BadConsequence b = pendingBadConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(b);
    }
    public boolean makeTreasureVisible(Treasure t)
    {
        boolean puedo = canMakeTreasureVisible(t);
        if(puedo)
        {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
        return puedo;
    }
    public boolean canMakeTreasureVisible(Treasure t)
    {
        visibleTreasures.add(t);
        boolean valid = false;
        boolean [] valido = new boolean[6];
        for (int j = 0;j<6;j++)
                valido[j]=false;
        for(Treasure i : visibleTreasures)
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
        visibleTreasures.remove(t);
        return valid;
    }
    public void discardVisibleTreasure(Treasure t)
    {
        visibleTreasures.remove(t);
        if((pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t);
        CardDealer.getInstance().giveTreasureBack(t);
        dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t)
    {
        hiddenTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
    }
    public boolean buyLevels(ArrayList <Treasure> visible, ArrayList <Treasure> hidden)
    {
        float levels = computeGoldCoinsValue(visible);
        levels += computeGoldCoinsValue(hidden);
        boolean canI = canIBuyLevels((int)levels);
        if(canI)
        {
            incrementLevels((int)levels);
            for (Treasure t:visible)
                this.discardVisibleTreasure(t);
            for (Treasure t:hidden)
                this.discardHiddenTreasure(t);
        }
        return canI;
    }

    
    
    
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
    }
    public boolean initTreasures()
    {
        int tirada = Dice.getInstance().nextNumber(), numeroTesoros=2;
        if(tirada==6)
            numeroTesoros = 3;
        else if (tirada == 1)
            numeroTesoros = 1;
        
        for(int i = 0;i<numeroTesoros;i++)
            hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        return true;
    }
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
