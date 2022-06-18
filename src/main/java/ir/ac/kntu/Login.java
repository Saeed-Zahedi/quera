package ir.ac.kntu;

import java.util.Scanner;

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
        if(Searcher.AdminResistence(userName)) {
            if (AdminChecker(userName, password)) {
               int checker=1;
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
                PrintEnterAsClient(userName);
                flag=false;
            }
            else {
                System.out.println("retry");
            }
        }
    public  static int checking(){
        System.out.println("do you want to continue as Admin?\n 1:true 2:false");
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
    public static void PrintEnterAsClient(String s){
       Searcher.StudentSearcherByUserName(s).printStudentClass();
        Searcher.StudentSearcherByUserName(s).printTeacherClass();
        Searcher.StudentSearcherByUserName(s).printTAClass();
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
            case 3:makingTournoment(UserName);
            break;
            case 4:AddQuestionToTournoment(UserName);
            break;
            case 5:seeTournoments(UserName);
            break;
            case 6:makeQuestion(UserName);
            default:
                System.out.println("not defined");
        }
    }
    public static void DoTheactivityforUser(int input,String Username){

    }
    public static void makingClass(){
        Scanner input=new Scanner(System.in);
        new Class(input.next());
    }
    public static void PrintClasses() {
        System.out.println(AllClasses.Allclasses.toString());
    }
    public static void makingTournoment(String username){
        Searcher.AdminSearcher(username).makingTournoment();
    }
    public static void AddQuestionToTournoment(String username){
        Searcher.AdminSearcher(username).addQuestionToTournoment();
    }
    public static void seeTournoments(String username){
        Searcher.AdminSearcher(username).seeTheTournoments();
    }
    public static void makeQuestion(String username){
        Searcher.AdminSearcher(username).makeQuestion();
    }
    public static int UserType(String userName) {
        System.out.println("Enter the name of class");
        Scanner input = new Scanner(System.in);
        String className = input.next();
        if (Searcher.classSearcherByName(className).getTA().equals(Searcher.StudentSearcherByUserName(userName))) {
            return 1;
        }
        if (Searcher.classSearcherByName(className).getTeacher().equals(Searcher.StudentSearcherByUserName(userName))) {
            return 2;
        } else {
          //  for (Users user : Searcher.classSearcherByName(className).getMembers()) {
               // if (Searcher.StudentSearcherByUserName(userName).equals(user)) {
                    return 3;
                    //break;
              //  }
           // }
        }
    }
}
