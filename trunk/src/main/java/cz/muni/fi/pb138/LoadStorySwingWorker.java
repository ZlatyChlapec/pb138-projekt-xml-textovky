package cz.muni.fi.pb138;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Martin Zaťko
 * @version 9.6.2014
 */
public class LoadStorySwingWorker extends SwingWorker<Void, Void> {

    private JFrame mainFrame;
    private JLabel sceneNameLabel;
    private JLabel actualSceneLabel;
    private JButton firstOptionButton;
    private JButton secondOptionButton;
    private JButton thirdOptionButton;
    private JButton fourthOptionButton;
    private File storyFile;

    public LoadStorySwingWorker(JFrame mainFrame, JLabel sceneNameLabel, JLabel actualSceneLabel,
                                JButton firstOptionButton, JButton secondOptionButton, JButton thirdOptionButton,
                                JButton fourthOptionButton, File storyFile) {
        this.mainFrame = mainFrame;
        this.sceneNameLabel = sceneNameLabel;
        this.actualSceneLabel = actualSceneLabel;
        this.firstOptionButton = firstOptionButton;
        this.secondOptionButton = secondOptionButton;
        this.thirdOptionButton = thirdOptionButton;
        this.fourthOptionButton = fourthOptionButton;
        this.storyFile = storyFile;
    }

    @Override
    protected Void doInBackground() throws Exception {
        XmlValidator validate = new XmlValidator();
        validate.validateGameXml(storyFile.getPath());
        return null;
    }

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