package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SpecialTournoment {
    private String name;
    private int Max_Number;
    private boolean visibilityForUsers=true;
    private ArrayList<Users>requested=new ArrayList<>();
    private ArrayList<Question>questions=new ArrayList<>();
    private ArrayList<Users>joined=new ArrayList<>();
    private ArrayList<Group>groups=new ArrayList<>();
    private ArrayList<String>History=new ArrayList<>();
    private HashMap<Question, HashMap<Group,Double>>Final=new HashMap<>();
    public SpecialTournoment(String name,int Max_Number) {
        this.name = name;
        if(Max_Number>100){
            Max_Number=100;
        }
        this.Max_Number=Max_Number;
        AllSpecialTournoments.specialTournoments.add(this);
    }

    public boolean isVisibilityForUsers() {
        return visibilityForUsers;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Users> getRequested() {
        return requested;
    }
    public void checkthevisbility(){
        if(joined.size()>=Max_Number){
            this.visibilityForUsers=false;
        }
    }
    public void getNewMember(){
        checkthevisbility();
            System.out.println("Enter the Username of new member");
            Scanner input = new Scanner(System.in);
            String username = input.next();
            if (!Searcher.studentResitance(username, joined)) {
                System.out.println("Enter the name of your group:");
                Scanner in = new Scanner(System.in);
                String G_Name = in.next();
                boolean flag = false;
                for (Group g : groups) {
                    if (g.getName().equals(G_Name)) {
                        flag = true;
                        g.getMembers().add(Searcher.StudentSearcherByUserName(username));
                        joined.add(Searcher.StudentSearcherByUserName(username));
                    }
                }
                if (!flag) {
                    groups.add(new Group(G_Name));
                    joined.add(Searcher.StudentSearcherByUserName(username));
                }
            }
            System.out.println("you hava already joined to this tournoment");
        }
    public void receiveAnswer(String username){
        boolean flag=false;
        for(Users u:joined){
            if(u.getUsername().equals(username)){
                flag=true;
            }
        }
        if(flag){
            System.out.println("Enter the name of the question:");
            Scanner input=new Scanner(System.in);
            String Q_Name=input.next();
            System.out.println("Enter the answer");
            String answer=input.next();
            History.add(Searcher.WhatIsMyGroup(username,groups)+" "+Q_Name+" "+answer);
            if(Searcher.QuestionExtension(Q_Name,questions)){
                double mark=0;
                if(Searcher.QuestionSearcher(Q_Name).getAnswer().equals(answer)){
                    mark=Searcher.QuestionSearcher(Q_Name).getMark();
                }
                if(Final.get(Searcher.QuestionSearcher(Q_Name)).get(Searcher.WhatIsMyGroup(username,groups))<mark){
                    Final.get(Searcher.QuestionSearcher(Q_Name)).remove(Searcher.WhatIsMyGroup(username,groups));
                    Final.get(Searcher.QuestionSearcher(Q_Name)).put(Searcher.WhatIsMyGroup(username,groups),mark);
                    System.out.println("Answer received");
                }
            }
            else {
                System.out.println("this tournomenet doesn't have this Question");
            }
        }
        else {
            System.out.println("you cant send answer for this tournoment");
        }
    }
}
