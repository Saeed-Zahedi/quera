package ir.ac.kntu;

import java.util.ArrayList;

public class Tournoment {
    private String name;
    private ArrayList<Question>questions=new ArrayList<>();
    private ArrayList<Users>users=new ArrayList<>();
    private boolean visibilityStatus;
    private Date startingDate;
    private int time;
    private int Maxnumber;
    public Tournoment() {
    }
      public Tournoment(String name){
        this.name=name;
      }
    public Tournoment(String name, ArrayList<Question> questions, ArrayList<Users> users, int visibility, Date startingDate, int time) {
        this.name = name;
        this.questions = questions;
        this.users = users;
        if(visibility==1){
        this.visibilityStatus = true;
        AllTournoments.tournoments.add(this);
        }
        else {
            this.visibilityStatus=false;
        }
        this.startingDate = startingDate;
        this.time = time;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public boolean isVisibilityStatus() {
        return visibilityStatus;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }
    public void visibilityUpdate(){
        if(users.size()>=Maxnumber){
            this.visibilityStatus=false;
        }
    }

    @Override
    public String toString() {
        return "Tournoment{" +
                "name='" + name + '\'' +
                ", questions=" + questions +
                ", users=" + users +
                ", visibilityStatus=" + visibilityStatus +
                ", startingDate=" + startingDate +
                ", time=" + time +
                ", Maxnumber=" + Maxnumber +
                '}';
    }
}
