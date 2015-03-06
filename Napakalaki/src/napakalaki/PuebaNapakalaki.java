/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author Salva & xehartnort
 */
public class PuebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<TreasureKind> tesorosOcultos = new ArrayList<>();
        ArrayList<TreasureKind> tesorosVisibles = new ArrayList<>();
        tesorosOcultos.add(TreasureKind.ARMOR);
        tesorosVisibles.add(TreasureKind.SHOE);
        Prize premios = new Prize(10,10);
        Prize premio2 = new Prize(2, 1);
        BadConsequence malRollo = new BadConsequence ("Al programar el metodo toString lo hace sin saltos de linea pierdes 2 niveles"
                + " la armadura visible y el calzado oculto",2, tesorosVisibles, tesorosOcultos);
        BadConsequence malaSuerte = new BadConsequence("Genera mil bugs inesperados en tu programa, mueres.", true);
        Monster bicharraco = new Monster("Bicharraco", 4, malaSuerte, premios);
        Monster danilaco = new Monster("Danilaco", 8, malRollo, premio2);
        System.out.println( bicharraco.toString() );
        System.out.println(danilaco.toString());
    }
    
}
