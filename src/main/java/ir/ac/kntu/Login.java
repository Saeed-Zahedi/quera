package ir.ac.kntu;

import javax.sound.midi.Soundbank;
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
        System.out.println("3-make Tournament");
        System.out.println("4-add Question to tournoment");
        System.out.println("5-see Tournaments");
        System.out.println("6-make Question");
        System.out.println("7-set teacher for class");
        System.out.println("8-join new member to the Private Tournoment");
        System.out.println("9-see the mark table");
        System.out.println("10-send request for someone to be in Special Tournoment");
    }
    public static void PrintEnterAsClient(){
        System.out.println("1:make class:");
        System.out.println("2:go to class:");
        System.out.println("3:join class");
        System.out.println("4:join Tournoment");
        System.out.println("5:send Answer for Tournoment");
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
            case 3:makeTournoment();
            break;
            case 4:AddQuestiontoTournoment();
            break;
            case 5:seeTournoments();
            break;
            case 6:makeQuestion(UserName);
            break;
            case 7:setTeacher();
            break;
            case 8:joinforPTournoment();
            break;
            case 9:seeTheMarkTable();
            break;
            case 10:sendRequestForSpecialTournoment();
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
            case 5:SendAnswerForTournoment(UserName);
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
       System.out.println("Private tournomet");
       for(PrivateTournoment t:AllPrivateTournoment.privateTournoments){
           for(Users u:t.getMembers()){
               if(u.getUsername().equals(Username)){
                   System.out.println(t);
               }
           }
       }
       System.out.println("Special Tournoments");
       for(SpecialTournoment t:AllSpecialTournoments.specialTournoments){
           for (Users u:t.getRequested()){
               if(u.getUsername().equals(Username)){
                   if(t.isVisibilityForUsers()) {
                       System.out.println(t);
                   }
               }
           }
       }
       System.out.println("Enter the name of Tournoment");
       Scanner input=new Scanner(System.in);
       String nameoftournoment=input.next();
       if(Searcher.NormalTornomentexistense(nameoftournoment)){
           Searcher.NormalTournomentSearcher(nameoftournoment).getNewMember(Username);
       }
       else if(Searcher.PrivateTournomentExistance(nameoftournoment)){
           Searcher.privateTournoment(nameoftournoment).getNewMember(Username);
       }
       else if(Searcher.SpecialTournomentResistance(nameoftournoment)){
           Searcher.SpecialTournomentSearcher(nameoftournoment).getNewMember();
       }
       else {
           System.out.println("this tournoment doesn't exist");
       }
   }
   public static void makeTournoment(){
       System.out.println("enter the type of tournoment\n1-normall\n2-private\n3-Special:");
       Scanner input=new Scanner(System.in);
       int type= input.nextInt();
       System.out.println("Enter the name of tournoment");
       String name=input.next();
       switch (type){
           case 1:new NormalTournoment(name);
           break;
           case 2:new PrivateTournoment(name);
           break;
           case 3:
               System.out.println("Enter the max number of users");
               Scanner i=new Scanner(System.in);
               int max= input.nextInt();
               new SpecialTournoment(name,max);
               break;
       }
   }
   public static void SendAnswerForTournoment(String Username){
       System.out.println("Enter the name of Tournoment");
       Scanner input=new Scanner(System.in);
       String nameoftournoment=input.next();
       if(Searcher.NormalTornomentexistense(nameoftournoment)){
       Searcher.NormalTournomentSearcher(nameoftournoment).receiveAnswer(Username);
       }
       if(Searcher.PrivateTournomentExistance(nameoftournoment)){
           Searcher.privateTournoment(nameoftournoment).receiveAnswer(Username);
       }
       if(Searcher.SpecialTournomentResistance(nameoftournoment)){
           Searcher.SpecialTournomentSearcher(nameoftournoment).receiveAnswer(Username);
       }
       else {
           System.out.println("this tournoment doesn't exist");
       }
   }
   public static void AddQuestiontoTournoment(){
       System.out.println("Enter the name of tournoment");
       Scanner input=new Scanner(System.in);
       String TournomentName=input.next();
       System.out.println("Enter the name of Question:");
       String QuestionName=input.next();
       if(Searcher.NormalTornomentexistense(TournomentName)){
           if(Searcher.QuestionExtension(QuestionName,QuestionBank.questions)){
           Searcher.NormalTournomentSearcher(TournomentName).getQuestions().add(Searcher.QuestionSearcher(QuestionName));
           }
           else {
               System.out.println("this Qestion desn't exist");
           }
       }
       if(Searcher.SpecialTournomentResistance(TournomentName)){
           if(Searcher.QuestionExtension(QuestionName,QuestionBank.questions)){
               Searcher.SpecialTournomentSearcher(TournomentName).getQuestions().add(Searcher.QuestionSearcher(QuestionName));
           }
           else {
               System.out.println("this Qestion desn't exist");
           }
       }
       if(Searcher.PrivateTournomentExistance(TournomentName)){
           if(Searcher.QuestionExtension(QuestionName,QuestionBank.questions)){
               Searcher.privateTournoment(TournomentName).getQuestions().add(Searcher.QuestionSearcher(QuestionName));
           }
           else {
               System.out.println("this Qestion desn't exist");
           }
       }
       else {
           System.out.println("this tournoment doesn't exist");
       }
   }
   public static void joinforPTournoment(){
       System.out.println("Enter the name of tournoment");
       Scanner input=new Scanner(System.in);
       String Tname=input.next();
       System.out.println("Enter the username of the new member");
       String username=input.next();
       if(Searcher.PrivateTournomentExistance(Tname)){
           if(!Searcher.studentResitance(username,Searcher.privateTournoment(Tname).getMembers())){
               Searcher.privateTournoment(Tname).getMembers().add(Searcher.StudentSearcherByUserName(username));
               System.out.println("member joined");
           }
           else {
               System.out.println("this person is a member;");
           }
       }
       else {
           System.out.println("this tournoment doesn't exist");
       }
   }
   public static void seeTheMarkTable(){
       System.out.println("Enter the name of Tournoment");
       Scanner input=new Scanner(System.in);
       String TournomentName=input.next();
       System.out.println("Enter the name of the question");
       String Q_name=input.next();
       if(Searcher.PrivateTournomentExistance(TournomentName)){
           Searcher.privateTournoment(TournomentName).seeTheMarkTable(Q_name);
       }
       if(Searcher.NormalTornomentexistense(TournomentName)){
           Searcher.NormalTournomentSearcher(TournomentName).seeTheMarkTable(Q_name);
       }
   }
   public static void sendRequestForSpecialTournoment(){
       System.out.println("Enter the Username of the User");
       Scanner input=new Scanner(System.in);
       String username=input.next();
       if(Searcher.StudentResistance(username)){
           System.out.println("enter the name of tournoment");
           String T_Name=input.next();
           if(Searcher.SpecialTournomentResistance(T_Name)){
               Searcher.SpecialTournomentSearcher(T_Name).getRequested().add(Searcher.StudentSearcherByUserName(username));
           }
           else{
               System.out.println("This tournoment doesn't exist");
           }
       }
       else {
           System.out.println("This user doesn't exist");
       }
   }
   public static void seeTournoments(){
       System.out.println("Normall tournoments");
       for(NormalTournoment t:AllNormalTournoment.normalTournoments){
           System.out.println(t.toString());
       }
       System.out.println("private tournoment");
       for(PrivateTournoment t:AllPrivateTournoment.privateTournoments){
           System.out.println(t.toString());
       }
       System.out.println("SpecialTournoments");
       for(SpecialTournoment t:AllSpecialTournoments.specialTournoments){
           System.out.println(t.toString());
       }
   }
}
