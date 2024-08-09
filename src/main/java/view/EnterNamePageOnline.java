package view;

import connection.ConnectionController;
import connection.ConnectionPage;
import connection.DataTransfer;
import model.ClientModel;
import offlineGame.controller.Constants;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EnterNamePageOnline extends JFrame implements ActionListener {
    JButton startButton;
    JTextField nameField;
    public static Player player;
    public static ClientModel client = new ClientModel();

    public EnterNamePageOnline() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        getContentPane().setBackground(Color.BLACK);


        nameField = new JTextField("Name");
        nameField.setBounds(75, 160, 170, 40);
        nameField.setFont(new Font("Consolas", Font.PLAIN, 17));
        nameField.setForeground(Color.BLACK);
        nameField.setBorder(BorderFactory.createEtchedBorder());
        nameField.setBackground(new Color(0x8F0404));


        startButton = new JButton();
        startButton.setFocusable(false);
        startButton.setBackground(new Color(0x8F0404));
        startButton.setText("Start");
        startButton.setForeground(Color.BLACK);
        startButton.setBounds(115, 300, 100, 50);
        startButton.addActionListener(this);
        startButton.setBorder(BorderFactory.createEtchedBorder());




        this.add(nameField);
        this.add(startButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            newPlayer();
            player.setName(nameField.getText());
            this.dispose();
            if (ConnectionPage.connected) {
                sendPlayerNameToServer(player.getName());
            }
            // call a method to start the game for client
            try {
                DataTransfer.createClient(client);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }


        }
    }

    public static void newPlayer() {
        player = new Player();
    }

    public void sendPlayerNameToServer(String name) {
        ConnectionController.output.println(name);
    }
}
