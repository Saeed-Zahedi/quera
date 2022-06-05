package ir.ac.kntu;

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Users>members=new ArrayList<>();
    public Group( String name) {
        this.name=name;
    }
}
