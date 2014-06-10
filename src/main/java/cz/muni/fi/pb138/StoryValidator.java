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
    private SceneParser parser;
    private static XPathFactory xpf = XPathFactory.newInstance();
    private static XPath xPath = xpf.newXPath();
    private Map<Long, GameScene> game = new HashMap<>();
    private Set<Long> checked = new HashSet<>();
    private boolean hasEnd;

    public StoryValidator(String fileName) throws IOException {
        File xmlFile = new File(fileName);
        try {
            parser = SceneParser.newInstance(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(xmlFile.toURI().toString());
            hasEnd = false;
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
        if (scene.getChoicesCount()==0) hasEnd = true;
        for (int i=1;i<=scene.getChoicesCount();i++) {
            long choiceId = scene.getChoiceGoTo(i-1);
            if (id == choiceId) throw new StoryValidateException("Choice reffering same scene where it is declared.");
            if (checked.contains(choiceId)) {
                continue;
            }
            checkScene(choiceId);
        }
    }
    
    public long getStartingScene() throws XPathExpressionException {
        double startDouble;
        String xPathId = "/game/@startingScene";
        startDouble = (Double) xPath.evaluate(xPathId, doc.getDocumentElement(), XPathConstants.NUMBER);
        return (long) startDouble;
    }
    
    public String getGameName() {
        try {
            String xPathGameName = "/game/@name";
            String gameName = (String) xPath.evaluate(xPathGameName, doc.getDocumentElement(), XPathConstants.STRING);
            return gameName;
        } catch (XPathExpressionException ex) {
            Logger.getLogger(StoryValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Map<Long, GameScene> validateGameStory() throws StoryValidateException {
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
            checkScene(getStartingScene());
            if (hasEnd == false) throw new StoryValidateException("Game has no final scene.");
            if (count != checked.size()) throw new StoryValidateException("Game has unused scenes.");
            return game;
        } catch (XPathExpressionException ex) {
            Logger.getLogger(StoryValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}