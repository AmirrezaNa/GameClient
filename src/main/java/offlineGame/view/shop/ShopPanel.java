package offlineGame.view.shop;

import offlineGame.controller.Constants;
import offlineGame.controller.game.GameController;
import offlineGame.view.startPage.EnterNamePage;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {

    ShopPanel() {
        this.setBackground(Color.BLACK);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0x8F0404));
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Wave : " + GameController.wave, 20, 20);
        g.drawString("Elapsed time : " + GameController.elapsedTime, 20, 40);
        g.drawString("XP : " + EnterNamePage.player.getXP(), 20, 60);
        g.drawString("HP : " + GameController.ball.HP, 20, 80);
        g.drawString("Abilities : ", 200, 20);
        if (EnterNamePage.player.isWritOfAres()) {
            g.drawString("WritOfAres", 200, 40);
        }
        if (EnterNamePage.player.isWritOfProteus()) {
            g.drawString("WritOfProteus", 200, 60);
        }
        if (EnterNamePage.player.isWritOfAceso()) {
            g.drawString("WritOfAceso", 200, 80);
        }
        if (EnterNamePage.player.isWritOfAstrape()) {
            g.drawString("WritOfAstrape", 200, 100);
        }
        if (EnterNamePage.player.isWritOfCerberus()) {
            g.drawString("WritOfCerberus", 200, 120);
        }
        if (EnterNamePage.player.isWritOfMelampus()) {
            g.drawString("WritOfMelampus", 200, 140);
        }
        if (EnterNamePage.player.isWritOfChiron()) {
            g.drawString("WritOfChiron", 200, 160);
        }
        if (EnterNamePage.player.isWritOfEmpusa()) {
            g.drawString("WritOfEmpusa", 200, 180);
        }
        if (EnterNamePage.player.isWritOfDolus()) {
            g.drawString("WritOfDolus", 200, 200);
        }


    }
}
