package cz.muni.fi.pb138;

import javax.swing.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Martin Zaťko
 * @version 10.6.2014
 */
public class NextStepSwingWorker extends SwingWorker<Void, Void> {

    private JFrame mainFrame;
    private JLabel sceneNameLabel;
    private JLabel actualSceneLabel;
    private JButton firstOptionButton;
    private JButton secondOptionButton;
    private JButton thirdOptionButton;
    private JButton fourthOptionButton;
    private Choice[] choices;
    private int choice;
    private String button;
    private GameScene scene;

    public NextStepSwingWorker(JFrame mainFrame, JLabel sceneNameLabel, JLabel actualSceneLabel,
                               JButton firstOptionButton, JButton secondOptionButton, JButton thirdOptionButton,
                               JButton fourthOptionButton, String button) {
        this.mainFrame = mainFrame;
        this.sceneNameLabel = sceneNameLabel;
        this.actualSceneLabel = actualSceneLabel;
        this.firstOptionButton = firstOptionButton;
        this.secondOptionButton = secondOptionButton;
        this.thirdOptionButton = thirdOptionButton;
        this.fourthOptionButton = fourthOptionButton;
        this.button = button;
    }

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
        choice = scene.getChoicesCount();
        choices = new Choice[choice];
        for (int i = 0; i < choice; i++) {
            choices[i] = scene.getChoice(i);
        }
        return null;
    }

    @Override
    protected void done() {
        try {
            get();
            if (scene == null) {
                JOptionPane.showMessageDialog(mainFrame, "There are some serious errors in code.", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
            }
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
                    secondOptionButton.setText("<html>" + choices[1].getText() + "</html>");
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
                    secondOptionButton.setText("<html>" + choices[1].getText() + "</html>");
                    secondOptionButton.setEnabled(true);
                    thirdOptionButton.setText("<html>" + choices[2].getText() + "</html>");
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
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something interrupted process while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        } catch (ExecutionException e) {
            JOptionPane.showMessageDialog(mainFrame, "Something went wrong while loading story. Check logger for further information.", "Failed to load story.", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(LoadStorySwingWorker.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
