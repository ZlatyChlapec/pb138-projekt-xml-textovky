/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
    
    private SceneParser(URI uri) throws SAXException, ParserConfigurationException,
            IOException {
        // Vytvorime instanci tovarni tridy
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Pomoci tovarni tridy ziskame instanci DocumentBuilderu
        DocumentBuilder builder = factory.newDocumentBuilder();
        // DocumentBuilder pouzijeme pro zpracovani XML dokumentu
        // a ziskame model dokumentu ve formatu W3C DOM
        doc = builder.parse(uri.toString());
    }
    
    public static GameScene parseScene(int id) {
        String xPathScene = "//scene[@id='"+id+"']"; 
        Node node;
        try {
            node = (Node) xPath.evaluate(xPathScene, doc.getDocumentElement(), XPathConstants.NODE);
            NodeList list = node.getChildNodes();
            String sceneName = list.item(0).getNodeValue();
            String sceneDesc = list.item(1).getNodeValue();
            GameScene scene = new GameScene(sceneName,sceneDesc);
            NodeList choices = list.item(2).getChildNodes();
            int count = choices.getLength();
            for(int i=0;i<count;i++) {
                String choiceText = choices.item(i).getFirstChild().getNodeValue();
                NamedNodeMap attributes = choices.item(i).getAttributes();
                String goTo = attributes.getNamedItem("goTo").getNodeValue();
                int goToId = Integer.parseInt(goTo);
                scene.setChoice(new Choice(goToId,choiceText));
            }
        } catch (XPathExpressionException ex) {
            Logger.getLogger(SceneParser.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return null;
    }
}
