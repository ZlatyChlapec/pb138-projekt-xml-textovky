/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filip
 */
public class SceneParser {
    private static Document doc;
    private static XPathFactory xpf = XPathFactory.newInstance();
    private static XPath xPath = xpf.newXPath();
    
    public static SceneParser newInstance(File file)
            throws SAXException, ParserConfigurationException, IOException {
        return new SceneParser(file.toURI());
    }
    
    private SceneParser(URI uri) throws SAXException, ParserConfigurationException,IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(uri.toString());
    }
    
    public GameScene parseScene(long id) {
        String xPathScene; 
        Node node;
        try {
            xPathScene = "//scene[@id='"+id+"']/name";
            String sceneName = (String) xPath.evaluate(xPathScene, doc.getDocumentElement(), XPathConstants.STRING);
            xPathScene = "//scene[@id='"+id+"']/description";
            String sceneDesc = (String) xPath.evaluate(xPathScene, doc.getDocumentElement(), XPathConstants.STRING);
            GameScene scene = new GameScene(id,sceneName.trim(),sceneDesc.trim());
            xPathScene = "count(//scene[@id='"+id+"']//choice)";
            double countDouble = (Double) xPath.evaluate(xPathScene, doc.getDocumentElement(), XPathConstants.NUMBER);
            int count = (int) countDouble;
            for(int i=1;i<=count;i++) {
                String xPathChoice = "//scene[@id='"+id+"']//choice["+i+"]/text";
                String choiceText = (String) xPath.evaluate(xPathChoice, doc.getDocumentElement(), XPathConstants.STRING);
                xPathChoice = "//scene[@id='"+id+"']//choice["+i+"]/@goTo";
                double choiceGoToDouble = (Double) xPath.evaluate(xPathChoice, doc.getDocumentElement(), XPathConstants.NUMBER);
                long choiceGoTo = (long) choiceGoToDouble;
                scene.setChoice(new Choice(choiceGoTo, choiceText));
            }
            return scene;
        } catch (XPathExpressionException ex) {
            Logger.getLogger(SceneParser.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return null;
    }
}