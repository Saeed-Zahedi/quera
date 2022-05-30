package ir.ac.kntu;
import java.util.ArrayList;

public class Class {
     private String name;
     private String InstituteName;
     private String TeacherName;
     private int    YearOfCourse;
     private boolean ClassStatusForRegestion;
     private boolean PrivateStatus;
     private String  Password;
     private String  expelaination;
     private Client TA;
     private Client Teacher;
     private ArrayList<Question>HomeWorks=new ArrayList<>();
    public Class(String name, String instituteName, String teacherName, int yearOfCourse, boolean classStatusForRegestion, boolean privateStatus, String password, String expelaination, Client owner) {
        this.name = name;
        InstituteName = instituteName;
        TeacherName = teacherName;
        YearOfCourse = yearOfCourse;
        ClassStatusForRegestion = classStatusForRegestion;
        PrivateStatus = privateStatus;
        Password = password;
        this.expelaination = expelaination;
        this.TA = owner;
    }

    public Class() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setname(String Name) {
        name = Name;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public ArrayList<Question> getHomeWorks() {
        return HomeWorks;
    }

    public Client getOwner() {
        return TA;
    }

    public String getName() {
        return name;
    }

    public boolean isClassStatusForRegestion() {
        return ClassStatusForRegestion;
    }

    public boolean isPrivateStatus() {
        return PrivateStatus;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", InstituteName='" + InstituteName + '\'' +
                '}';
    }
}
