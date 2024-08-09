package controller.gameController.listener;

import model.ClientModel;
import model.entity.BallModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import static view.EnterNamePageOnline.client;

public class KeyInputListenerOnline implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!client.gameController.pause) {
            client.inputs.pressedKeys.add(e.getKeyCode());

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        client.inputs.pressedKeys.clear();
    }



}
