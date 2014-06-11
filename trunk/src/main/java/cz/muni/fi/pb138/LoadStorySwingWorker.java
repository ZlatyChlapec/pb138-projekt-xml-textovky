package cz.muni.fi.pb138;

import javax.swing.*;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Martin Zaťko
 * @version 9.6.2014
 */
public class LoadStorySwingWorker extends SwingWorker<Map<Long, GameScene>, Void> {

    private JFrame mainFrame;
    private JLabel sceneNameLabel;
    private JLabel actualSceneLabel;
    private JButton firstOptionButton;
    private JButton secondOptionButton;
    private JButton thirdOptionButton;
    private JButton fourthOptionButton;
    private File storyFile;
    private long startingScene;
    private Choice[] choices;
    private int choice;
    private GameScene scene;
    private String gameName;

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
    protected Map<Long, GameScene> doInBackground() throws Exception {
        XmlValidator xmlValidator = new XmlValidator();
        xmlValidator.validateGameXml(storyFile.getPath());

        StoryValidator storyValidator = new StoryValidator(storyFile.getPath());
        startingScene = storyValidator.getStartingScene();
        Map<Long, GameScene> scenes = storyValidator.validateGameStory();

        gameName = storyValidator.getGameName();
        scene = scenes.get(startingScene);
        choice = scene.getChoicesCount();
        choices = new Choice[choice];
        for (int i = 0; i < choice; i++) {
            choices[i] = scene.getChoice(i);
        }
        return scenes;
    }

    @Override
    protected void done() {
        try {
            TextGame.scenes = get();
            mainFrame.setTitle(gameName);
            sceneNameLabel.setText(scene.getSceneName());
            actualSceneLabel.setText("<html>"+ scene.getSceneDesc() +"</html>");
            switch (choice) {
                case 0:
                    firstOptionButton.setEnabled(false);
                    firstOptionButton.setText("");
                    secondOptionButton.setEnabled(false);
                    secondOptionButton.setText("");
                    thirdOptionButton.setEnabled(false);
                    thirdOptionButton.setText("");
                    fourthOptionButton.setEnabled(false);
                    fourthOptionButton.setText("");
                    JOptionPane.showMessageDialog(mainFrame, "Congratulations you made it.", "Game over", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    firstOptionButton.setText("<html>"+ choices[0].getText() +"</html>");
                    firstOptionButton.setEnabled(true);
                    secondOptionButton.setText("");
                    secondOptionButton.setEnabled(false);
                    thirdOptionButton.setText("");
                    thirdOptionButton.setEnabled(false);
                    fourthOptionButton.setText("");
                    fourthOptionButton.setEnabled(false);
                    TextGame.firstOption = choices[0].getGoTo();
                    TextGame.secondOption = -1;
                    TextGame.thirdOption = -1;
                    TextGame.fourthOption = -1;
                    break;
                case 2:
                    firstOptionButton.setText("<html>"+ choices[0].getText() +"</html>");
                    firstOptionButton.setEnabled(true);
                    secondOptionButton.setText("<html>"+ choices[1].getText() +"</html>");
                    secondOptionButton.setEnabled(true);
                    thirdOptionButton.setText("");
                    thirdOptionButton.setEnabled(false);
                    fourthOptionButton.setText("");
                    fourthOptionButton.setEnabled(false);
                    TextGame.firstOption = choices[0].getGoTo();
                    TextGame.secondOption = choices[1].getGoTo();
                    TextGame.thirdOption = -1;
                    TextGame.fourthOption = -1;
                    break;
                case 3:
                    firstOptionButton.setText("<html>"+ choices[0].getText() +"</html>");
                    firstOptionButton.setEnabled(true);
                    secondOptionButton.setText("<html>"+ choices[1].getText() +"</html>");
                    secondOptionButton.setEnabled(true);
                    thirdOptionButton.setText("<html>"+ choices[2].getText() +"</html>");
                    thirdOptionButton.setEnabled(true);
                    fourthOptionButton.setText("");
                    fourthOptionButton.setEnabled(false);
                    TextGame.firstOption = choices[0].getGoTo();
                    TextGame.secondOption = choices[1].getGoTo();
                    TextGame.thirdOption = choices[2].getGoTo();
                    TextGame.fourthOption = -1;
                    break;
                case 4:
                    firstOptionButton.setText("<html>"+ choices[0].getText() +"</html>");
                    firstOptionButton.setEnabled(true);
                    secondOptionButton.setText("<html>"+ choices[1].getText() +"</html>");
                    secondOptionButton.setEnabled(true);
                    thirdOptionButton.setText("<html>"+ choices[2].getText() +"</html>");
                    thirdOptionButton.setEnabled(true);
                    fourthOptionButton.setText("<html>"+ choices[3].getText() +"</html>");
                    fourthOptionButton.setEnabled(true);
                    TextGame.firstOption = choices[0].getGoTo();
                    TextGame.secondOption = choices[1].getGoTo();
                    TextGame.thirdOption = choices[2].getGoTo();
                    TextGame.fourthOption = choices[3].getGoTo();
                    break;
            }
            JOptionPane.showMessageDialog(mainFrame, "Story was successfully loaded.", "Story loaded", JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something interrupted process while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        } catch (ExecutionException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something went wrong while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}