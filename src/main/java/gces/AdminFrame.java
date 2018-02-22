package gces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pradish on 2/19/2018.
 */

public class AdminFrame extends JOptionPane{
    private JButton showUsersBtn;
    private JButton userRegistrationBtn;
    private JButton projectRegistrationBtn;
    public AdminFrame(){
        showUsersBtn = new JButton("Show all users");
        showUsersBtn.addActionListener(new ActionListener() {
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

        projectRegistrationBtn = new JButton("Project Registration");
        projectRegistrationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProjectInputDialog().createDialog("Project Registration").setVisible(true);
            }
        });

        setMessage("Welcome to the admin panel.");
        setOptions(new Object[]{userRegistrationBtn, showUsersBtn, projectRegistrationBtn});
    }
}
