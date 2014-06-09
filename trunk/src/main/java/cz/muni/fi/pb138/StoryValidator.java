/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138;

import org.w3c.dom.Document;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filip
 */
public class StoryValidator {
    private Document doc;
    SceneParser parser;
    private static XPathFactory xpf = XPathFactory.newInstance();
    private static XPath xPath = xpf.newXPath();
    Map<Long, GameScene> game = new HashMap<>();
    Set<Long> checked = new HashSet<>();

    public StoryValidator(String fileName) throws IOException {
        File xmlFile = new File(fileName);
        try {
            parser = SceneParser.newInstance(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile.toURI().toString());
        } catch (SAXException | ParserConfigurationException ex) {
            Logger.getLogger(TextGame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void checkScene(long id) throws StoryValidateException {
        if (game.containsKey(id) == false) {
            throw new StoryValidateException("Choice reffering non-existent scene.");
        }
        GameScene scene = (GameScene) game.get(id);
        checked.add(id);
        for (int i=1;i<scene.getChoicesCount();i++) {
            Choice choice = scene.getChoice(i-1);
            long choiceId = choice.getGoTo();
            if (checked.contains(choiceId)) {
                continue;
            }
            checkScene(choice.getGoTo());
        }
    }
    
    public long getStartingScene() throws XPathExpressionException {
        double startDouble;
        String xPathId = "/game/@startingScene";
        startDouble = (Double) xPath.evaluate(xPathId, doc.getDocumentElement(), XPathConstants.NUMBER);
        return (long) startDouble;
    }
    
    public Map validateGameStory() throws StoryValidateException {
        try {
            String xPathId = "count(//scene)";
            double countDouble = (Double) xPath.evaluate(xPathId, doc.getDocumentElement(), XPathConstants.NUMBER);
            int count = (int) countDouble;
            for (int i=1;i<=count;i++) {
                String xPathScene = "//scene["+i+"]/@id";
                double idDouble = (Double) xPath.evaluate(xPathScene, doc.getDocumentElement(), XPathConstants.NUMBER);
                long id = (long) idDouble;
                GameScene scene = parser.parseScene(id);
                game.put(id, scene);
            }
            xPathId = "/game/@startingScene";
            double startDouble = (Double) xPath.evaluate(xPathId, doc.getDocumentElement(), XPathConstants.NUMBER);
            long start = (long) startDouble;
            checkScene(start);
            return game;
        } catch (XPathExpressionException ex) {
            Logger.getLogger(StoryValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}