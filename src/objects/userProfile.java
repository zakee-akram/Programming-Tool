package objects;

import java.util.ArrayList;

public class userProfile {
    private user currentUser;
    private ArrayList<String> projects;
    private ArrayList<String> dates;

    public userProfile(user currentUser, ArrayList<String> projects, ArrayList<String> dates) {
        this.currentUser = currentUser;
        this.projects = projects;
        this.dates = dates;
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

    public user getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(user currentUser) {
        this.currentUser = currentUser;
    }
}
