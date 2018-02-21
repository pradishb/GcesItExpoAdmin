package gces;

import javax.swing.*;

public class UserInputDialog extends JOptionPane {
    public UserInputDialog(){
        JLabel barCodeLb = new JLabel("Barcode : ");
        JLabel nameLb = new JLabel("Name : ");
        JLabel contactLb = new JLabel("Contact : ");
        JTextField barCode = new JTextField();
        JTextField name = new JTextField();
        JTextField contact = new JTextField();

        setOptionType(OK_CANCEL_OPTION);
        setMessage(new Object[]{barCodeLb, barCode, nameLb, name, contactLb, contact});
        try {
            User myUser = new User(Integer.parseInt(barCode.getText()), name.getText(), contact.getText());
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(UserInputDialog.this, "Invalid Barcode", "Input Mismatch", JOptionPane.ERROR_MESSAGE);
        }
    }
}
