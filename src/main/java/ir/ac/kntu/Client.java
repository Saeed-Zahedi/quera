package ir.ac.kntu;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private String name;
    private String username;
    private String ID;
    private String Email;
    private String passWord;
    private String phoneNumber;
    private ArrayList<String> HistoryOfHomeWorkSending=new ArrayList<>();
    private ArrayList<Class>joined=new ArrayList<>();
    private ArrayList<Class>owning=new ArrayList<>();
    public Client(String name, String username, String email, String passWord, String phoneNumber,String ID) {
        this.name = name;
        this.username = username;
        Email = email;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.ID=ID;
         AllClients.allClient.add(this);
    }

    public Client() {
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return username;
    }

    public void ClassMaker(String name,String instiutename,String teacherName,int year,boolean status,boolean Status2,String password,String expelenation ) {
        joined.add(new Class(name,instiutename,teacherName,year,status,Status2,password,expelenation,this));
        owning.add(new Class(name,instiutename,teacherName,year,status,Status2,password,expelenation,this));
        AllClasses.Allclasses.add(new Class(name,instiutename,teacherName,year,status,Status2,password,expelenation,this));
    }
     public void addStudent(String studentEmail,String className){
        if(this.owning.size()==0){
            System.out.println("you dont own any class");
        }
        else {
            if(Searcher.classSearcherByName(className).getOwner().equals(this)){
        Searcher.StudentSearcherByEmail(studentEmail).joined.add(Searcher.classSearcherByName(className));
            }
            else {
                System.out.println("You dont have access to do it!");
            }
        }
     }
     public void addQuestionToHomeWork(String Classname, String QuestionName){
         if(this.owning.size()==0){
             System.out.println("you dont own any class");
         }
         else {
             if(Searcher.classSearcherByName(Classname).getOwner().equals(this)){
                 if(Searcher.QuestionExistenceByName(QuestionName)){
                 Searcher.classSearcherByName(Classname).getHomeWorks().add(Searcher.QuestionSearcher(QuestionName));
                 }
                 else {
                     System.out.println("this Question doesn't exisit");
                 }
             }
             else {
                 System.out.println("you dont have access to this field");
             }
         }
     }
     public void joinNewClass(String name){
        if(Searcher.classSearcherByName(name).isClassStatusForRegestion()){
            if(Searcher.classSearcherByName(name).isPrivateStatus()){
                System.out.println("Enter password:");
                Scanner input=new Scanner(System.in);
                String s=input.nextLine();
                if(s.equals(Searcher.classSearcherByName(name).getPassword())){
                    joined.add(Searcher.classSearcherByName(name));
                    System.out.println("you joined this class");
                }
                else {
                    System.out.println("incorrect password");
                }
            }
            else {
                joined.add(Searcher.classSearcherByName(name));
            }
        }
        else {
            System.out.println("youre not allowed to join this class");
        }
     }
    public void sendHomework(String className,String QuestionName){
        if(joined.size()==0){
            System.out.println("you arent joined in any class");
        }
        else {
            if(Searcher.classResistanceByName(className,joined)){
                if(Searcher.QuestionExtension(QuestionName,Searcher.classSearcherByName(className).getHomeWorks())){
                System.out.println("Enter your answer");
                Scanner input=new Scanner(System.in);
                String answer=input.next();
                 Searcher.QuestionSearcher(QuestionName).reciveanswer(this,("name:"+name+"username:"+username+"Question name:"+QuestionName),answer);
                }
                else {
                    System.out.println("you dont have this Question for your HomeWork");
                }
            }
            else {
                System.out.println("You're not a member of this class");
            }
        }
    }
    public void removeClass(String className){
        if(this.equals(Searcher.classSearcherByName(className).getOwner())){
            int index1=0,index2=0;
            for(int i=0;i<AllClients.allClient.size();i++){
                for(int j=0;j<AllClients.allClient.get(i).joined.size();j++){
               if(className.equals(AllClients.allClient.get(i).joined.get(j).getName())){
                   AllClients.allClient.get(i).joined.remove(j);
                   index1=i;
                   index2=j;
                   System.out.println("class:"+className+" removed");
                }
               }
            }
                AllClasses.Allclasses.remove(Searcher.classSearcherByName(className));

        }
        else {
            System.out.println("you arent the owner of class");
        }
    }
    public void makeNewQuestionForHomeWork(String ClassName,String name, double mark, String theQuestion, QuestionType questionType,String answer,Date date,boolean visibility,boolean visibilityForTable){
        if(this.equals(Searcher.classSearcherByName(ClassName).getOwner())){
        QuestionBank.questions.add(new Question( name, mark,theQuestion,questionType,answer,date,visibility,visibilityForTable));
        Searcher.classSearcherByName(ClassName).getHomeWorks().add(Searcher.QuestionSearcher(name));
        }
        else {
            System.out.println("you cant add Question because its not your class");
        }
    }
    public void setanswer(String className,String questionName,String answer){
        if(this.equals(Searcher.classSearcherByName(className).getOwner())){
            Searcher.QuestionSearcher(questionName).setAnswer(answer);
        }
        else {
            System.out.println("you cant change answer of Question because its not your class");
        }
    }
    public void seeQuestion(String className,String QuestionName){
        if(joined.size()==0){
            System.out.println("you arent joined in any class");
        }
        else {
            if (Searcher.classResistanceByName(className, joined)) {
                for (int i = 0; i < Searcher.classSearcherByName(className).getHomeWorks().size(); i++) {
                    if (Searcher.classSearcherByName(className).getHomeWorks().get(i).equals(Searcher.QuestionSearcher(QuestionName))) {
                        if (Searcher.classSearcherByName(className).getHomeWorks().get(i).isVisibleStatus()) {
                            System.out.println(Searcher.classSearcherByName(className).getHomeWorks().get(i).toString());
                        }
                        else {
                            if (Searcher.classSearcherByName(className).getOwner().equals(this)) {
                                System.out.println(Searcher.QuestionSearcher(QuestionName).toString());
                            } else {
                                System.out.println("this question is not visiable now");
                            }
                        }
                    }
                }
            } else {
                System.out.println("you aren't  member of this clas");
            }
        }
    }
    public void seeTableOfMarks(String className,String QuestionName){
        if(joined.size()==0){
            System.out.println("you aren't joined in any class");
        }
        else {
            if(Searcher.classResistanceByName(className,joined)){
                for(int i=0;i<Searcher.classSearcherByName(className).getHomeWorks().size();i++){
                    if(Searcher.classSearcherByName(className).getHomeWorks().get(i).equals(Searcher.QuestionSearcher(QuestionName))){
                       if(Searcher.classSearcherByName(className).getHomeWorks().get(i).isVisibleStatusForTable()){
                           Searcher.classSearcherByName(className).getHomeWorks().get(i).marksTable();
                       }
                       else {
                           if(this.equals(Searcher.classSearcherByName(className).getOwner())){
                               Searcher.classSearcherByName(className).getHomeWorks().get(i).marksTable();
                           }
                           else {
                             System.out.println("this table is not visable");
                           }
                       }
                    }
                }
            }
            else {
                System.out.println("youre,t joined in any class");
            }
        }
    }
    public void changeTheNameOfClass(String classsName){
        if(this.equals(Searcher.classSearcherByName(classsName).getOwner())){
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
        else {
            System.out.println("you are not the owner of this class");
        }
    }
    public void QuestionRemover(String className,String QuestionName){
        if(Searcher.classSearcherByName(className).getOwner().equals(this)){
            for(int i=0;i< Searcher.classSearcherByName(className).getHomeWorks().size();i++){
            if(Searcher.classSearcherByName(className).getHomeWorks().get(i).equals(Searcher.QuestionSearcher(QuestionName))){
                Searcher.classSearcherByName(className).getHomeWorks().remove(i);
             }
            }
        }
        else {
            System.out.println("you cant remove Question");
        }
    }

}
