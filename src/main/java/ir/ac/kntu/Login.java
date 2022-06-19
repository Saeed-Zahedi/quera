package ir.ac.kntu;

import java.util.Scanner;
import java.lang.*;
import java.util.concurrent.ScheduledExecutorService;

public class Login {
    public static String loginPrint1(){
        System.out.println("Enter your username");
        Scanner input=new Scanner(System.in);
        String re= input.next();
        return re;
    }
    public static String loginPrint2(){
        System.out.println("Enter your  password");
        Scanner input=new Scanner(System.in);
        String re= input.next();
        return re;
    }

    public static void Checker() {
        boolean flag = true;
        boolean flag1=true;
        String userName=loginPrint1();
        String password=loginPrint2();
        int checker=1;
        int checker2=1;
        if(Searcher.AdminResistence(userName)) {
            if (AdminChecker(userName, password)) {
               while (checker==1) {
                   PrintEnterAsAdmin();
                   DoTheActivity(choseTheActivity(), userName);
                   switch (checking()){
                       case 1:
                           break;
                       case 2:
                           checker=2;
                           break;
                   }

               }
            }
        }
        try {
            if(Searcher.StudentSearcherByUserName(userName).getPassWord().equals(password)){
                flag1=true;
            }
            else {
                flag1=false;
            }
        }
        catch (Exception e){
            flag1=false;
        }
            if (flag1) {
                System.out.println("wellCome");
                while (checker2==1) {
                    PrintEnterAsClient();
                    DoTheActivityForClient(choseTheActivity(), userName);
                    switch (checking()){
                        case 1:
                            break;
                        case 2:
                            checker2=2;
                            break;
                    }
                }
                flag=false;
            }
            else {
                if(checker!=2) {
                    System.out.println("retry");
                }
            }
        }
    public  static int checking(){
        System.out.println("do you want to continue? 1\n back to menu: 2:false");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
         return n;
    }
    public static boolean AdminChecker(String Username,String passWord){
        boolean re=false;
        for(int i=0;i<AllAdmins.admins.size();i++){
            if(Searcher.AdminSearcher(Username).getPassWord().equals(passWord)){
                re= true;
            }
        }
        if(re){
            System.out.println("Hi Admin");
        }
        return re;
    }
    public static void PrintEnterAsClient(String username){
       Searcher.StudentSearcherByUserName(username).printStudentClass();
        Searcher.StudentSearcherByUserName(username).printTeacherClass();
        Searcher.StudentSearcherByUserName(username).printTAClass();
    }
    public static void AdminINUse(){

    }
    public static void PrintEnterAsAdmin(){
        System.out.println("1-make class:");
        System.out.println("2-see the classes");
        System.out.println("3-make NormalTournament");
        System.out.println("4-add Question to tournoment");
        System.out.println("5-see Tournaments");
        System.out.println("6-make Question");
        System.out.println("7-set teacher for class");
    }
    public static void PrintEnterAsClient(){
        System.out.println("1:make class:");
        System.out.println("2:go to class:");
        System.out.println("3:join class");
        System.out.println("4:join Tournoment");
    }
    public static int choseTheActivity(){
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }
    public static void DoTheActivity(int input,String UserName){
        switch (input){
            case 1:makingClass();
                break;
            case 2:PrintClasses();
            break;
            case 3:makeNormalTournoment();
            break;
           /* case 4:AddQuestionToTournoment(UserName);
            break;
            case 5:seeTournoments(UserName);
            break;*/
            case 6:makeQuestion(UserName);
            break;
            case 7:setTeacher();
            break;
            default:
                System.out.println("not defined");
        }
    }

    public static void DoTheActivityForClient(int input,String UserName){
        switch (input){
            case 1:makingClass2(UserName);
                break;
                case 2:PrintEnterAsClient(UserName);
                String className=className();
                    PrintAsClientType(UserType(UserName,className),className,UserName);
                break;
            case 3:joinClass(UserName);
                   break;
            case 4:joinTournomet(UserName);
            break;
            default:
                System.out.println("not defined");
        }
    }
    public static void joinClass(String Username){
        System.out.println("Enter the name of the class");
        Scanner input=new Scanner(System.in);
        String className=input.next();
            if (Searcher.ClassResistenceByName(className)) {
                if (!(Searcher.classSearcherByName(className).getTA().equals(Searcher.StudentSearcherByUserName(Username)) ||
                        Searcher.classSearcherByName(className).getTeacher().equals(Searcher.StudentSearcherByUserName(Username)))) {
                    Searcher.StudentSearcherByUserName(Username).getStudent().add(Searcher.classSearcherByName(className));
                    Searcher.classSearcherByName(className).getMembers().add(Searcher.StudentSearcherByUserName(Username));
                } else {
                    System.out.println("you're teacher or ta of this class");
                }
            } else {
                System.out.println("this class doesn't exist");
            }
    }
    public static void makingClass(){
        System.out.println("Enter the name of the class:");
        Scanner input=new Scanner(System.in);
        String className=input.next();
        System.out.println("Enter the userName of the TA");
        String TaUser=input.next();
        System.out.println("Enter the Username of Teacher:");
        String TeacherUser=input.next();
        if(Searcher.StudentResistance(TaUser)||Searcher.StudentResistance(TeacherUser)){
        new Class(className,Searcher.StudentSearcherByUserName(TaUser),Searcher.StudentSearcherByUserName(TeacherUser));
        }
        else {
            System.out.println("users by this usernames doesn't exist");
        }
    }
    public static void makingClass2(String Username){
        System.out.println("Enter the name of the class:");
        Scanner input=new Scanner(System.in);
        new Class(input.next(),Searcher.StudentSearcherByUserName(Username),Username);


    }
    public static void PrintClasses() {
        System.out.println(AllClasses.Allclasses.toString());
    }


    public static void makeQuestion(String username){
        Searcher.AdminSearcher(username).makeQuestion();
    }
    public static String className(){
        System.out.println("Enter the name of class");
        Scanner input = new Scanner(System.in);
        String className = input.next();
        return className;
    }
    public static int UserType(String userName,String className) {
        if(Searcher.classResistanceByName(className,AllClasses.Allclasses)) {
            if (Searcher.classSearcherByName(className).getTA().equals(Searcher.StudentSearcherByUserName(userName))) {
                return 1;
            }
            if (Searcher.classSearcherByName(className).getTeacher().equals(Searcher.StudentSearcherByUserName(userName))) {
                return 2;
            } else {
                return 3;
            }
        }
        else {
            return 4;
        }
    }
   public static void PrintAsClientType(int input,String className,String Username){
        switch (input){
            case 1:
                System.out.println("1-add question to home work");
                Scanner number=new Scanner(System.in);
                int n=number.nextInt();
                if(n==1){
                    AddQuestionToHomeWork(className);
                }
                break;
            case 2:
                System.out.println("1-add question to home work \n 2-check the answers");
                Scanner Number=new Scanner(System.in);
                int N=Number.nextInt();
                if(N==1){
                    AddQuestionToHomeWork(className);
                }
                break;
            case 3:
                System.out.println("1- send answer");
                Scanner input2=new Scanner(System.in);
                int NUMBER=input2.nextInt();
                if(NUMBER==1) {
                    System.out.println("Enter the name of Question");
                    Scanner qName = new Scanner(System.in);
                    String QuestionName = qName.next();
                    if (Searcher.QuestionExistenceByName(QuestionName)) {
                        Searcher.QuestionSearcher(QuestionName).reciveanswer(Searcher.StudentSearcherByUserName(Username));
                    } else {
                        System.out.println("This Question doesn't exist");
                    }
                }
            case 4:
                System.out.println("This class doesn't exist");
                break;
        }
   }

   public static void AddQuestionToHomeWork(String className){
       System.out.println("Enter the question name:");
       Scanner input=new Scanner(System.in);
       String Qname=input.next();
       if(Searcher.QuestionExistenceByName(Qname)){
       Searcher.classSearcherByName(className).getHomeWorks().add(Searcher.QuestionSearcher(Qname));
       }
       else {
           System.out.println("this question doesn't Exist");
       }
   }
   public static void setTeacher(){
       System.out.println("Enter the USERNAME of the teacher:");
       Scanner input=new Scanner(System.in);
       String username=input.next();
       System.out.println("Enter the name of the class:");
       String className=input.next();
       Searcher.classSearcherByName(className).setTeacher(Searcher.StudentSearcherByUserName(username));
       Searcher.StudentSearcherByUserName(username).getTeacher().add(Searcher.classSearcherByName(className));
   }
   public static void joinTournomet(String Username){
       System.out.println("Normal tournoment:");
       for(NormalTournoment tournoment:AllNormalTournoment.normalTournoments){
           if(tournoment.isVisibilityFoEveryOne()){
               System.out.println(tournoment);
           }
       }
       System.out.println("Enter the name of Tournoment");
       Scanner input=new Scanner(System.in);
       String nameoftournoment=input.next();
       if(Searcher.NormalTornomentexistense(nameoftournoment)){
           Searcher.NormalTournomentSearcher(nameoftournoment).getNewMember(Username);
       }
       else {
           System.out.println("this tournoment doesn't exist");
       }
   }
   public static void makeNormalTournoment(){
       System.out.println("Enter the name of tournoment");
       Scanner input=new Scanner(System.in);
       new NormalTournoment(input.next());
   }
}
