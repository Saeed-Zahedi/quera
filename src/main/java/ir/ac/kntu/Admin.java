package ir.ac.kntu;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Admin {
    private String name;
    private String UserName;
    private String PassWord;

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }

    public Admin(String name, String userName, String passWord) {
        this.name = name;
        UserName = userName;
        PassWord = passWord;
        AllAdmins.admins.add(this);
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void ClassMaker(String name, String instiutename, String teacherName, int year, boolean status, boolean Status2, String password, String expelenation, Users TA) {
        AllClasses.Allclasses.add(new Class(name,instiutename,teacherName,year,status,Status2,password,expelenation,TA));
    }
    public void addStudent(String studentEmail,String className){
                Searcher.StudentSearcherByEmail(studentEmail).getStudent().add(Searcher.classSearcherByName(className));
    }
    public void addQuestionToHomeWork(String Classname, String QuestionName){
                if(Searcher.QuestionExistenceByName(QuestionName)){
                    Searcher.classSearcherByName(Classname).getHomeWorks().add(Searcher.QuestionSearcher(QuestionName));
                }
                else {
                    System.out.println("this Question doesn't exisit");
                }
        }

    public void removeClass(String className){
    for(int i=0;i<AllUsers.allUsers.size();i++){
        for(int j=0;j<AllUsers.allUsers.get(i).getStudent().size();i++){
            if(AllUsers.allUsers.get(i).getStudent().get(j).equals(Searcher.classSearcherByName(className))){
                AllUsers.allUsers.get(i).getStudent().remove(j);
            }
        }
    }
        for(int i=0;i<AllUsers.allUsers.size();i++){
            for(int j=0;j<AllUsers.allUsers.get(i).getTeacher().size();i++){
                if(AllUsers.allUsers.get(i).getTeacher().get(j).equals(Searcher.classSearcherByName(className))){
                    AllUsers.allUsers.get(i).getTeacher().remove(j);
                }
            }
        }
        for(int i=0;i<AllUsers.allUsers.size();i++){
            for(int j=0;j<AllUsers.allUsers.get(i).getTA().size();i++){
                if(AllUsers.allUsers.get(i).getTA().get(j).equals(Searcher.classSearcherByName(className))){
                    AllUsers.allUsers.get(i).getTA().remove(j);
                }
            }
        }
            AllClasses.Allclasses.remove(Searcher.classSearcherByName(className));
    }
    public void makeNewQuestionForHomeWork(String ClassName,String name, double mark, String theQuestion, QuestionType questionType,String answer,Date date,boolean visibility,boolean visibilityForTable){
            QuestionBank.questions.add(new Question( name, mark,theQuestion,questionType,answer,date,visibility,visibilityForTable));
            Searcher.classSearcherByName(ClassName).getHomeWorks().add(Searcher.QuestionSearcher(name));
        }
    public void setanswer(String className,String questionName,String answer){
            Searcher.QuestionSearcher(questionName).setAnswer(answer);
        }

    public void seeQuestion(String QuestionName){
        System.out.println(Searcher.QuestionSearcher(QuestionName).toString());
        }
    public void seeTableOfMarks(String className,String QuestionName){
        for(int i=0;i<Searcher.classSearcherByName(className).getHomeWorks().size();i++){
            if(Searcher.classSearcherByName(className).getHomeWorks().get(i).equals(Searcher.QuestionSearcher(QuestionName))){
                    Searcher.classSearcherByName(className).getHomeWorks().get(i).marksTable();
                }
            }

    }

    public void changeTheNameOfClass(String classsName){
            if(Searcher.classResistanceByName(classsName,AllClasses.Allclasses)){
                System.out.println("Enter the new Name");
                Scanner input=new Scanner(System.in);
                String Name=input.next();
                Searcher.classSearcherByName(classsName).setName(Name);
            }
            else {
                System.out.println("this class doesn't exist");
            }
        }

    public void QuestionRemover(String QuestionName){
           for(int i=0;i<QuestionBank.questions.size();i++){
               if(QuestionBank.questions.get(i).getName().equals(QuestionName)){
                   QuestionBank.questions.remove(i);
               }
           }

    }
    public void QuestionRemover(String className,String QuestionName){
            for(int i=0;i< Searcher.classSearcherByName(className).getHomeWorks().size();i++){
                if(Searcher.classSearcherByName(className).getHomeWorks().get(i).equals(Searcher.QuestionSearcher(QuestionName))){
                    Searcher.classSearcherByName(className).getHomeWorks().remove(i);
                }
            }
    }
    public void seeAllQuestions(){
        for(int i=0;i<QuestionBank.questions.size();i++){
                QuestionBank.questions.get(i).toString();
            }
        }
        public void makingTournoment(){
            System.out.println("enter the name of Tournoment");
            Scanner input=new Scanner(System.in);
            String name=input.next();
            System.out.println("enter the type of Tournoment\n1-Normal\n2-private\n3-special");
            int n=input.nextInt();
            switch (n){
                case 1:new NormalTournoment(name);
                break;
                case 2:new PrivateTournoment(name);
                break;
                case 3:new SpecialTournoment(name);
                break;
                default:
                    System.out.println("sorry the wrong number:)");
            }
        }
        public void addQuestionToTournoment(){
            System.out.println("Enter the Tournoment name:");
            Scanner input=new Scanner(System.in);
            String TournomentName=input.next();
            System.out.println("enter the Question name:");
            String QuestionName=input.next();
        if(Searcher.tornomentexistense(TournomentName)&&Searcher.QuestionExistenceByName(QuestionName)){
          Searcher.tournomentSearcher(TournomentName).getQuestions().add(Searcher.QuestionSearcher(QuestionName));
          }
        else {
            System.out.println(" question name or Tournoment name is wrong");
           }
        }
        public void seeTheTournoments(){
        for(Tournoment t:AllTournoments.tournoments){
            System.out.println(t.toString());
         }
        }
        public void makeQuestion(){
            System.out.println("Enter the name of Question:");
            Scanner input=new Scanner(System.in);
            String name=input.next();
            System.out.println("enter the mark:");
            double mark=input.nextDouble();
            new Question(name,mark);
        }
}


