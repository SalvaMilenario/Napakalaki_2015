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
public class CartasTesoros 
{
    public CartasTesoros()
    {
        //Tesoros revisados 1 vez por Dani
        //Estructura: Nombre, Piezas de oro, minBonus, maxBonus, TreasureKind.XXXXX
        ArrayList<Treasure> treasures = new ArrayList<>();
        treasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        treasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        treasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));
        treasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));
        treasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));
        treasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));
        treasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));
        treasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));
        treasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        treasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        treasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));
        treasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        treasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Necro-playboycon", 300, 3, 5, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Necro-comicón", 100, 1, 1, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Linterna a 2 manos", 400, 3, 6, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Necro-gnomicón", 200, 2, 4, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        treasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        treasures.add(new Treasure("Tentácula de pega", 200, 0, 1, TreasureKind.HELMET));
        treasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        treasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
        treasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
    }
}
