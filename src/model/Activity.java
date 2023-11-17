package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Activity {
    private int amount;
    private String category;
    private LocalDate date;

    public Activity(int amount, String category, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }
}
