package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
public class QuestionBank {
   public static ArrayList<Question> questions=new ArrayList<>();
   public QuestionBank() {
   }
   public static void makeQuestion(){
      int n =0;
      boolean visiableForTable=false;
      boolean visiable=false;
      Scanner input=new Scanner(System.in);
      System.out.println("enter the name of question");
      String name=input.next();
      System.out.println("enter the mark of question");
      double mark=input.nextDouble();
      System.out.println("enter the  question");
      String Question=input.next();
      System.out.println("enter the type of question.1:easy-2:normal-3:HARD-4:very hard");
       n=input.nextInt();
      QuestionType qt;
      switch(n){
         case 1:{qt=QuestionType.EASY;
                break;}
         case 2:{qt=QuestionType.NORMAL;
                break;}
         case 3:{qt=QuestionType.HARD;
             break;}
         default:{ qt=QuestionType.VERYHARD;
            break;}
      }
      System.out.println("enter the answer of question");
      String answer=input.next();
      System.out.println("enter the year:");
      int year=input.nextInt();
      System.out.println("enter the month:");
      int month=input.nextInt();
      System.out.println("enter the day:");
      int day=input.nextInt();
      System.out.println("Enter the visibilityStatus.1:true -2:false");
      int visiableint=input.nextInt();
         if(visiableint==1){
            visiable=true;
         }
      System.out.println("Enter the visibilityStatus for the table.1:true -2:false");
       int visiableintfortable=input.nextInt();
       if(visiableintfortable==1){
          visiableForTable=true;
       }
      questions.add(new Question(name,mark,Question,qt,answer,new Date(day,month,year),visiable,visiableForTable));
      }
      public static void seeQuestionBankByDifficalty(){
         ArrayList<Integer>n1=new ArrayList<>();
         ArrayList<Integer>n2=new ArrayList<>();
         ArrayList<Integer>n3=new ArrayList<>();
         ArrayList<Integer>n4=new ArrayList<>();
         for(int i=0;i<questions.size();i++){
             if(questions.get(i).getQuestionType()==QuestionType.EASY){
                n1.add(i);
             }
            if(questions.get(i).getQuestionType()==QuestionType.NORMAL){
               n2.add(i);
            }
            if(questions.get(i).getQuestionType()==QuestionType.HARD){
               n3.add(i);
            }
            if(questions.get(i).getQuestionType()==QuestionType.VERYHARD){
               n4.add(i);
            }
         }
         for(int i=0;i<n1.size();i++){
            System.out.println(questions.get(n1.get(i)).toString());
         }
         for(int i=0;i<n2.size();i++){
            System.out.println(questions.get(n2.get(i)).toString());
         }
         for(int i=0;i<n3.size();i++){
            System.out.println(questions.get(n3.get(i)).toString());
         }
         for(int i=0;i<n4.size();i++){
            System.out.println(questions.get(n4.get(i)).toString());
         }
      }
      public static int[] sortQuestionsByTime(){
         int []temp=new int[questions.size()];
         for(int i=0;i<questions.size();i++){
            temp[i]=i;
         }
         for(int i=0;i<temp.length;i++){
            for(int j=i+1;j< temp.length;j++){
               if(questions.get(temp[i]).getDate().compareDate(questions.get(temp[j]).getDate())==1){
                  int t=j;
                  temp[j]=temp[i];
                  temp[i]=t;
               }
            }
         }
         return temp;
      }
      public static void seeQuestionBankByTime(){
      for(int i=0;i< sortQuestionsByTime().length;i++){
         System.out.println(questions.get(sortQuestionsByTime()[i]).toString());
         }
      }
   }

