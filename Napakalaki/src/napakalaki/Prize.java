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
public class Prize 
{
    private int levels;//numero de niveles que sube con el buen royo
    private int treasures;//numero de tesoros que consigue al vencer
    /**
     * @
    */
    
    public Prize(int treasures, int levels)
    {
        this.levels= levels;
        this.treasures=treasures;
    }
    
    public int getLevels()
    {
        return levels;
    }
    public int getTreasures()
    {
        return treasures;
    }
}
