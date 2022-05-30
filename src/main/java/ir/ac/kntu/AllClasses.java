package ir.ac.kntu;
import java.util.ArrayList;

public class AllClasses {
   public static ArrayList<Class>Allclasses=new ArrayList<>();

    public AllClasses() {
    }

    public ArrayList<Class> getAllclasses(){
        return Allclasses;
    }
    public static void printAllClasses(){
        for(int i=0;i<Allclasses.size();i++){
            System.out.println(Allclasses.get(i));
        }
    }
}
