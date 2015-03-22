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
public class Napakalaki {
//    Implementación singleton
//    Su intención consiste en garantizar que una clase sólo tenga una instancia 
//    y proporcionar un punto de acceso global a ella.

    private static final Napakalaki instance = new Napakalaki(); // instance=null
//    private ArrayList<Player> players; 
//    private Player currentPlayer;
    private Monster currentMonster;

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)
    private Napakalaki()
    {  
    }
    public static Napakalaki getInstance()
    {
        return instance;
    }
//    private void initPlayers(ArrayList<String> names)
//    {
//        for(String name : names){
//            players.add(new Player(name));
//        }
//    }
    
//    private Player nextPLayer()
//    {
//        
//    }

//    public CombatResult combat()
//    {
//        
//    }
    
//    public void discardVisibleTreasure(Treasure t)
//    {
//        
//    }
    
//    public void discardVisibleTreasure(Treasure t)
//    {
//        
//    }
    
//    public boolean makeTreasureVisible(Treasure t)
//    {
//        
//    }
    
//    public boolean buyLevels(ArrayList<Treasure> visible,
//                                ArrayList<Treasure> hidden)
//    {
//        
//    } 

//    public void initGame(ArrayList<String> players)
//    {
//        
//    }
    
//    public Player getCurrentPlayer()
//    {
//        return currentPlayer;
//    }
    
    public Monster getCurrentMonster()
    {
        return currentMonster;
    }

//    public boolean canMakeTreasureVisible(Treasure t)
//    {
//        
//    }
    
//    public ArrayList<Treasure> getVisibleTreasures()
//    {
//        
//    }
    
//    public ArrayList<Treasure> getHiddenTreasures()
//    {
//        
//    }
    
//    public boolean nextTurn()
//    {
//        
//    }
        
//    public boolean nextTurnAllowed()
//    {
//        
//    }
        
//    public boolean endOfGame(CombatResult result)
//    {
//        
//    }
    
}