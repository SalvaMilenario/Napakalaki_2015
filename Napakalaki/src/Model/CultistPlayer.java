/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class CultistPlayer extends Player 
{
    private static int totalCultistPlayers = 0;
    Card myCultistCard;

    
    public CultistPlayer(Player p, Cultist c)
    {
        super(p);
        this.totalCultistPlayers++;
        this.myCultistCard = c;
    }
    @Override
    public int getCombatLevel()
    {
        return super.getCombatLevel()+myCultistCard.getSpecialValue();
    }
    
    public static int getTotalCultistPlayers()
    {
        return totalCultistPlayers;
    }
    @Override
    protected boolean shouldConvert() 
    {
        return false;
    }
 
    @Override
    protected int getOponentLevel(Monster m)
    {
        return m.getSpecialValue();
    }
    
    @Override
    protected float computeGoldCoinsValue(ArrayList<Treasure> t)
    {
        return super.computeGoldCoinsValue(t)*2;
    }

    public String getCardText() {
        return ((Cultist)myCultistCard).getText();
    }
}
