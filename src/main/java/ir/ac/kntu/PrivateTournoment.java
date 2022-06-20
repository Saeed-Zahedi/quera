package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class PrivateTournoment {
    private String name;
    private ArrayList<Users>members=new ArrayList<>();
    private ArrayList<Question>questions=new ArrayList<>();
    private int Max_Number=20;
    private ArrayList<String>History=new ArrayList<>();
    private HashMap<Question, HashMap<Users,Double>>Final=new HashMap<>();
    private boolean AbleTogetnewMember=true;
    public PrivateTournoment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Users> getMembers() {
        return members;
    }

    public void checktogetnewMember(){
        if(members.size()<=Max_Number){
            this.AbleTogetnewMember=false;
        }
    }

}
