package ir.ac.kntu;

import java.util.Scanner;

public class Admin {
    private String name;
    private String UserName;
    private String PassWord;

    public Admin(String name, String userName, String passWord) {
        this.name = name;
        UserName = userName;
        PassWord = passWord;
    }

    public void ClassMaker(String name,String instiutename,String teacherName,int year,boolean status,boolean Status2,String password,String expelenation,Client TA) {
        AllClasses.Allclasses.add(new Class(name,instiutename,teacherName,year,status,Status2,password,expelenation,TA));
    }
    public void addStudent(String studentEmail,String className){
                Searcher.StudentSearcherByEmail(studentEmail).joined.add(Searcher.classSearcherByName(className));
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
    }


