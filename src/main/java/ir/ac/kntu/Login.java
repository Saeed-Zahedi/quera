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
        while (flag) {
        String userName=loginPrint1();
        String password=loginPrint2();
        if(Searcher.AdminResistence(userName)) {
            if (AdminChecker(userName, password)) {
                PrintEnterAsAdmin();
                DoTheActivity(choseTheActivity());
                Checker();
                break;
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
    }
    public static int choseTheActivity(){
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }
    public static void DoTheActivity(int input){
        switch (input){
            case 1:makingClass();
                break;
            case 2:PrintClasses();
            break;
            default:
                System.out.println("not defiend");
        }
    }
    public static void makingClass(){
        Scanner input=new Scanner(System.in);
        new Class(input.next());
    }
    public  static void PrintClasses() {
            System.out.println(AllClasses.Allclasses.toString());
    }
}
