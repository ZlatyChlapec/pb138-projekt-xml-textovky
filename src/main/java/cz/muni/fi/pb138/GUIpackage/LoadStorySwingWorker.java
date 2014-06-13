package cz.muni.fi.pb138.GUIpackage;

import cz.muni.fi.pb138.Choice;
import cz.muni.fi.pb138.GameScene;
import cz.muni.fi.pb138.TextGame;
import cz.muni.fi.pb138.validators.StoryValidator;
import cz.muni.fi.pb138.validators.XmlValidator;

import javax.swing.*;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Load new story into program.
 *
 * @author Martin Zaťko
 * @version 9.6.2014
 */
public class LoadStorySwingWorker extends SwingWorker<Void, Void> {

    private JFrame mainFrame;
    private File storyFile;
    private long startingScene;
    private Choice[] choices;
    private int choice;
    private GameScene scene;
    private String gameName;

    public LoadStorySwingWorker(JFrame mainFrame, File storyFile) {
        this.mainFrame = mainFrame;
        this.storyFile = storyFile;
    }

    /**
     * Set up new story. Check if is all ok.
     *
     * @return Void
     * @throws Exception If something happen throw it.
     */
    @Override
    protected Void doInBackground() throws Exception {
        XmlValidator xmlValidator = new XmlValidator();
        xmlValidator.validateGameXml(storyFile.getAbsolutePath());

        StoryValidator storyValidator = new StoryValidator(storyFile.getAbsolutePath());
        startingScene = storyValidator.getStartingScene();
        Map<Long, GameScene> scenes = storyValidator.validateGameStory();

        gameName = storyValidator.getGameName();
        scene = scenes.get(startingScene);
        choice = scene.getChoicesCount();
        choices = new Choice[choice];
        for (int i = 0; i < choice; i++) {
            choices[i] = scene.getChoice(i);
        }
        TextGame.scenes = scenes;
        TextGame.choices = choices;
        TextGame.gameName = gameName;
        TextGame.gameScene = scene;
        return null;
    }

    /**
     * If something went wrong let us know.
     */
    @Override
    protected void done() {
        try {
            get();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something interrupted process while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        } catch (ExecutionException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something went wrong while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}