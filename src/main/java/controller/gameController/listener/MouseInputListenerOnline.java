package controller.gameController.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static view.EnterNamePageOnline.client;

public class MouseInputListenerOnline implements MouseListener, MouseMotionListener {

    public static double x = 0;
    public static double y = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        client.inputs.mousePoint = e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        client.inputs.mousePoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
