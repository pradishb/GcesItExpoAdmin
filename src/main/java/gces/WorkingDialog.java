package gces;

import javax.swing.*;

public class WorkingDialog extends JOptionPane {
    public WorkingDialog(){
        setMessage("Connecting to the internet...");
        setMessageType(JOptionPane.PLAIN_MESSAGE);
        setOptions(new Object[]{});
    }
}
