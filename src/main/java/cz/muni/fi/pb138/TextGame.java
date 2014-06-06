package cz.muni.fi.pb138;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Martin Zaťko
 * @version 15.5.2014
 */
public class TextGame {
    public static void main(String...args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                GUI frame = new GUI();
//                frame.setVisible(true);
//            }
//        });
//        
        File oo = new File("src/test/resources/testXML.xml");
        try {
            SceneParser test = SceneParser.newInstance(oo);
        } catch (SAXException ex) {
            Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GameScene sc;
        sc = SceneParser.parseScene(1);
//        System.out.println(sc.getSceneName());
    }
}
