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
        boolean flag2=true;
        while (flag) {
        String userName=loginPrint1();
        String password=loginPrint2();
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
            try {
                if(Searcher.AdminSearcher(userName).equals(userName)){
                    flag2=true;
                }
                else {
                    flag2=false;
                }
            }
            catch (Exception e){
                flag2=false;
            }

            if (flag1) {
                System.out.println("wellCome");
                PrintEnterAsClient(userName);
                flag=false;
            }
            else if(flag2){
                System.out.println("wellCome Admin");
                flag=false;
            }
            else {
                System.out.println("retry");
            }
        }
    }
    public static void PrintEnterAsClient(String s){
       Searcher.StudentSearcherByUserName(s).printStudentClass();
        Searcher.StudentSearcherByUserName(s).printTeacherClass();
        Searcher.StudentSearcherByUserName(s).printTAClass();
    }
}
