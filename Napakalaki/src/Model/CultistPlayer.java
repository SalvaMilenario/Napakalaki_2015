/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
}
