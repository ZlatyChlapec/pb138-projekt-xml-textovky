package cz.muni.fi.pb138;

import cz.muni.fi.pb138.GUIpackage.GUI;
import cz.muni.fi.pb138.GUIpackage.LoadStorySwingWorker;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class which with you should run program.
 *
 * @author Martin Zaťko
 * @version 15.5.2014
 */
public class TextGame {

    public static Map<Long,GameScene> scenes = new HashMap<>();
    public static Choice[] choices;
    public static String gameName;
    public static GameScene gameScene;
    public static String firstRecent;
    public static String secondRecent;
    public static String thirdRecent;
    public static String fourthRecent;
    public static long firstOption = -1;
    public static long secondOption = -1;
    public static long thirdOption = -1;
    public static long fourthOption = -1;

    public static void main(String...args) {

        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            firstRecent = prop.getProperty("recentlyUsed0");
            secondRecent = prop.getProperty("recentlyUsed1");
            thirdRecent = prop.getProperty("recentlyUsed2");
            fourthRecent = prop.getProperty("recentlyUsed3");
        } catch (FileNotFoundException e) {
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI frame = new GUI();
                frame.setVisible(true);
            }
        });
        
       
    }
}