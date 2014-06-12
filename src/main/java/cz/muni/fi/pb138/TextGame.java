package cz.muni.fi.pb138;

import cz.muni.fi.pb138.GUIpackage.GUI;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Martin Zaťko
 * @version 15.5.2014
 */
public class TextGame {

    public static Map<Long,GameScene> scenes = new HashMap<>();
    public static long firstOption = -1;
    public static long secondOption = -1;
    public static long thirdOption = -1;
    public static long fourthOption = -1;

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