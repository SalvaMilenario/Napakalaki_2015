/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author xehartnort y salva
 */
public class Monster implements Card
{
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String name, int level, 
                    BadConsequence bc, 
                    Prize prize)
    {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer=0;
    }
    public Monster(String name, int level, 
                    BadConsequence bc, 
                    Prize prize,
                    int levelChangeAgainstCultistPlayer)
    {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer=levelChangeAgainstCultistPlayer;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getCombatLevel()
    {
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence()
    {
        return bc;
    }
    
    public Prize getPrize()
    {
        return prize;
    }
        
    @Override
    public int getBasicValue()
    {
        return getCombatLevel();
    }
    
    @Override
    public int getSpecialValue()
    {
        return getCombatLevel()+levelChangeAgainstCultistPlayer;
    }
    
    public String toString()
    {
        return "Name = " + name + 
                " \nCombat level = " + Integer.toString(combatLevel) + 
                " \nPrize: " + prize.toString() +
                " \nBad consequence: " + bc.toString();
    }
}
