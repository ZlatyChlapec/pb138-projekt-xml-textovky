package cz.muni.fi.pb138.GUIpackage;

import cz.muni.fi.pb138.Choice;
import cz.muni.fi.pb138.GameScene;
import cz.muni.fi.pb138.TextGame;

import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provide information for next step.
 *
 * @author Martin Zaťko
 * @version 10.6.2014
 */
public class NextStepSwingWorker extends SwingWorker<Void, Void> {

    private JFrame mainFrame;
    private Choice[] choices;
    private int choice;
    private String button;
    private GameScene scene;

    public NextStepSwingWorker(JFrame mainFrame, String button) {
        this.mainFrame = mainFrame;
        this.button = button;
    }

    /**
     * Actualize information about scenes.
     *
     * @return Void
     * @throws Exception If something happen throw it.
     */
    @Override
    protected Void doInBackground() throws Exception {
        switch (button) {
            case "first":
                scene = TextGame.scenes.get(TextGame.firstOption);
                break;
            case "second":
                scene = TextGame.scenes.get(TextGame.secondOption);
                break;
            case "third":
                scene = TextGame.scenes.get(TextGame.thirdOption);
                break;
            case "fourth":
                scene = TextGame.scenes.get(TextGame.fourthOption);
                break;
            default:
                scene = null;
                break;
        }
        if (scene != null) {
            choice = scene.getChoicesCount();
            choices = new Choice[choice];
            for (int i = 0; i < choice; i++) {
                choices[i] = scene.getChoice(i);
            }
            TextGame.choices = choices;
            TextGame.gameScene = scene;
        }
        return null;
    }

    /**
     * If something went wrong let us know.
     */
    @Override
    protected void done() {
        try {
            get();
            if (scene == null) {
                JOptionPane.showMessageDialog(mainFrame, "There are some serious errors in code.", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something interrupted process while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        } catch (ExecutionException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something went wrong while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
