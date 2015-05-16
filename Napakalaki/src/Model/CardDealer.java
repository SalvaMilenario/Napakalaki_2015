/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author xehartnort
 */
public class CardDealer {
    //    Implementación singleton
    //    Su intención consiste en garantizar que una clase sólo tenga una instancia 
    //    y proporcionar un punto de acceso global a ella.
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Cultist> unusedCultists;
    
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)    
    private CardDealer()
    {
    }
    
    public static CardDealer getInstance()
    {
        return instance;
    }
     
    private void initCultistCardDeck()
    {
        unusedCultists = new ArrayList<>();
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n\tNo puedes dejar de ser sectario.", 1));
        unusedCultists.add(new Cultist("+2 por cada sectario en juego."+"\n\tNo puedes dejar de ser sectario.", 2));
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n\tNo puedes dejar de ser sectario.", 1));
        unusedCultists.add(new Cultist("+2 por cada sectario en juego."+"\n\tNo puedes dejar de ser sectario.", 2));
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n\tNo puedes dejar de ser sectario.", 1));
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n\tNo puedes dejar de ser sectario.", 1));
    }
    
    private void initTreasureCardDeck()
    {
        usedTreasures = new ArrayList<>();
        unusedTreasures = new ArrayList<>();
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));
        unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon", 300, 3, 5, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentácula de pega", 200, 0, 1, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
    }

    private void initMonsterCardDeck()
    {
        usedMonsters = new ArrayList<>();
        unusedMonsters = new ArrayList<>();
        BadConsequence badConsequence;
        Prize prize;
        
        /* 3 byankhees de bonanza */
        badConsequence = new BCSpecificTreasures("Pierdes tu armadura visible y "
                + "\n\totra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 byankhees de bonanza", 8 , badConsequence, prize));
        
        /* Chubithulhu */
        badConsequence = new BCSpecificTreasures("Embobados con el lindo primigenio "
                + "\n\tte descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chubithulhu",2, badConsequence, prize));
        
        /*El sopor de Dunwich*/ 
        badConsequence = new BCSpecificTreasures("El primordial bostezo contagioso. "
                + "\n\tPierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2, badConsequence, prize));
        
         
        /* Ángeles de la noche ibicenca */
        badConsequence = new BCSpecificTreasures("Te atrapan para llevarte de fiesta "
                + "\n\ty te dejan caer en mitad del vuelo. Descarta 1 mano visible "
                + "\n\ty 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, 
                badConsequence, prize));
        
        /* El gorrón en el umbral */
        badConsequence = new BCNumberOfTreasures("Pierdes todos tus tesoros visibles", 0,
        Integer.MAX_VALUE,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",10, badConsequence, prize));
        
        /* H.P. Munchcraft */
        badConsequence = new BCSpecificTreasures("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        /* Bichgooth */
        badConsequence = new BCSpecificTreasures("Sientes bichos bajo la ropa. "
                + "\n\tDescarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2, badConsequence,prize));
        
        /* El rey de la rosa */
        badConsequence = new BCNumberOfTreasures("Pierdes 5 niveles y "
                + "\n\t3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /* La que redacta en las tinieblas */
        badConsequence = new BCNumberOfTreasures("Toses los pulmones y pierdes dos "
                + "\n\tniveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2, 
                badConsequence, prize));
 
        /* Los hondos */
        badConsequence = new BCDeath("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8, badConsequence, prize));
        
        /* Semillas Cthulhu */
        badConsequence = new BCNumberOfTreasures("Pierdes 2 niveles y 2 tesoros "
                + "\n\tocultos", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        /* Dameargo */
        badConsequence = new BCSpecificTreasures("Te intentas escaquear. Pierdes una "
                + "\n\tmano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        /* Pollipólipo volante */
        badConsequence = new BCNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles",
                3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        /* Yskhtihyssg-Goth */
        badConsequence = new BCDeath("No le hace gracia que pronuncien "
                + "\n\tmal su nombre. Estas muerto", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        /* Familia feliz */
        badConsequence = new BCDeath("La familia te atrapa. Estas muerto",
                true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /* Roboggoth */
        badConsequence = new BCSpecificTreasures("La quinta directiva primaria te "
                + "\n\tobliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        /* El espia */
        badConsequence = new BCSpecificTreasures("Te asusta en la noche. Pierdes un "
                + "\n\tcasco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        
        /* El Lenguas */
        badConsequence = new BCNumberOfTreasures("Menudo susto te llevas. Pierdes 2 "
                + "\n\tniveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas" , 20, badConsequence, prize));
        
        /* Bicéfalo */

        badConsequence = new BCSpecificTreasures("Te faltan manos para tanta cabeza. " +
                         "\n\tPierdes 3 niveles y tus tesoros visibles de las manos", 3,
                         new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));

        // NUEVOS MONSTRUOS CON SECTARIOS
        
        /* El mal indecible impronunciable */
        badConsequence = new BCSpecificTreasures("Pierdes 1 mano visible.", 0,
                         new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        /* Testigos Oculares */
        badConsequence = new BCNumberOfTreasures("Pierdes tus tesoros visibles. Jajaja.", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence, prize, 2));

        /* El gran cthulhu */
        badConsequence = new BCDeath("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));

        /* Serpiente Político */
        badConsequence = new BCNumberOfTreasures("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));

        /* Felpuggoth */
        badConsequence = new BCSpecificTreasures("Pierdes tu casco y tu armadura visible. " +
                         "\n\tPierdes tus manos ocultas", 0,
                         new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.HELMET)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));

        /* Shoggoth */
        badConsequence = new BCNumberOfTreasures("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));

        /* Lolitagooth */
        badConsequence = new BCNumberOfTreasures("Pintalabios negro. Pierdes" +
                         "\n\t2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));

        
    }
    
    private void shuffleCultists()
    {
        Collections.shuffle(unusedCultists);
    }
    
    private void shuffleTreasures()
    {
        Collections.shuffle(unusedTreasures);
    }
        

    private void shuffleMonsters()
    {
        Collections.shuffle(unusedMonsters);
    }

    public Cultist nextCultist()
    {
        Cultist aDevolver = unusedCultists.get(unusedCultists.size()-1);
        unusedCultists.remove(aDevolver);
        return aDevolver;
    }

    public Treasure nextTreasure()
    {
        if(unusedTreasures.isEmpty())
        {
            Collections.shuffle(usedTreasures);
            unusedTreasures = (ArrayList<Treasure>) usedTreasures.clone(); 
            usedTreasures.clear();                          
        }                                                   
        Treasure tesoro = unusedTreasures.remove(0);
        usedTreasures.add(tesoro);
        return tesoro;
    }

    public Monster nextMonster()
    {
        if(unusedMonsters.isEmpty())
        {
            Collections.shuffle(usedMonsters);
            unusedMonsters = (ArrayList<Monster>) usedMonsters.clone();
            usedMonsters.clear();                         
        }                                                 
        Monster monstruo = unusedMonsters.remove(0);
        usedMonsters.add(monstruo);
        return monstruo; 
    }

    public void initCards()
    {
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistCardDeck();
        this.shuffleMonsters();
        this.shuffleTreasures();
        this.shuffleCultists();
    }

    public void giveTreasureBack(Treasure t)
    {
        usedTreasures.add(t);
        unusedTreasures.remove(t);
    }

    public void giveMonsterBack(Monster m)
    {
        usedMonsters.add(m);
        unusedMonsters.remove(m);
    }   
    
}
