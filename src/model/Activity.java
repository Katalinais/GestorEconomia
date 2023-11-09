package model;

import java.util.Date;

public class Activity {
    private int amount;
    private String category;
    private Date date;

    public Activity(int amount, String category, Date date){
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }
}
