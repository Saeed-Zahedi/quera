package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecialTournoment {
    private String name;
    private int Max_Number;
    private boolean visibilityForUsers=true;
    private ArrayList<Users>requested=new ArrayList<>();
    private ArrayList<Users>joined=new ArrayList<>();
    private ArrayList<Group>groups=new ArrayList<>();

    public SpecialTournoment(String name,int Max_Number) {
        this.name = name;
        if(Max_Number>100){
            Max_Number=100;
        }
        this.Max_Number=Max_Number;
        AllSpecialTournoments.specialTournoments.add(this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Users> getRequested() {
        return requested;
    }

    public void getNewMember(){
        System.out.println("Enter the Username of new member");
        Scanner input=new Scanner(System.in);
        String username=input.next();
        if(!Searcher.studentResitance(username,joined)){
            System.out.println("Enter the name of your group:");
            Scanner in=new Scanner(System.in);
            String G_Name=in.next();
            boolean flag=false;
            for (Group g:groups){
                if(g.getName().equals(G_Name)){
                    flag=true;
                    g.getMembers().add(Searcher.StudentSearcherByUserName(username));
                    joined.add(Searcher.StudentSearcherByUserName(username));
                }
            }
            if(!flag){
               groups.add(new Group(G_Name));
                joined.add(Searcher.StudentSearcherByUserName(username));
            }
        }
        System.out.println("you hava already joined to this tournoment");
    }
}
