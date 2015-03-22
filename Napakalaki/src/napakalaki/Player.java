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
    
    public Player (String name)
    {
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

    }
    private void decrementLevels(int l)
    {

    }
    private void setPendingBadConsequence(BadConsequence b)
    {

    }
    private void die()
    {

    }
    private void discardNecklaceIfVisible()
    {
        
    }
    private void dieIfNoTreasures()
    {

    }
    
    private boolean canIBuyLevels(int l)
    {
        return true;
    }
    protected float computeGoldCoinsValue(Treasure [] t)
    {
        return 0;
    }
    public void applyPrize(Prize p)
    {

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
        return 0;
    }
    public boolean validState()
    {
        return false;
    }
    public boolean initTreasures()
    {
        return true;
    }
    public boolean isDead()
    {
        return true;
    }
    public boolean hasVisibleTreasures()
    {
        return true;
    }
    public Treasure [] getVisibleTreasures()
    {
        Treasure t, z;
        Treasure[] y = new Treasure[2];
        t = new Treasure("El tesoro de prueba 1", 2000, 0, 10, TreasureKind.SHOE);
        z = new Treasure("El tesoro de prueba 2", 0, 10, 20, TreasureKind.ARMOR);
        y[0]=t;
        y[1]=z;
        return y;
    }
    public Treasure [] getHiddenTreasures()
    {
        Treasure t, z;
        Treasure[] y = new Treasure[2];
        t = new Treasure("El tesoro de prueba 1", 2000, 0, 10, TreasureKind.SHOE);
        z = new Treasure("El tesoro de prueba 2", 0, 10, 20, TreasureKind.ARMOR);
        y[0]=t;
        y[1]=z;
        return y;
    }
}
