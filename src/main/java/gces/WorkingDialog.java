package gces;

import javax.swing.*;

public class WorkingDialog extends JOptionPane {
    public WorkingDialog(){
        setMessage("Loading");
        setMessageType(JOptionPane.PLAIN_MESSAGE);
        setOptions(new Object[]{});
    }
}
