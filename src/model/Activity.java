package model;

import java.util.ArrayList;
import java.util.Date;

public class Activity {
    private int amount;
    private String category;
    private Date date;

    public Activity(int amount, String category, Date date, ArrayList<String> validCategories) {
        if (validCategories.contains(category)) {
            this.amount = amount;
            this.category = category;
            this.date = date;
        } else {
            throw new IllegalArgumentException("Invalid category");
        }
    }

    public int getAmount() {
        return amount;
    }
}
