package ir.ac.kntu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PrivateTournoment {
    private String name;
    private ArrayList<Users>members=new ArrayList<>();
    private ArrayList<Users>joinedmembers=new ArrayList<>();
    private ArrayList<Question>questions=new ArrayList<>();
    private int Max_Number=20;
    private ArrayList<String>History=new ArrayList<>();
    private HashMap<Question, HashMap<Users,Double>>Final=new HashMap<>();
    private boolean AbleTogetnewMember=true;
    private LocalDate date;
    private int day;
    public PrivateTournoment(String name,int day) {
        this.name = name;
        AllPrivateTournoment.privateTournoments.add(this);
        this.day=day;
        date=LocalDate.now();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public ArrayList<String> getHistory() {
        return History;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Users> getMembers() {
        return members;
    }

    public void checktogetnewMember(){
        if(joinedmembers.size()<=Max_Number){
            this.AbleTogetnewMember=false;
        }
    }
   public void getNewMember(String username){
        if(this.AbleTogetnewMember){
            joinedmembers.add(Searcher.StudentSearcherByUserName(username));
        }
   }
    public void receiveAnswer(String username){
        boolean flag=false;
        for(Users u:joinedmembers){
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
        History.add(username+" "+Q_Name+" "+answer);
        if(Searcher.QuestionExtension(Q_Name,questions)){
            double mark=0;
            if(Searcher.QuestionSearcher(Q_Name).getAnswer().equals(answer)){
                mark=Searcher.QuestionSearcher(Q_Name).getMark();
            }
            if(Final.get(Searcher.QuestionSearcher(Q_Name)).get(Searcher.StudentSearcherByUserName(username))<mark){
                Final.get(Searcher.QuestionSearcher(Q_Name)).remove(Searcher.StudentSearcherByUserName(username));
                Final.get(Searcher.QuestionSearcher(Q_Name)).put(Searcher.StudentSearcherByUserName(username),mark);
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
    public void seeTheMarkTable(String QuestionName){
        if(Searcher.QuestionExtension(QuestionName,questions)){
            System.out.println(Final.get(Searcher.QuestionSearcher(QuestionName)));
        }
        else {
            System.out.println("this tournomenet doesn't have this Question");
        }
    }
    @Override
    public String toString() {
        return "PrivateTournoment{" +
                "name='" + name + '\'' +
                '}';
    }
}
