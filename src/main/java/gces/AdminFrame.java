package gces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pradish on 2/19/2018.
 */

public class AdminFrame extends JOptionPane{
    private JButton registerBtn;
    private JButton userRegistrationBtn;
    public AdminFrame(){
        registerBtn = new JButton("Users Panel");
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsersDialog().createDialog("Users Panel").setVisible(true);
            }
        });

        userRegistrationBtn = new JButton("User Registration");
        userRegistrationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserInputDialog().createDialog("User Registration").setVisible(true);
            }
        });

        setMessage("Welcome to the admin panel.");
        setOptions(new Object[]{userRegistrationBtn, registerBtn});
    }
}
