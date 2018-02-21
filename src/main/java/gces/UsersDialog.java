package gces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

class UsersDialog extends JOptionPane {
    private JTable table;
    private JScrollPane tableSp;
    UsersDialog(){

        TableModel model = new DefaultTableModel(new String[][]{{"sdf","sdf"}}, new String[]{"Name", "sdf"});
        table = new JTable(model);
        tableSp = new JScrollPane(table);

        JTextField x = new JTextField("sdsf");
        setMessage(new Object[]{tableSp, x});
    }
}
