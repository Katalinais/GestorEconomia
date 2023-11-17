package model;

import jdk.jfr.Category;

import java.util.ArrayList;

public class RegisterActivities {
    private ArrayList<Activity> activities;
    private ArrayList<String> categories;

    public RegisterActivities() {
        activities = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }
    public void addCategory(String category){
        categories.add(category);
    }

    public int totalAmount(){
        int totalAmount = 0;
        for (Activity activity: activities){
            totalAmount += activity.getAmount();
        }
        return totalAmount;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
}
