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
    public static  boolean Checker(){
        try {
        if(Searcher.StudentSearcherByUserName(loginPrint1()).getPassWord().equals(loginPrint2())){
               return true;
           }
        else {
            return false;
             }
        }
        catch (Exception e){
            return false;
        }

    }
    public static void CheckerPrint() {
        boolean flag = true;
        while (flag) {
            if (Checker()) {
                System.out.println("wellcome");
                flag=false;
            } else {
                System.out.println("retry");
            }
        }
    }
}
