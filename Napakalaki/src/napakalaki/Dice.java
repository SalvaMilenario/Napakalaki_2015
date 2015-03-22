/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.Random;
/**
 *
 * @author Salva
 */
public class Dice {
    
    private static final Dice instance = new Dice();
    
    private Dice(){}
    
    public static Dice getInstance() 
    {
        return instance;
    }
    
    public int nextNumber()
    {
        Random release = new Random();
        return (int)(release.nextDouble() * 6 + 1);
    }
}
