/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author xehartnort
 */
public class BadConsequence {
    private String text; // array vacío
    private int levels; //0
    private int nVisisbleTreasures;
    private int nHiddenTreasures;
    private boolean death; //false
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisisbleTreasures = 0;
        this.nHiddenTreasures = nHidden;
        this.death = false;

    }
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.levels = 0;
        this.nVisisbleTreasures = 0;
        this.nHiddenTreasures = 0;    
        this.death = death;
    }
}
