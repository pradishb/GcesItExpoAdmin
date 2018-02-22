package gces;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.firebase.database.DatabaseReference;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectInputDialog extends JOptionPane {

    public ProjectInputDialog(){
        JLabel titleLb = new JLabel("Title : ");
        JTextField title = new JTextField();

        JButton registerBtn = new JButton("Register");

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project myProject = new Project(title.getText());
                JDialog loading = new WorkingDialog().createDialog("Uploading to the database");

                DatabaseReference ref = FirebaseEngine.database.getReference("projects");
                ApiFuture<Void> task = ref.push().setValueAsync(myProject);

                ApiFutures.addCallback(task, new ApiFutureCallback<Void>() {
                    @Override
                    public void onSuccess(Void result) {
                        loading.dispose();
                        JOptionPane.showMessageDialog(getRootFrame(), "Successfully registered project to the database");
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        loading.dispose();
                        JOptionPane.showMessageDialog(getRootFrame(), "Error while registering project to the database");
                    }
                });

                loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                loading.setVisible(true);
            }
        });

        setOptions(new Object[]{registerBtn});
        setMessage(new Object[]{titleLb, title});
    }
}
