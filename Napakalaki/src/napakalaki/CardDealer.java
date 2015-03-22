/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author xehartnort
 */
public class CardDealer {
    //    Implementación singleton
    //    Su intención consiste en garantizar que una clase sólo tenga una instancia 
    //    y proporcionar un punto de acceso global a ella.
    private static CardDealer instance = new CardDealer(); //instance=null
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)    
    private CardDealer()
    {
    }
    
    public static CardDealer getInstance()
    {
        return instance;
    }
    
//    private void initTreasureCardDeck()
//    {
//        
//    }

//    private void initMonsterCardDeck()
//    {
//        
//    }

//    private void shuffleTreasures()
//    {
//        
//    }

//    private void shuffleMonsters()
//    {
//        
//    }

//    public Treasure nextTreasure()
//    {
//        
//    }

//    public Monster nextMonster()
//    {
//        
//    }

//    public void giveTreasureBack(Treasure t)
//    {
//        
//    }

//    public void giveMonsterBack(Monster m)
//    {
//        
//    }

//    public void initCards()
//    {
//        
//    }
        
}