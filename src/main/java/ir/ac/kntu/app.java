package ir.ac.kntu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class app {
    public  app() {
        EnterPrint();
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        switch (n){
            case 1:Login.CheckerPrint();
            break;
            case 2:new Users(Singin.SingInPrint1(),Singin.SingInPrint2(),Singin.SingInPrint4(),Singin.SingInPrint5(),Singin.SingInPrint6(),Singin.SingInPrint3());
            break;
            case 4:System.exit(0);
        }
    }
    public void EnterPrint(){
        System.out.println("Hi Enter your number:");
        System.out.println("1:login");
        System.out.println("2-Sing in");
        System.out.println("3-Enter as guest");
        System.out.println("4-Exit");
    }

    public void AsStudent(){
        System.out.println("1-send Home Work");

    }
}
