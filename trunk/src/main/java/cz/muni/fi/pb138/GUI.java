package cz.muni.fi.pb138;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        setTitle("Best text game ever.");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure? All your progress will be lost.",
                        "Exit confrimation", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    System.exit(0);
                }
            }
        });

        actualSceneLabel.setText("Scene text will be here.");
        actualSceneLabel.setVerticalAlignment(SwingConstants.TOP);
        actualSceneLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        firstOptionButton.setFont(new Font("Century", 0, 11));
        firstOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        firstOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        firstOptionButton.setText("<html>This article is meant for the individual who has little or no experience in" +
                " Java GUI programming. As such, this paper will focus on the hierar This article is meant for the " +
                "individual who has little or no experience in Java GUI programming. As such, this paper will focus " +
                "on the hierar This article is meant for the individual who has little or no experience in Java GUI " +
                "programming. As such, this paper will focus on the hierar</html>");
        firstOptionButton.setMargin(new Insets(2, 2, 2, 2));
        firstOptionButton.setVerticalAlignment(SwingConstants.TOP);
        firstOptionButton.setVerticalTextPosition(SwingConstants.TOP);

        secondOptionButton.setFont(new Font("Century", 0, 11));
        secondOptionButton.setText("<html>This article is meant for the individual who has little or no experience in" +
                " Java GUI programming. As such, this paper will focus on the hierar This article is meant for the " +
                "individual who has little or no experience in Java GUI programming. As such, this paper will focus " +
                "on the hierar This article is meant for the individual who has little or no experience in Java GUI " +
                "programming. As such, this paper will focus on the hierar</html>");
        secondOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        secondOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        secondOptionButton.setIconTextGap(2);
        secondOptionButton.setMargin(new Insets(2, 2, 2, 2));
        secondOptionButton.setVerticalAlignment(SwingConstants.TOP);
        secondOptionButton.setVerticalTextPosition(SwingConstants.TOP);

        thirdOptionButton.setFont(new Font("Century", 0, 11));
        thirdOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        thirdOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        thirdOptionButton.setText("<html>This article is meant for the individual who has little or no experience in" +
                " Java GUI programming. As such, this paper will focus on the hierar This article is meant for the " +
                "individual who has little or no experience in Java GUI programming. As such, this paper will focus " +
                "on the hierar This article is meant for the individual who has little or no experience in Java GUI " +
                "programming. As such, this paper will focus on the hierar</html>");
        thirdOptionButton.setMargin(new Insets(2, 2, 2, 2));
        thirdOptionButton.setVerticalAlignment(SwingConstants.TOP);
        thirdOptionButton.setVerticalTextPosition(SwingConstants.TOP);

        fourthOptionButton.setFont(new Font("Century", 0, 11));
        fourthOptionButton.setHorizontalAlignment(SwingConstants.LEFT);
        fourthOptionButton.setHorizontalTextPosition(SwingConstants.LEFT);
        fourthOptionButton.setText("<html>This article is meant for the individual who has little or no experience in" +
                " Java GUI programming. As such, this paper will focus on the hierar This article is meant for the " +
                "individual who has little or no experience in Java GUI programming. As such, this paper will focus " +
                "on the hierar This article is meant for the individual who has little or no experience in Java GUI " +
                "programming. As such, this paper will focus on the hierar</html>");
        fourthOptionButton.setMargin(new Insets(2, 2, 2, 2));
        fourthOptionButton.setVerticalAlignment(SwingConstants.TOP);
        fourthOptionButton.setVerticalTextPosition(SwingConstants.TOP);

        sceneNameLabel.setFont(new Font("Century", 0, 24));
        sceneNameLabel.setText("Name of the scene");

        topMenu.setText("File");
        topMenu.setFont(new Font("Century", 0, 12));

        topMenuExitProgram.setFont(new Font("Century", 0, 12));
        topMenuExitProgram.setText("Exit game");
        topMenuExitProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(mainFrame, "Are you sure? All your progress will be lost.", "Exit confrimation", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    System.exit(0);
                }
            }
        });
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
}
