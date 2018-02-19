package gces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

/**
 * Created by pradish on 2/19/2018.
 */

public class AdminFrame extends JFrame{
    private JButton registerBtn;
    public AdminFrame(){
        super("Admin Panel");
        setVisible(true);
        setSize(500, 500);
        setLayout(new FlowLayout());
        registerBtn = new JButton("Register People");
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel barCodeLb = new JLabel("Barcode : ");
                JLabel nameLb = new JLabel("Name : ");
                JLabel contactLb = new JLabel("Contact : ");
                JTextField barCode = new JTextField();
                JTextField name = new JTextField();
                JTextField contact = new JTextField();
                JOptionPane.showOptionDialog(AdminFrame.this, new Object[]{barCodeLb, barCode, nameLb, name, contactLb, contact}, "input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                try {
                    User myUser = new User(Integer.parseInt(barCode.getText()), name.getText(), contact.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(AdminFrame.this, "Invalid Barcode", "Input Mismatch", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(registerBtn);
    }
}
