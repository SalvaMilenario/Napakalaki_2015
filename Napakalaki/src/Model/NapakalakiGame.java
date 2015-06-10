
package Model;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;
//import Test.GameTester;

public class NapakalakiGame {

    public static void main(String[] args) {
      Napakalaki napakalakiModel = Napakalaki.getInstance();
      NapakalakiView napakalakiView = new NapakalakiView();
      
      Dice.createInstance (napakalakiView); //instancia del dado gráfico
//      napakalakiView.setNapakalaki(napakalakiModel); //se enlaza el modelo(Napakalaki) a la vista (NapakalakiView)

      ArrayList<String> names;
      PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
      names = namesCapture.getNames();
      
      napakalakiModel.initGame(names);
      napakalakiView.setNapakalaki(napakalakiModel); //se enlaza el modelo(Napakalaki) a la vista (NapakalakiView)
      napakalakiView.showView(); //ventana principal de la aplicación
            
      //GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      //test.play(game, 2); 
              
    }
}