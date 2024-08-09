package offlineGame.view.skillTree;

import offlineGame.controller.Constants;

import javax.swing.*;
import java.awt.*;

public class SkillTreePanel extends JPanel {
    SkillTreePanel() {
        this.setBackground(Color.BLACK);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0x8F0404));
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        //g.drawString("XP : " + GameController.player.XP, 30, 50);

    }
}
