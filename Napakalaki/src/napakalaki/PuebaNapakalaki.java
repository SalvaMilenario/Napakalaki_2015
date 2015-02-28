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
 //       ArrayList<TreasureKind> tesorosOcultos = ;
 //       ArrayList<TreasureKind> tesorosVisibles = ;
        Prize premios = new Prize(10,10);
        BadConsequence malaSuerte = new BadConsequence("Genera mil bugs inesperados en tu programa, mueres.", true);
        Monster bicharraco = new Monster("bicharraco", 4, malaSuerte, premios);
        System.out.println( bicharraco.toString() );
    }
    
}
