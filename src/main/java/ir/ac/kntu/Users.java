package ir.ac.kntu;

import java.util.ArrayList;

public class Users {
    private String name;
    private String username;
    private String ID;
    private String Email;
    private String passWord;
    private String phoneNumber;
    private ArrayList<Class>TA=new ArrayList<>();
    private ArrayList<Class>Teacher=new ArrayList<>();
    private ArrayList<Class>Student=new ArrayList<>();
    public Users(String name, String username, String email, String passWord, String phoneNumber,String ID) {
        this.name = name;
        this.username = username;
        Email = email;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.ID=ID;
        AllUsers.allUsers.add(this);
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public ArrayList<Class> getTA() {
        return TA;
    }

    public ArrayList<Class> getTeacher() {
        return Teacher;
    }

    public ArrayList<Class> getStudent() {
        return Student;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void printStudentClass(){
        System.out.println("classes as student");
        for(int i=0;i<Student.size();i++){
            System.out.println(Student.get(i));
        }
    }
    public void printTeacherClass(){
        System.out.println("classes as Teacher");
        for(int i=0;i<Teacher.size();i++){
            System.out.println(Teacher.get(i));
        }
    }
    public void printTAClass(){
        System.out.println("classes as TA");
        for(int i=0;i<TA.size();i++){
            System.out.println(TA.get(i));
        }
    }
    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", ID='" + ID + '\'' +
                ", Email='" + Email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
