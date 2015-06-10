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
public class Cultist implements Card
{
    private String text;
    private int gainedLevels;
    public Cultist(String text, int level)
    {
        this.text = text;
        this.gainedLevels = level;
    }
    @Override
    public int getBasicValue()
    {
        return gainedLevels;
    }
    
    public String getText(){
        return text;
    }
    
    @Override
    public int getSpecialValue()
    {
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
}
