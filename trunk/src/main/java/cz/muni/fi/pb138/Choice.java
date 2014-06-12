/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

/**
 *
 * @author Filip Sonta
 * @version 1.0
 */
public class Choice {
    private long goTo;
    private String text;

    public Choice(long goTo, String text) {
        this.goTo = goTo;
        this.text = text;
    }

    public long getGoTo() {
        return goTo;
    }

    public String getText() {
        return text;
    }
    
    
}