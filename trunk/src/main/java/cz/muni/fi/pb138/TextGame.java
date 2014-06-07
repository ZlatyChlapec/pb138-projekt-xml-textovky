package cz.muni.fi.pb138;

import java.awt.*;

/**
 * @author Martin Zaťko
 * @version 15.5.2014
 */
public class TextGame {
    public static void main(String...args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI frame = new GUI();
                frame.setVisible(true);
            }
        });
        
       
    }
}
