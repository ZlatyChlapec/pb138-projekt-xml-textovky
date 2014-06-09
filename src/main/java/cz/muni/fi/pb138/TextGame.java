package cz.muni.fi.pb138;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPathExpressionException;

/**
 * @author Martin Zaťko
 * @version 15.5.2014
 */
public class TextGame {
    public static void main(String...args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (StoryValidateException ex) {
                    Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (XPathExpressionException ex) {
                    Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
       
    }
}