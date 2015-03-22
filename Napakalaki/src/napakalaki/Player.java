/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Salva
 */
public class Player {
    
    static private int MAXHIDDENTREASURES= 4;
    private boolean dead;
    private String name;
    private int level;
    private Treasure [] visibleTreasures;
    private Treasure [] hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player (String name)
    {
        this.pendingBadConsequence = null;
        this.visibleTreasures = new Treasure[6];
        this.visibleTreasures[0] = new Treasure("", 0, 0, 0, TreasureKind.NECKLACE);
        this.hiddenTreasures = new Treasure[6];
        this.name=name;
        bringToLive();
    }
    
    private void bringToLive()
    {
        level = 1;
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
        if(visibleTreasures[0].getName()==""&&visibleTreasures[0].getName()=="")
            dead=true;
    }
    
    private boolean canIBuyLevels(int l)
    {
        if(l<1000)
            return false;
        else
            return true;
    }
    protected float computeGoldCoinsValue(Treasure [] t)
    {
        float niveles = 0;
        for (Treasure i : t)
            niveles = niveles + (i.getGoldCoins()) / 1000;
        return niveles;
    }
    public void applyPrize(Prize p)
    {
        this.incrementLevels(p.getLevels());
        Treasure [] n = new Treasure [p.getTreasures()];
        
    }
    public CombatResult combat(Monster m)
    {
        CombatResult r = CombatResult.LOSEANDESCAPE;
        return r;
    }
    public void applyBadConsequence(BadConsequence bad)
    {

    }
    public boolean makeTreasureVisible(Treasure t)
    {
        return true;
    }
    public boolean canMakeTreasureVisible(Treasure t)
    {
        return true;
    }
    public void discardVisibleTreasure(Treasure t)
    {

    }
    public void discardHiddenTreasure(Treasure t)
    {
        
    }
    public boolean buyLevels(Treasure [] visible, Treasure [] hidden)
    {
        return true;
    }
    public int getCombatLevel()
    {
        return level;
    }
    public boolean validState()
    {
        boolean valid = true;
        boolean [] valido = new boolean[6];
        if((level<=0)&&(level>=11))
            valid = false;
        else if(hiddenTreasures.length>4)
            valid = false;
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
        }
        return valid;
    }
    public boolean initTreasures()
    {
        return dead;
    }
    public boolean isDead()
    {
        return dead;
    }
    public boolean hasVisibleTreasures()
    {
        return true;
    }
    public Treasure [] getVisibleTreasures()
    {
        return visibleTreasures;
    }
    public Treasure [] getHiddenTreasures()
    {
        return hiddenTreasures;
    }
}
