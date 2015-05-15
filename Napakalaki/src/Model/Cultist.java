/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author xehartnort
 */
public class Cultist extends Player implements Card
{
    public Cultist(Player p)
    {
        super(p);
    }
    @Override
    public int getBasicValue()
    {
        return gainedLevels;
    }
    
    @Override
    public int getSpecialValue()
    {
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
}
