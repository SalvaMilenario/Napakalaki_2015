/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
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
    private ArrayList<Player> players; 
    private Player currentPlayer;
    private Monster currentMonster;
    private int currentPlayerIndex; //índice del jugador que posee el turno
    private static boolean firstTurn = true;
    final private CardDealer dealer = CardDealer.getInstance();
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con el mismo modificador de acceso que la definición de la clase)
    private Napakalaki()
    {
        
    }
    public static Napakalaki getInstance()
    {
        return instance;
    }
    private void initPlayers(ArrayList<String> names)
    {
        players = new ArrayList<>();
        for(String n : names)
            players.add(new Player(n));
    }
    private Player nextPlayer()
    {
        if(firstTurn) // Si es el primer turno
        {
            firstTurn=false; // el primer índice se selecciona con el dado
            currentPlayerIndex = Dice.getInstance().nextNumber()%players.size();
        }
        else
        {
            currentPlayerIndex++;                   
            currentPlayerIndex %= players.size(); // De esta maneta se controla 
        }                                         // que no se salga del vector
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }

    public CombatResult combat()
    {
        return currentPlayer.combat(currentMonster);
    }
    
    public void discardVisibleTreasure(Treasure t)
    {
        currentPlayer.discardVisibleTreasure(t);
    }
    
    public void discardHiddenTreasure(Treasure t)
    {
        currentPlayer.discardHiddenTreasure(t);
    }
    
    public boolean makeTreasureVisible(Treasure t)
    {
        return currentPlayer.canMakeTreasureVisible(t);
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible,
                                ArrayList<Treasure> hidden)
    {
        return currentPlayer.buyLevels(visible, hidden);
    } 

    public void initGame(ArrayList<String> players)
    {
        this.initPlayers(players);
        dealer.initCards();
        this.nextTurn();

    }
    
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster()
    {
        return currentMonster;
    }
    
    public boolean nextTurn()
    {
        
        if( nextTurnIsAllowed() ){ 
            currentMonster = dealer.nextMonster();
            currentPlayer =  nextPlayer();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
        }
        return this.nextTurnIsAllowed();
    }
        
    public boolean nextTurnIsAllowed()
    {
//      En la primera ejecución, currentPlayer aún es nulo
        return currentPlayer==null ? true : currentPlayer.validState();
    }
        
    public boolean endOfGame(CombatResult result)
    {
        return result==CombatResult.WINANDWINGAME;
    }
    
}