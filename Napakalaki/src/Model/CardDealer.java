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
    
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)    
    private CardDealer()
    {
    }
    
    public static CardDealer getInstance()
    {
        return instance;
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
        badConsequence = new BadConsequence("Pierdes tu armadura visible y "
                + "\n\totra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 byankhees de bonanza", 8 , badConsequence, prize));
        
        /* Chubithulhu */
        badConsequence = new BadConsequence("Embobados con el lindo primigenio "
                + "\n\tte descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chubithulhu",2, badConsequence, prize));
        
        /*El sopor de Dunwich*/ 
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
                + "\n\tPierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2, badConsequence, prize));
        
         
        /* Ángeles de la noche ibicenca */
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta "
                + "\n\ty te dejan caer en mitad del vuelo. Descarta 1 mano visible "
                + "\n\ty 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, 
                badConsequence, prize));
        
        /* El gorrón en el umbral */
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0,
        Integer.MAX_VALUE,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",10, badConsequence, prize));
        
        /* H.P. Munchcraft */
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        /* Bichgooth */
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "\n\tDescarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2, badConsequence,prize));
        
        /* El rey de la rosa */
        badConsequence = new BadConsequence("Pierdes 5 niveles y "
                + "\n\t3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /* La que redacta en las tinieblas */
        badConsequence = new BadConsequence("Toses los pulmones y pierdes dos "
                + "\n\tniveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2, 
                badConsequence, prize));
 
        /* Los hondos */
        badConsequence = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8, badConsequence, prize));
        
        /* Semillas Cthulhu */
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros "
                + "\n\tocultos", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        /* Dameargo */
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una "
                + "\n\tmano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        /* Pollipólipo volante */
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",
                3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        /* Yskhtihyssg-Goth */
        badConsequence = new BadConsequence("No le hace gracia que pronuncien "
                + "\n\tmal su nombre. Estas muerto", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        /* Familia feliz */
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto",
                true);
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /* Roboggoth */
        badConsequence = new BadConsequence("La quinta directiva primaria te "
                + "\n\tobliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        /* El espia */
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un "
                + "\n\tcasco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        
        /* El Lenguas */
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 "
                + "\n\tniveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas" , 20, badConsequence, prize));
        
        /* Bicéfalo */

        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. " +
                         "\n\tPierdes 3 niveles y tus tesoros visibles de las manos", 3,
                         new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
    }

    private void shuffleTreasures()
    {
//        if( !unusedTreasures.isEmpty() ){
//            Random rand = new Random();
//            int tam = unusedTreasures.size();
//            ArrayList<Treasure> barajado = new ArrayList<>(tam);
//            for(Treasure t: unusedTreasures)
//            {
//                barajado.add((int)rand.nextDouble()*tam, t);
//            }
//            unusedTreasures = barajado;
//        }
        Collections.shuffle(unusedTreasures);
    }
        

    private void shuffleMonsters()
    {
//        if(!unusedMonsters.isEmpty()){
//            Random rand = new Random();
//            int tam = unusedMonsters.size();
//            ArrayList<Monster> barajado = new ArrayList<>(tam);
//            for(Monster m: unusedMonsters)
//            {
//                barajado.add((int)rand.nextDouble()*tam, m);
//            }
//            unusedMonsters = barajado;    
//        }
        Collections.shuffle(unusedMonsters);
        
    }

    public Treasure nextTreasure() //Habría que probarlo para asegurarse de que funciona
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

    public void initCards() // el llamador de estos métodos es this
    {
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.shuffleMonsters();
        this.shuffleTreasures();
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