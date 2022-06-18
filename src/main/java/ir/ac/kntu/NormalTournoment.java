package ir.ac.kntu;

public class NormalTournoment extends Tournoment{
    public NormalTournoment(String name) {
        super(name);
        AllTournoments.tournoments.add(this);
    }
}
