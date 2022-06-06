package ir.ac.kntu;

import java.util.ArrayList;

public class PrivateTournoment extends Tournoment{
    private ArrayList<Users>choosenUsers=new ArrayList<>();

    public PrivateTournoment(String name, ArrayList<Question> questions, ArrayList<Users> users, int visibility, Date startingDate, int time) {
        super(name, questions, users, visibility, startingDate, time);
        AllprivateTournoments.privateTournoments.add(this);
    }

    public ArrayList<Users> getChoosenUsers() {
        return choosenUsers;
    }
}
