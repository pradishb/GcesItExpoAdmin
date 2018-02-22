package gces;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.firebase.database.DatabaseReference;

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
                    JDialog loading = new WorkingDialog().createDialog("Uploading to the database");


                    DatabaseReference ref = FirebaseEngine.database.getReference("users");
                    ApiFuture<Void> task = ref.push().setValueAsync(myUser);

                    ApiFutures.addCallback(task, new ApiFutureCallback<Void>() {
                        @Override
                        public void onSuccess(Void result) {
                            loading.dispose();
                            JOptionPane.showMessageDialog(getRootFrame(), "Successfully registered user to the database");
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            loading.dispose();
                            JOptionPane.showMessageDialog(getRootFrame(), "Error while registering user to the database");
                        }
                    });

                    loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    loading.setVisible(true);
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
