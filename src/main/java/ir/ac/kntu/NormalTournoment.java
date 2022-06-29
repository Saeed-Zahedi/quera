package ir.ac.kntu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static javax.swing.UIManager.put;

public class NormalTournoment {
    private boolean visibilityFoEveryOne=true;

    private String name;

    private int MAX_Number=50;

    private ArrayList<Question>questions=new ArrayList<>();

    private ArrayList<Users>users=new ArrayList<>();

    private ArrayList<String>History=new ArrayList<>();

    private HashMap<Question,HashMap<Users,Double>>Final=new HashMap<>();

    private HashMap<Users,Double>FinalValue=new HashMap<>();

    private LocalDate date;

    private int day;

    public NormalTournoment(String name,int day) {
        this.name = name;
        AllNormalTournoment.normalTournoments.add(this);
        date=LocalDate.now();
        this.day=day;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDay() {
        return day;
    }

    public ArrayList<String> getHistory() {
        return History;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public boolean isVisibilityFoEveryOne() {
        return visibilityFoEveryOne;
    }

    public void getNewMember(String username){
        users.add(Searcher.StudentSearcherByUserName(username));
        checkTheVisibility();
    }

    public void checkTheVisibility(){
        if(users.size()>=MAX_Number){
            this.visibilityFoEveryOne=false;
        }
        LocalDate d;
        d=LocalDate.now();
        if(d.isAfter(date.plusDays(day))){
            this.visibilityFoEveryOne=false;
        }
    }

    public void receiveAnswer(String username){
        LocalDate d;
        d=LocalDate.now();
        if(d.isBefore(date.plusDays(day))) {
            System.out.println("Enter the name of the question:");
            Scanner input = new Scanner(System.in);
            String Q_Name = input.next();
            System.out.println("Enter the answer");
            String answer = input.next();
            History.add(username + " " + Q_Name + " " + answer);
            if (Searcher.QuestionExtension(Q_Name, questions)) {
                double mark = 0;
                if (Searcher.QuestionSearcher(Q_Name).getAnswer().equals(answer)) {
                    mark = Searcher.QuestionSearcher(Q_Name).getMark();

                }
                FinalValue.put(Searcher.StudentSearcherByUserName(username), mark);
                Final.put((Searcher.QuestionSearcher(Q_Name)), FinalValue);

            } else {
                System.out.println("this tournomenet doesn't have this Question");
            }
        } else {
            System.out.println("time for send answer is up");
        }
    }

    public void seeTheMarkTable(String QuestionName){
        if(Searcher.QuestionExtension(QuestionName,questions)){
            System.out.println(Final.get(Searcher.QuestionSearcher(QuestionName)));
        } else {
            System.out.println("this tournomenet doesn't have this Question");
        }
    }

    @Override
    public String toString() {
        return "NormalTournoment{" +
                "name='" + name + '\'' +
                '}';
    }
}
