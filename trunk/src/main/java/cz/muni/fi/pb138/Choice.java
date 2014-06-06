/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

/**
 *
 * @author Filip
 */
public class Choice {
    private int goTo;
    private String text;

    public Choice(int goTo, String text) {
        this.goTo = goTo;
        this.text = text;
    }

    public int getGoTo() {
        return goTo;
    }

    public String getText() {
        return text;
    }
    
    
}
