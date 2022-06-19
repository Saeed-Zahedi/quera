package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NormalTournoment {
    private boolean visibilityFoEveryOne=true;
    private String name;
    private int MAX_Number=50;
    private ArrayList<Question>questions=new ArrayList<>();
    private ArrayList<Users>users=new ArrayList<>();
    private ArrayList<String>History=new ArrayList<>();
    private HashMap<Question,HashMap<Users,Double>>Final=new HashMap<>();

    public NormalTournoment(String name) {
        this.name = name;
        AllNormalTournoment.normalTournoments.add(this);
    }
    public void getNewMember(String username){
        users.add(Searcher.StudentSearcherByUserName(username));
        checkTheVisibility();
    }
    public void checkTheVisibility(){
        if(users.size()>=MAX_Number){
            this.visibilityFoEveryOne=false;
        }
    }
    public void receiveAnswer(String username){
        System.out.println("Enter the name of the question:");
        Scanner input=new Scanner(System.in);
        String Q_Name=input.next();
        System.out.println("Enter the answer");
        String answer=input.next();
        History.add(username+" "+Q_Name+" "+answer);
        if(Searcher.QuestionExtension(Q_Name,questions)){
            double mark=0;
            if(Searcher.QuestionSearcher(Q_Name).getAnswer().equals(answer)){
                mark=Searcher.QuestionSearcher(Q_Name).getMark();
            }
           if(Final.get(Searcher.QuestionSearcher(Q_Name)).get(Searcher.StudentSearcherByUserName(username))<mark){
               Final.get(Searcher.QuestionSearcher(Q_Name)).put(Searcher.StudentSearcherByUserName(username),mark);
           }
        }
        else {
            System.out.println("this tournomenet doesn't have this Question");
        }
    }
    public void seeTheMarkTable(String QuestionName){
        if(Searcher.QuestionExtension(QuestionName,questions)){
            System.out.println(Final.get(Searcher.QuestionSearcher(QuestionName)));
        }
        else {
            System.out.println("this tournomenet doesn't have this Question");
        }
    }
}
