package cz.muni.fi.pb138.GUIpackage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 426 max.
 * @author Martin Zaťko
 * @version 15.5.2014
 */
public class GUI extends JFrame {

    private GUI mainFrame;

    public GUI() {
        initComponents();
        mainFrame = this;
    }

    private void exitActionPerformed(AWTEvent e) {
        int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure? All your progress will be lost.",
                "Exit confrimation", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            System.exit(0);
        }
    }

    private void loadOurStoryActionPerformed(ActionEvent e) {
        LoadStorySwingWorker swingWorker = new LoadStorySwingWorker(mainFrame, sceneNameLabel, actualSceneLabel,
                firstOptionButton, secondOptionButton, thirdOptionButton, fourthOptionButton, new File("scenario/Testovaci_hra1.xml"));
        swingWorker.execute();
    }

    private void loadNewStoryActionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select file with story.");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.xml", "xml");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(mainFrame) == JFileChooser.APPROVE_OPTION) {
            File storyFile = chooser.getSelectedFile();
            String[] temp = storyFile.getName().split("\\.");
            if (temp[temp.length - 1].equals("xml")) {
                LoadStorySwingWorker swingWorker = new LoadStorySwingWorker(mainFrame, sceneNameLabel, actualSceneLabel,
                        firstOptionButton, secondOptionButton, thirdOptionButton, fourthOptionButton, storyFile);
                swingWorker.execute();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "I am very sorry but you have to select xml file.", "Wrong type of file", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void nextStepActionPerformed(ActionEvent e) {
        NextStepSwingWorker swingWorker = new NextStepSwingWorker(mainFrame, sceneNameLabel, actualSceneLabel,
                firstOptionButton, secondOptionButton, thirdOptionButton, fourthOptionButton, ((JButton)e.getSource()).getName());
        swingWorker.execute();
    }

    private void aboutActionPerformed(ActionEvent e) {
        try {
            File manual = new File("Manual.html");
            Desktop.getDesktop().browse(manual.toURI());
        } catch (IOException e1) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void initComponents() {

        sceneNameLabel = new JLabel();
        actualSceneLabel = new JLabel();
        firstOptionButton = new JButton();
        secondOptionButton = new JButton();
        thirdOptionButton = new JButton();
        fourthOptionButton = new JButton();
        topMenuBar = new JMenuBar();
        topMenu = new JMenu();
        topMenuExitProgram = new JMenuItem();
        topMenuOurStory = new JMenuItem();
        topMenuLoadNewStory = new JMenuItem();
        topMenuAbout = new JMenuItem();
        topMenuRecentlyUsed = new JMenu();
        topMenuRecentlyUsed0 = new JMenuItem();
        topMenuRecentlyUsed1 = new JMenuItem();
        topMenuRecentlyUsed2 = new JMenuItem();
        topMenuRecentlyUsed3 = new JMenuItem();

        setTitle("Text Game");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                exitActionPerformed(we);
            }
        });

        actualSceneLabel.setText(" Text of scene");
        actualSceneLabel.setVerticalAlignment(SwingConstants.TOP);
        actualSceneLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        firstOptionButton.setFont(new Font("Century", 0, 11));
        firstOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        firstOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        firstOptionButton.setEnabled(false);
        firstOptionButton.setText("");
        firstOptionButton.setMargin(new Insets(2, 2, 2, 2));
        firstOptionButton.setVerticalAlignment(SwingConstants.TOP);
        firstOptionButton.setVerticalTextPosition(SwingConstants.TOP);
        firstOptionButton.setName("first");
        firstOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextStepActionPerformed(e);
            }
        });

        secondOptionButton.setFont(new Font("Century", 0, 11));
        secondOptionButton.setEnabled(false);
        secondOptionButton.setText("");
        secondOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        secondOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        secondOptionButton.setIconTextGap(2);
        secondOptionButton.setMargin(new Insets(2, 2, 2, 2));
        secondOptionButton.setVerticalAlignment(SwingConstants.TOP);
        secondOptionButton.setVerticalTextPosition(SwingConstants.TOP);
        secondOptionButton.setName("second");
        secondOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextStepActionPerformed(e);
            }
        });

        thirdOptionButton.setFont(new Font("Century", 0, 11));
        thirdOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        thirdOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        thirdOptionButton.setEnabled(false);
        thirdOptionButton.setText("");
        thirdOptionButton.setMargin(new Insets(2, 2, 2, 2));
        thirdOptionButton.setVerticalAlignment(SwingConstants.TOP);
        thirdOptionButton.setVerticalTextPosition(SwingConstants.TOP);
        thirdOptionButton.setName("third");
        thirdOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextStepActionPerformed(e);
            }
        });

        fourthOptionButton.setFont(new Font("Century", 0, 11));
        fourthOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        fourthOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        fourthOptionButton.setEnabled(false);
        fourthOptionButton.setText("");
        fourthOptionButton.setMargin(new Insets(2, 2, 2, 2));
        fourthOptionButton.setVerticalAlignment(SwingConstants.TOP);
        fourthOptionButton.setVerticalTextPosition(SwingConstants.TOP);
        fourthOptionButton.setName("fourth");
        fourthOptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextStepActionPerformed(e);
            }
        });

        sceneNameLabel.setFont(new Font("Century", 0, 24));
        sceneNameLabel.setText("Name of the scene");

        topMenu.setText("File");
        topMenu.setFont(new Font("Century", 0, 12));

        topMenuOurStory.setFont(new Font("Century", 0, 12));
        topMenuOurStory.setText("Load our story");
        topMenuOurStory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadOurStoryActionPerformed(e);
            }
        });

        topMenuLoadNewStory.setFont(new Font("Century", 0, 12));
        topMenuLoadNewStory.setText("Load new story");
        topMenuLoadNewStory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadNewStoryActionPerformed(e);
            }
        });

        topMenuRecentlyUsed.setFont(new Font("Century", 0, 12));
        topMenuRecentlyUsed.setText("Recently used stories");

        topMenuRecentlyUsed0.setFont(new Font("Century", 0, 12));
        topMenuRecentlyUsed0.setText("latest");

        topMenuRecentlyUsed1.setFont(new Font("Century", 0, 12));
        topMenuRecentlyUsed1.setText("2nd latest");

        topMenuRecentlyUsed2.setFont(new Font("Century", 0, 12));
        topMenuRecentlyUsed2.setText("3nd latest");

        topMenuRecentlyUsed3.setFont(new Font("Century", 0, 12));
        topMenuRecentlyUsed3.setText("oldest");

        topMenuRecentlyUsed.add(topMenuRecentlyUsed0);
        topMenuRecentlyUsed.add(topMenuRecentlyUsed1);
        topMenuRecentlyUsed.add(topMenuRecentlyUsed2);
        topMenuRecentlyUsed.add(topMenuRecentlyUsed3);

        topMenuAbout.setFont(new Font("Century", 0, 12));
        topMenuAbout.setText("About");
        topMenuAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutActionPerformed(e);
            }
        });

        topMenuExitProgram.setFont(new Font("Century", 0, 12));
        topMenuExitProgram.setText("Exit game");
        topMenuExitProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitActionPerformed(e);
            }
        });

        topMenu.add(topMenuOurStory);
        topMenu.add(topMenuLoadNewStory);
        topMenu.add(topMenuRecentlyUsed);
        topMenu.add(topMenuAbout);
        topMenu.add(topMenuExitProgram);

        topMenuBar.add(topMenu);

        setJMenuBar(topMenuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(sceneNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(actualSceneLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(firstOptionButton, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                                        .addComponent(thirdOptionButton, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                                        .addComponent(fourthOptionButton, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                                        .addComponent(secondOptionButton, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sceneNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(actualSceneLabel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(firstOptionButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondOptionButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdOptionButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fourthOptionButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(getOwner());
    }

    private JButton firstOptionButton;
    private JButton secondOptionButton;
    private JButton thirdOptionButton;
    private JButton fourthOptionButton;
    private JLabel actualSceneLabel;
    private JLabel sceneNameLabel;
    private JMenu topMenu;
    private JMenuBar topMenuBar;
    private JMenuItem topMenuExitProgram;
    private JMenuItem topMenuLoadNewStory;
    private JMenuItem topMenuOurStory;
    private JMenuItem topMenuAbout;
    private JMenu topMenuRecentlyUsed;
    private JMenuItem topMenuRecentlyUsed0;
    private JMenuItem topMenuRecentlyUsed1;
    private JMenuItem topMenuRecentlyUsed2;
    private JMenuItem topMenuRecentlyUsed3;
}