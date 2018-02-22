package gces;

public class Project{
    private String title;

    public Project() {
        title = "Not defined";
    }
    public Project(String t){
        title = t;
    }

    public void setTitle(String t){
        title = t;
    }

    public String getTitle() {
        return title;
    }
}