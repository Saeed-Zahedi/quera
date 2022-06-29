package ir.ac.kntu;

public class Date {

    private int day;

    private int month;

    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int compareDate(Date other){
        if(this.year>other.year){
            return 1;
        }
        if(this.year==other.year&&this.month> other.month){
            return 1;
        }
        if(this.year==other.year&&this.month== other.month&&this.day> other.day) {
            return 1;
        }
        if(this.year==other.year&&this.month== other.month&&this.day==other.day){
            return 0;
        } else {
            return -1;
        }
    }
}
