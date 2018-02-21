package gces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInputDialog extends JOptionPane {
    public UserInputDialog(){
        JLabel barCodeLb = new JLabel("Barcode : ");
        JLabel nameLb = new JLabel("Name : ");
        JLabel contactLb = new JLabel("Contact : ");
        JTextField barCode = new JTextField();
        JTextField name = new JTextField();
        JTextField contact = new JTextField();

        JButton registerBtn = new JButton("Register");

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User myUser = new User(Integer.parseInt(barCode.getText()), name.getText(), contact.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(UserInputDialog.this, "Invalid Barcode", "Input Mismatch", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setOptions(new Object[]{registerBtn});
        setMessage(new Object[]{barCodeLb, barCode, nameLb, name, contactLb, contact});
    }
}
