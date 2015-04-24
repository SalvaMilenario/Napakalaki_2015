/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Random;
/**
 *
 * @author Salva
 */
public class Dice {
    
    private static Dice instance = null;
    private Random release;
    
    private Dice()
    {
        release = new Random();
    }
    
    public static Dice getInstance() 
    {
        if(instance == null)
            instance = new Dice();
        return instance;
    }
    
    public int nextNumber()
    {
        return release.nextInt(6)+ 1;
    }
}
