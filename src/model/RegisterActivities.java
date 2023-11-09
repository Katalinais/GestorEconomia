package model;

import java.util.ArrayList;

public class RegisterActivities {
    private ArrayList<Activity> activities;
    private ArrayList<String> categories;

    public int totalAmount(){
        int totalAmount = 0;
        for (Activity activity: activities){
            totalAmount =+ activity.getAmount();
        }
        return totalAmount;
    }
}
