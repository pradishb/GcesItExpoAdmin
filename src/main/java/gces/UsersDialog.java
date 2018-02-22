package gces;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

class UsersDialog extends JOptionPane {
    private JTable table;
    private JScrollPane tableSp;
    private final String[] COLS = {"Barcode", "Name", "Contact"};
    UsersDialog(){

        TableModel model = new DefaultTableModel(new String[][]{}, COLS);
        table = new JTable(model);
        tableSp = new JScrollPane(table);
        setMessage(new Object[]{tableSp});

        JDialog loading = new WorkingDialog().createDialog("Downloading data");

        DatabaseReference ref = FirebaseEngine.database.getReference("users");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Object[]> myContacts = new ArrayList<>();

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    User myItem = postSnapshot.getValue(User.class);
                    myContacts.add(new Object[]{myItem.getBarCode(), myItem.getName(), myItem.getContactNo()});
                }

                Object[][] data = new Object[myContacts.size()][];

                for(int i = 0; i < myContacts.size(); i++){
                    data[i] = myContacts.get(i);
                }
                TableModel model = new DefaultTableModel(data, COLS);
                table.setModel(model);
                loading.dispose();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
                JOptionPane.showMessageDialog(getRootFrame(), "Error while loading from the database");
                loading.dispose();
            }
        };
        ref.addValueEventListener(postListener);

        loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loading.setVisible(true);
    }
}
