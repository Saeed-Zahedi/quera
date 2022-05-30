package ir.ac.kntu;
import java.util.ArrayList;
import java.util.HashMap;
public class Question {
    private String name;
    private double mark;
    private String theQuestion;
    private QuestionType questionType;
    private String answer;
    private boolean visibleStatus;
    private boolean visibleStatusForTable;
    private ArrayList<Users>HomeWorkSender=new ArrayList<>();
    private ArrayList<String>HomeWorkHistory=new ArrayList<>();
    private HashMap<String,Double>Ranking=new HashMap<>();
    private HashMap<String,Double>finalRanking=new HashMap<>();
    private Date date;
    public Question(String name, double mark, String theQuestion, QuestionType questionType,String answer,Date date,boolean visiableStatuse,boolean visiableStatuseForTable) {
        this.name = name;
        this.mark = mark;
        this.theQuestion = theQuestion;
        this.questionType = questionType;
        this.answer=answer;
        this.date=date;
        this.visibleStatus=visiableStatuse;
        this.visibleStatusForTable=visiableStatuseForTable;
    }

    public Question() {
    }

    public boolean isVisibleStatusForTable() {
        return visibleStatusForTable;
    }

    public Date getDate() {
        return date;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public HashMap<String, Double> getRanking() {
        return Ranking;
    }

    public boolean isVisibleStatus() {
        return visibleStatus;
    }

    public String getName() {
        return name;
    }

    public void reciveanswer(Users c,String information,String answer){
        HomeWorkHistory.add(information+"answer:"+answer);
        HomeWorkSender.add(c);
        double mark=0;
        if(this.answer.equals(answer)){
            mark=this.mark;
        }
        if(Ranking.containsKey(c.getUsername())){
            if(Ranking.get(c.getUsername())<mark){
                Ranking.remove(c.getUsername());
                Ranking.put(c.getUsername(),mark);
            }
        }
        else {
            Ranking.put(c.getUsername(),mark);
        }
    }
    public void marksTable(){
        if(this.Ranking.size()==0){
            System.out.println("no answer has been sent for this question");
        }
        else {
            HashMap<String,Double>sorted=new HashMap<>();
        String[]usernames=this.Ranking.keySet().toArray(new String[0]);
        for(int i=0;i<usernames.length;i++){
            for(int j=i+1;j<usernames.length;j++){
                if(this.Ranking.get(usernames[i])<=this.Ranking.get(usernames[j])){
                    String s=usernames[i];
                    usernames[i]=usernames[j];
                    usernames[j]=s;
                }
            }
        }
        for(int i=0;i<usernames.length;i++){
            sorted.put(usernames[i],Ranking.get(usernames[i]));
        }
        for(int i=0;i<sorted.size();i++){
            System.out.println(usernames[i]+" "+sorted.get(usernames[i]));
        }
         }
    }
    public void seeHomeWorkHistory(){
        for(int i=0;i<HomeWorkHistory.size();i++){
            System.out.println(HomeWorkHistory.get(i));
        }
    }
    public String toString(){
        return "name:"+name+"mark:"+mark+"the question:"+theQuestion;
    }
}
