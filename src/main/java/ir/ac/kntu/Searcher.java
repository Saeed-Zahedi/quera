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
    public static Users StudentSearcherByEmail(String email){
        int re=0;
        for (int i=0;i<AllUsers.allUsers.size();i++){
            if (AllUsers.allUsers.get(i).getEmail().equals(email)){
                re=i;
            }
        }
        return AllUsers.allUsers.get(re);
    }
    public static Users StudentSearcherByUserName(String username){
        int re=0;
        for (int i=0;i<AllUsers.allUsers.size();i++){
            if (AllUsers.allUsers.get(i).getUsername().equals(username)){
                re=i;
            }
        }
        return AllUsers.allUsers.get(re);
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

            }
        }
        return Re;
    }
    public Users studentSearcherByID(String ID){
        int re=0;
        for (int i=0;i<AllUsers.allUsers.size();i++){
            if (AllUsers.allUsers.get(i).getID().equals(ID)){
                re=i;
            }
        }
        return AllUsers.allUsers.get(re);
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
    public static Admin AdminSearcher(String UserName){
        int re=0;
        for(int i=0;i<AllAdmins.admins.size();i++){
            if(AllAdmins.admins.get(i).getUserName().equals(UserName)){
                re=i;
            }
        }
            return AllAdmins.admins.get(re);

    }
    public static boolean AdminResistence(String UserName) {
        boolean re = false;
        for (int i = 0; i < AllAdmins.admins.size(); i++) {
            if (AllAdmins.admins.get(i).getUserName().equals(UserName)) {
                re = true;
            }
        }
        return re;
    }
    public static NormalTournoment NormalTournomentSearcher(String name){
        int re=0;
        for(int i=0;i<AllNormalTournoment.normalTournoments.size();i++){
            if(AllNormalTournoment.normalTournoments.get(i).getName().equals(name)){
                re=i;
            }
        }
        return AllNormalTournoment.normalTournoments.get(re);
    }
    public static boolean NormalTornomentexistense(String name){
        boolean re=false;
        for(NormalTournoment t:AllNormalTournoment.normalTournoments){
            if(t.getName().equals(name)){
                re=true;
            }
        }
        return re;
    }
   /* public static void joinGroupINSpecialClass(Users user,String name,String group){
        boolean flag=false;
        for( SpecialTournoment t:AllSpecialTournoment.specialTournoments){
            if(t.getName().equals(name)){
                for(Group g:t.getGroups()){
                    if(g.getName().equals(group)){
                        g.getMembers().add(user);
                        flag=true;
                    }
                }
                if(!flag){
                    t.getGroups().add(new Group(group));
                    for(Group g:t.getGroups()){
                        if(g.getName().equals(group)){
                            g.getMembers().add(user);
                        }
                    }
                }
            }
        }
    }*/
     public static boolean ClassResistenceByName(String className){
        boolean re=false;
        for(int i=0;i<AllClasses.Allclasses.size();i++){
            if(AllClasses.Allclasses.get(i).getName().equals(className)){
                re =true;
            }
        }
        return re;
     }
     public static boolean StudentResistance(String userName){
        boolean re=false;
        for(Users u:AllUsers.allUsers){
            if(u.getUsername().equals(userName)){
                re=true;
            }
        }
        return re;
     }
    public static PrivateTournoment privateTournoment(String name){
        int re=0;
        for(int i=0;i<AllPrivateTournoment.privateTournoments.size();i++){
            if(AllPrivateTournoment.privateTournoments.get(i).getName().equals(name)){
                re=i;
            }
        }
        return AllPrivateTournoment.privateTournoments.get(re);
    }
    public static boolean PrivateTournomentExistance(String name){
        boolean re=false;
        for(PrivateTournoment t:AllPrivateTournoment.privateTournoments){
            if(t.getName().equals(name)){
                re=true;
            }
        }
        return re;
    }
    public static boolean studentResitance(String username,ArrayList<Users>u){
         boolean re=false;
         for(Users t:u){
             if(t.getUsername().equals(username)){
                 re=true;
             }
         }
         return re;
    }
    public static boolean SpecialTournomentResistance(String name){
         boolean re=false;
         for(SpecialTournoment t:AllSpecialTournoments.specialTournoments){
             if(t.getName().equals(name)){
                 re=true;
             }
         }
         return re;
    }
    public static SpecialTournoment SpecialTournomentSearcher(String name){
        int re=0;
        for(int i=0;i<AllSpecialTournoments.specialTournoments.size();i++){
            if(AllSpecialTournoments.specialTournoments.get(i).getName().equals(name)){
                re=i;
            }
        }
        return AllSpecialTournoments.specialTournoments.get(re);
    }
    public static Group WhatIsMyGroup(String username,ArrayList<Group>groups){
         Group g_re=groups.get(0);
         for (Group g:groups){
             for(Users u:g.getMembers()){
                 if(u.getUsername().equals(username)){
                     g_re=g;
                 }
             }
         }
         return g_re;
    }
}
