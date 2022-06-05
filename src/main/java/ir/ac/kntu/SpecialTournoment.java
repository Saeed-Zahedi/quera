package ir.ac.kntu;

import java.util.ArrayList;

public class SpecialTournoment extends Tournoment{

    private ArrayList<Group>groups=new ArrayList<>();

    public SpecialTournoment(String name, ArrayList<Question> questions, ArrayList<Users> users, int visibility, Date startingDate, int time, ArrayList<Group> groups) {
        super(name, questions, users, visibility, startingDate, time);
        this.groups = groups;
        AllTournoments.tournoments.add(this);
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }
}
