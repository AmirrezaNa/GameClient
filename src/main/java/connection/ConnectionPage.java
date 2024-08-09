package connection;

import offlineGame.controller.Constants;
import offlineGame.view.startPage.EnterNamePage;
import view.EnterNamePageOnline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionPage extends JFrame implements ActionListener {

    JButton offlineButton;
    JButton onlineButton;
    public static boolean online;
    public static boolean connected;

    public ConnectionPage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        getContentPane().setBackground(Color.BLACK);



        offlineButton = new JButton();
        offlineButton.setFocusable(false);
        offlineButton.setBackground(new Color(0x8F0404));
        offlineButton.setText("offline");
        offlineButton.setForeground(Color.BLACK);
        offlineButton.setBounds(115, 150, 100, 50);
        offlineButton.addActionListener(this);
        offlineButton.setBorder(BorderFactory.createEtchedBorder());


        onlineButton = new JButton();
        onlineButton.setFocusable(false);
        onlineButton.setBackground(new Color(0x8F0404));
        onlineButton.setText("online");
        onlineButton.setForeground(Color.BLACK);
        onlineButton.setBounds(115, 250, 100, 50);
        onlineButton.addActionListener(this);
        onlineButton.setBorder(BorderFactory.createEtchedBorder());




        this.add(offlineButton);
        this.add(onlineButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == offlineButton) {
            online = false;
            connected =  false;
            this.dispose();
            new EnterNamePage();
        }
        if (e.getSource() == onlineButton) {
            online = true;
            if (!ConnectionController.connectToServer()) {
                JOptionPane.showMessageDialog(this, "Something went wrong!", "connection state", JOptionPane.PLAIN_MESSAGE);
            }
            if (connected) {
                this.dispose();
                EnterNamePageOnline enterNamePageOnline = new EnterNamePageOnline();
            }

        }
    }

}
