package ir.ac.kntu;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class app {
    public  app() {
        AllAdmins.admins.add(new Admin("saeed","saeed","1234"));
        System.out.println(AllAdmins.admins.get(0));
        EnterPrint();
        try {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();

            switch (n) {
                case 1:
                    Login.Checker();
                    app app1 = new app();
                    break;
                case 2:
                    new Users(Singin.SingInPrint1(), Singin.SingInPrint2(), Singin.SingInPrint4(), Singin.SingInPrint5(), Singin.SingInPrint6(), Singin.SingInPrint3());
                    app app = new app();
                    break;
                case 3:AsGuest();
                    break;
                case 4:
                    System.out.println("good bye");
                    System.exit(0);
                    break;
                default:
                    app app2 = new app();
                    break;
            }
        }
        catch (Exception e){
            app app=new app();
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
    public void AsGuest(){
        for(NormalTournoment t:AllNormalTournoment.normalTournoments){
            if (t.getDate().plusDays(t.getDay()).isBefore(LocalDate.now())){
                System.out.println(t.getQuestions());
            }
        }
        for(PrivateTournoment t:AllPrivateTournoment.privateTournoments){
            if(t.getDate().plusDays(t.getDay()).isBefore(LocalDate.now())){
                System.out.println(t.getQuestions());
            }
        }
        for(SpecialTournoment t:AllSpecialTournoments.specialTournoments){
            if(t.getDate().plusDays(t.getDay()).isBefore(LocalDate.now())){
                System.out.println(t.getQuestions());
            }
        }
    }

}

