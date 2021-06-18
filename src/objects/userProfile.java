package objects;

import java.util.ArrayList;

public class userProfile {

    private int user;
    private ArrayList<String> projects;
    private ArrayList<String> dates;
    public userProfile (int user, ArrayList<String> projects , ArrayList<String> dates){
        this.user = user;
        this.projects = projects;
        this.dates = dates;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public ArrayList<String> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<String> projects) {
        this.projects = projects;
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }
}
