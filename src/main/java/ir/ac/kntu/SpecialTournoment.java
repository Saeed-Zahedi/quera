package ir.ac.kntu;

import java.util.ArrayList;

public class SpecialTournoment extends Tournoment{
    private int Maxnumber=100;
    private ArrayList<Group>groups=new ArrayList<>();

    public SpecialTournoment(String name, ArrayList<Question> questions, ArrayList<Users> users, int visibility, Date startingDate, int time, int maxnumber, ArrayList<Group> groups) {
        super(name, questions, users, visibility, startingDate, time);
        Maxnumber = maxnumber;
        this.groups = groups;
        AllTournoments.tournoments.add(this);
    }

}
