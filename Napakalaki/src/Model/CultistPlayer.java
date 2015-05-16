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
    private static int totalCultistPlayer = 0;
    Card culti;
    
    public CultistPlayer(Player p, Cultist c)
    {
        super(p);
        ++totalCultistPlayer;
        this.culti = c;
    }
    @Override
    public int getCombatLevel()
    {
        return super.getCombatLevel()+culti.getSpecialValue();
    }
    
    public static int getTotalCultistPlayers()
    {
        return totalCultistPlayer;
    }
}
