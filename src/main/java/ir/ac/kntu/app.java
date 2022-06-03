package ir.ac.kntu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class app {
    public  app() {
        EnterPrint();
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        switch (n){
            case 1:loginPrint1();
            break;
            case 2:new Users(SingInPrint1(),SingInPrint2(),SingInPrint4(),SingInPrint5(),SingInPrint6(),SingInPrint3());
            break;
            default:break;
        }
    }
    public void EnterPrint(){
        System.out.println("Hi Enter your number:");
        System.out.println("1:login");
        System.out.println("2-Sing in");
        System.out.println("3-Enter as guest");
        System.out.println("4-Exit");
    }
    public String SingInPrint1(){
        System.out.println("Enter your name");
        Scanner input=new Scanner(System.in);
        String re=input.next();
        return  re;
    }
    public String SingInPrint2(){
        System.out.println("Enter your username");
        Scanner input=new Scanner(System.in);
        String re=input.next();
        return  re;
    }
    public String SingInPrint3(){
        System.out.println("Enter your Id");
        Scanner input=new Scanner(System.in);
        String re=input.next();
        return  re;
    }
    public String SingInPrint4(){
        System.out.println("Enter your Email");
        Scanner input=new Scanner(System.in);
        String re=input.next();
        return  re;
    }
    public String SingInPrint5(){
        System.out.println("Enter your  password");
        Scanner input=new Scanner(System.in);
        String re=input.next();
        return  re;
    }
    public String SingInPrint6(){
        System.out.println("Enter your phone number");
        Scanner input=new Scanner(System.in);
        String re=input.next();
        return  re;
    }
    public void loginPrint1(){
        System.out.println("Enter your username");
        System.out.println("Enter your  password");
    }
    public void AsStudent(){
        System.out.println("1-send Home Work");

    }
}
