package ir.ac.kntu;
import java.util.ArrayList;
public class Searcher {
    public static Class classSearcherByName(String name){
        int re=0;
        for(int i=0;i<AllClasses.Allclasses.size();i++){
            if(AllClasses.Allclasses.get(i).getName().equals(name)){
                re=i;
                break;
            }
        }
        return AllClasses.Allclasses.get(re);
    }

    public static Question QuestionSearcher(String name){
        int Re=0;
      for(int i=0;i<QuestionBank.questions.size();i++){
          if(QuestionBank.questions.get(i).getName().equals(name)){
              Re=i;
          }
      }
      return QuestionBank.questions.get(Re);
    }
    public static Client StudentSearcherByEmail(String email){
        int re=0;
        for (int i=0;i<AllClients.allClient.size();i++){
            if (AllClients.allClient.get(i).getEmail().equals(email)){
                re=i;
            }
        }
        return AllClients.allClient.get(re);
    }
    public static boolean classResistanceByName(String name, ArrayList<Class> joined){
        boolean Re=false;
        for(int i=0;i<joined.size();i++){
            if(joined.get(i).getName().equals(name)){
                Re=true;
                break;
            }
        }
        return Re;
    }
    public static boolean QuestionExtension(String QuestionName,ArrayList<Question>HomeWork){
        boolean Re=false;
        for(int i=0;i<HomeWork.size();i++){
            if(HomeWork.get(i).getName().equals(QuestionName)){
                Re=true;
                break;
            }
        }
        return Re;
    }
    public Client studentSearcherByID(String ID){
        int re=0;
        for (int i=0;i<AllClients.allClient.size();i++){
            if (AllClients.allClient.get(i).getID().equals(ID)){
                re=i;
            }
        }
        return AllClients.allClient.get(re);
    }
    public static Class classSearcherByTeacherName(String TeacherName){
        int re=0;
        for(int i=0;i<AllClasses.Allclasses.size();i++){
            if(AllClasses.Allclasses.get(i).getTeacherName().equals(TeacherName)){
                re=i;
                break;
            }
        }
        return AllClasses.Allclasses.get(re);
    }
    public static Class classSearcherByInstituteName(String instituteName){
        int re=0;
        for(int i=0;i<AllClasses.Allclasses.size();i++){
            if(AllClasses.Allclasses.get(i).getInstituteName().equals(instituteName)){
                re=i;
                break;
            }
        }
        return AllClasses.Allclasses.get(re);
    }
    public static boolean QuestionExistenceByName(String name){
        boolean re=false;
        for(int i=0;i<QuestionBank.questions.size();i++){
            if(QuestionBank.questions.get(i).getName().equals(name)){
                re=true;
            }
        }
        return re;
    }
}
