package controller.gameLoop.phase2.BossFight;

import controller.gameLoop.phase1.GameFrame;
import controller.gameLoop.phase2.normalAndMiniBossEnemies.CreateFrames;
import model.ClientModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import static view.EnterNamePageOnline.client;

public class EpsilonFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    public CreateFrames epsilonFrame;



    public EpsilonFrame(ClientModel client) {
        client.gameController.gameOver = false;

        this.epsilonFrame = new CreateFrames(450, 300, 400, 400);
    }

    public static void changeEpsilonFrameSize() {
        int x = client.gameController.xFrame1;
        int y = client.gameController.yFrame1;
        int width = client.gameController.widthFrame1;
        int height = client.gameController.heightFrame1;
//        if (gameFrame != null) {
//            gameFrame.setBounds(x, y, width, height);
//        }

    }




}
