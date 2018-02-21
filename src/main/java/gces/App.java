package gces;

public class App {

    public static void main(String[] args){
        FirebaseEngine.initialize();
        new AdminFrame().createDialog("Admin Panel").setVisible(true);
    }
}
