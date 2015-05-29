
package Model;

import GUI.NapakalakiView;
import Test.GameTester;

public class EjemploMain {

    public static void main(String[] args) {
      Napakalaki napakalakiModel = Napakalaki.getInstance();
      NapakalakiView napakalakiView = new NapakalakiView();
      
      Dice.createInstance (napakalakiView); //instancia del dado gráfico
      napakalakiView.setNapakalaki(napakalakiModel); //se enlaza el modelo(Napakalaki) a la vista (NapakalakiView)
      napakalakiView.showView(); //ventana principal de la aplicación
      
      

      //GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      //test.play(game, 2); 
              
    }
}