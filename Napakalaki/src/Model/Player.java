 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import GUI.PlayerView;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class Player {
    
    final private static int MAXHIDDENTREASURES = 4;
    private boolean dead;
    final private String name;
    private int level;
    private ArrayList <Treasure> visibleTreasures;
    private ArrayList <Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    final private CardDealer dealer;
    private PlayerView playerModel;
    
    public Player(String name)
    {
        this.level = 1;
        this.visibleTreasures = new ArrayList<>();
        this.hiddenTreasures = new ArrayList<>();
        this.pendingBadConsequence = new BCDeath("Vacio", false);
        this.name=name;
        this.dead=true;
        this.dealer = CardDealer.getInstance();
        this.playerModel = new PlayerView();
        this.playerModel.setPlayer(this);
    }
    
    public Player(Player p)
    {
        this.dead = p.dead;
        this.level = p.level;
        this.hiddenTreasures = p.hiddenTreasures; //habría que ver si este nivel de copiado es suficiente
        this.visibleTreasures = p.visibleTreasures; //habría que ver si este nivel de copiado es suficiente
        this.name = p.name;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.dealer = CardDealer.getInstance();
    }
    
    private void bringToLive()
    {
        dead = false;
    }
    private void incrementLevels(int l)
    {
        level = level + l;
    }
    private void decrementLevels(int l)
    {
        if(level-l <= 0){
            level=1;
        }else
            level = level - l;
    }
    private void setPendingBadConsequence(BadConsequence b)
    {
        pendingBadConsequence = b;
    }
    // Esta no es la implementación del diagrama, Salva
    private void die()
    {
        for(Treasure t : visibleTreasures)
            dealer.giveTreasureBack(t);
        visibleTreasures.clear();
        for(Treasure t : hiddenTreasures)
            dealer.giveTreasureBack(t);
        hiddenTreasures.clear();
        level = 1;
        dead = true;
    }
    private void discardNecklaceIfVisible()
    {
        ArrayList <Treasure> ar = new ArrayList<>();
        for(Treasure t :visibleTreasures)
        {
            if(t.getType()==TreasureKind.NECKLACE)
                dealer.giveTreasureBack(t);
            else
                ar.add(t);
        }
        this.visibleTreasures = ar;
    }
    private void dieIfNoTreasures()
    {
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            this.die();
    }
    
    private boolean canIBuyLevels(int l)
    {
        return (level + l <= 9);
    }
    protected float computeGoldCoinsValue(ArrayList<Treasure> t)
    {
        float levels= 0;
        for (Treasure i : t)
            levels += (float)i.getGoldCoins()/1000; // esta operación sin el casting es entera U.U
        return levels;
    }

    public void applyPrize(Prize p)
    {
        this.incrementLevels(p.getLevels());
        for(int i = 0;i<p.getTreasures();i++)
            hiddenTreasures.add(dealer.nextTreasure());
    }
    public CombatResult combat(Monster m)
    {
        CombatResult combate = CombatResult.LOSEANDESCAPE;
        if(getCombatLevel() > getOponentLevel(m))
        {
            this.applyPrize(m.getPrize());
            if(level > 9)
                combate = CombatResult.WINANDWINGAME;
            else
                combate = CombatResult.WIN;
            //Versión compacta de if/else
            // combate = level > 9 ? CombatResult.WINANDWINGAME : CombatResult.WIN;
            // variable = if(  "   ){            "           }else{       "      } 
        }
        else if(Dice.getInstance().nextNumber("Dado para combate",
                "Si sacas más o igual de 5, escapas. De lo contrario o bien mueres o bien te haces sectareo")<5)
        {
            if(shouldConvert())
                combate = CombatResult.LOSEANDCONVERT;
            else if(m.getBadConsequence().kills())
            {
                this.die();
                combate = CombatResult.LOSEANDDIE;
            }
            else
            {
                this.applyBadConsequence(m.getBadConsequence());
                combate = CombatResult.LOSE;
            }
        }
        this.discardNecklaceIfVisible();
        return combate;
    }
    public void applyBadConsequence(BadConsequence bad)
    {
        if(bad.getLevels()!=0)
            this.decrementLevels(bad.getLevels());
        BadConsequence b = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures); //tiene que hacer la llamada sobre bad, no sobre pending
        this.setPendingBadConsequence(b);
    }
    public boolean makeTreasureVisible(Treasure t)
    {
        boolean canI = this.canMakeTreasureVisible(t);
        if(canI)
        {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
        return canI;
    }
    public boolean canMakeTreasureVisible(Treasure t) 
    {
        visibleTreasures.add(t);
        boolean canI = true;// debe de ser inicialmente verdadero
        boolean [] valido = new boolean[6];
        for (int j=0;j<6;j++)
                valido[j]=false;
        
        for(Treasure i : visibleTreasures)//Se recomienda altamente una implementación con switch
        {
            if(i.getType()==TreasureKind.ARMOR)
            {
                if(valido[0])
                    canI = false;
                else
                    valido[0]=true;
            }
            else if(i.getType()==TreasureKind.BOTHHANDS)
            {   
                if(valido[3]||valido[4])
                    canI = false;
                else
                {
                    valido[3]=true;
                    valido[4]=true;
                }
            }
            else if(i.getType()==TreasureKind.HELMET)
            {
                if(valido[1])
                    canI = false;
                else
                    valido[1]=true;
            }
            else if(i.getType()==TreasureKind.NECKLACE)
            {
                if(valido[2])
                    canI = false;
                else
                    valido[2]=true;
            }
            else if(i.getType()==TreasureKind.ONEHAND)
            {
                if(valido[3])
                    if(valido[4])
                        canI=false;
                    else
                        valido[4]=true;
                else
                    valido[3]=true;
            }
            else
            {
                if(valido[5])
                    canI = false;
                else
                    valido[5]=true;
            }
        }
        visibleTreasures.remove(t);
        return canI;
    }
    public void discardVisibleTreasure(Treasure t)
    {
        visibleTreasures.remove(t);
        if( pendingBadConsequence!=null && !pendingBadConsequence.isEmpty() )
            pendingBadConsequence.substractVisibleTreasure(t);
        dealer.giveTreasureBack(t);
        this.dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t)
    {
        hiddenTreasures.remove(t);
        if( pendingBadConsequence!=null && !pendingBadConsequence.isEmpty() )
            pendingBadConsequence.substractHiddenTreasure(t);
        dealer.giveTreasureBack(t);
        this.dieIfNoTreasures();
    }
    public boolean buyLevels(ArrayList <Treasure> visible, ArrayList <Treasure> hidden)
    {
        float levels = this.computeGoldCoinsValue(visible);
        levels += this.computeGoldCoinsValue(hidden);
        boolean canI = this.canIBuyLevels((int)levels);
        if(canI)
        {
            this.incrementLevels((int)levels);// sin el this, no modificaba el número de niveles
                                              // moraleja, los métodos privados a partir de ahora
                                              // los va a llamar siempre this
            for (Treasure t:visible)
                this.discardVisibleTreasure(t);
            for (Treasure t:hidden)
                this.discardHiddenTreasure(t);
        }
        return canI;
    }
    public int getCombatLevel()
    {
        int combatLevel = level, combatLevelCollar = level;
        boolean collar=false;
        for (Treasure T : visibleTreasures)
        {
            combatLevel += T.getBasicValue();
            combatLevelCollar += T.getSpecialValue();
            if(T.getType()==TreasureKind.NECKLACE)
                collar = true;
        }
        if(collar)
            return combatLevelCollar;
        else
            return combatLevel;        
    }
    public boolean validState()
    {
        return hiddenTreasures.size()<=MAXHIDDENTREASURES && pendingBadConsequence.isEmpty();
    }
    public void initTreasures()
    {
        this.bringToLive();
        int tirada = Dice.getInstance().nextNumber("Dado para tesoros iniciales", "Si sacas un 6 consigues 3 tesoros, si sacas un 1 consigues 1 tesoro, sino por defecto recives 2"), numeroTesoros=2;
        if(tirada==6)
            numeroTesoros = 3;
        else if (tirada == 1)
            numeroTesoros = 1;
        
        for(int i = 0;i<numeroTesoros;i++)
            hiddenTreasures.add(dealer.nextTreasure());
    }
    public boolean isDead()
    {
        return dead;
    }
    public boolean hasVisibleTreasures()
    {
        return !visibleTreasures.isEmpty();
    }
    public ArrayList <Treasure> getVisibleTreasures()
    {
        return visibleTreasures;
    }
    public ArrayList <Treasure> getHiddenTreasures()
    {
        return hiddenTreasures;
    }
    @Override
    public String toString()
    {
        String textoInicial = "\n\tName = " + name + 
                " \n\tLevel = " + Integer.toString(level) + 
                " \n\tPendingBadConsequence: { " + pendingBadConsequence.toString() +
                "\n\t} \n\tDead = " + Boolean.toString(dead);
        String textoHiddenTreasures = " \n\tArray Hidden Treasures: { ";
        String textoVisibleTreasures = " \n\tArray Visible Treasures: { ";
        if(!visibleTreasures.isEmpty())
        {
            for (Treasure t : visibleTreasures)
                textoVisibleTreasures += (t.toString() + " ");
        }
        else
        {
            textoVisibleTreasures += "No tiene ningún tesoro visible. ";
        }
        
        if(!hiddenTreasures.isEmpty())
        {
            for (Treasure t : hiddenTreasures)
                textoHiddenTreasures += (t.toString() + " ");
        }
        else
        {
            textoHiddenTreasures += "No tiene ningún tesoro oculto. ";
        }
        return textoInicial + textoHiddenTreasures + "}" + textoVisibleTreasures + "}";
    }
    public String getName()
    {
        return name;
    }
    
    public int getLevel()
    {
        return level;
    }

    protected boolean shouldConvert() 
    {
        if ( !(this instanceof CultistPlayer) )
            return Dice.getInstance().nextNumber("Dado para convertirse en sectáreo","Si sacas un 6 te vuelves sectáreo")<=6;
        else 
            return false;
    }
 
    protected int getOponentLevel(Monster m) 
    {
        return m.getBasicValue();
    }
}
