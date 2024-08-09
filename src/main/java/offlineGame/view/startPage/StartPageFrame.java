package offlineGame.view.startPage;

import offlineGame.controller.Constants;
import offlineGame.controller.game.GameController;
import offlineGame.view.gameLoop.phase1.GameFrame;
import offlineGame.view.gameLoop.phase1.GamePanel;
import offlineGame.view.settings.SettingsFrame;
import offlineGame.view.skillTree.SkillTreeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static offlineGame.controller.data.controller.SoundEffects.playSong;

public class StartPageFrame extends JFrame implements ActionListener {


    JButton startButton;
    JButton skillTreeButton;
    JButton guideButton;
    JButton settingsButton;
    JButton exitButton;

    public StartPageFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        getContentPane().setBackground(Color.BLACK);


        startButton = new JButton();
        startButton.setFocusable(false);
        startButton.setBackground(new Color(0x8F0404));
        startButton.setText("Start");
        startButton.setForeground(Color.BLACK);
        startButton.setBounds(65, 40, 100, 50);
        startButton.addActionListener(this);
        startButton.setBorder(BorderFactory.createEtchedBorder());


        skillTreeButton = new JButton();
        skillTreeButton.setFocusable(false);
        skillTreeButton.setBackground(new Color(0x8F0404));
        skillTreeButton.setText("Skill Tree");
        skillTreeButton.setForeground(Color.BLACK);
        skillTreeButton.setBounds(175, 125, 100, 50);
        skillTreeButton.addActionListener(this);
        skillTreeButton.setBorder(BorderFactory.createEtchedBorder());


        guideButton = new JButton();
        guideButton.setFocusable(false);
        guideButton.setBackground(new Color(0x8F0404));
        guideButton.setText("Guide");
        guideButton.setForeground(Color.BLACK);
        guideButton.setBounds(65, 210, 100, 50);
        guideButton.addActionListener(this);
        guideButton.setBorder(BorderFactory.createEtchedBorder());


        settingsButton = new JButton();
        settingsButton.setFocusable(false);
        settingsButton.setBackground(new Color(0x8F0404));
        settingsButton.setText("Settings");
        settingsButton.setForeground(Color.BLACK);
        settingsButton.setBounds(175, 295, 100, 50);
        settingsButton.addActionListener(this);
        settingsButton.setBorder(BorderFactory.createEtchedBorder());


        exitButton = new JButton();
        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(0x8F0404));
        exitButton.setText("Exit");
        exitButton.setForeground(Color.BLACK);
        exitButton.setBounds(65, 380, 100, 50);
        exitButton.addActionListener(this);
        exitButton.setBorder(BorderFactory.createEtchedBorder());


        this.add(startButton);
        this.add(skillTreeButton);
        this.add(guideButton);
        this.add(settingsButton);
        this.add(exitButton);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            Thread soundThread = new Thread(() -> {
                playSong(Constants.GAME_SONG_PATH);
            });
            soundThread.start();
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                GameController.pause = false;
                GamePanel.phase1over = false;
                GameFrame gameFrame = new GameFrame();
            });

        }
        if (e.getSource() == skillTreeButton) {
            this.dispose();
            SkillTreeFrame skillTreeFrame = new SkillTreeFrame();
        }
        if (e.getSource() == guideButton) {

        }
        if (e.getSource() == settingsButton) {
            this.dispose();
            SettingsFrame settingsFrame = new SettingsFrame();
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
