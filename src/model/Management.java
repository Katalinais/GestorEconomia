package model;

import persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class Management {
    private  RegisterActivities deposits;
    private RegisterActivities expenditures;

    public Management(){
        deposits = new RegisterActivities();
        expenditures = new RegisterActivities();
        initComponents();
        System.out.println(deposits.totalAmount());
    }

    public void initComponents(){
        ArrayList<String> categoriesDeposits = Persistence.readCategories("data/categoriesDeposits.json");
        deposits.setCategories(categoriesDeposits);
        ArrayList<Activity> activitiesDeposits = Persistence.readActivities("data/deposits.json");
        deposits.setActivities(activitiesDeposits);
        ArrayList<String> categoriesExpenditures = Persistence.readCategories("data/categoriesExpenditures.json");
        expenditures.setCategories(categoriesExpenditures);
        ArrayList<Activity> activitiesExpenditures = Persistence.readActivities("data/expenditures.json");
        expenditures.setActivities(activitiesExpenditures);
    }



    public void addDepositActivity(Activity activity){
        deposits.addActivity(activity);
    }
    public void addExpenditureActivity(Activity activity){
        expenditures.addActivity(activity);
    }

    public ArrayList<Activity> searchByDate(LocalDate date, RegisterActivities registerActivities){
        ArrayList<Activity> activities = new ArrayList<>();
        for(Activity activity : registerActivities.getActivities()){
            if (activity.getDate().equals(date)){
                activities.add(activity);
            }
        }
        return activities;
    }
    public ArrayList<Activity> searchByCategory(String category, RegisterActivities registerActivities){
        ArrayList<Activity> activities = new ArrayList<>();
        for(Activity activity : registerActivities.getActivities()){
            if (activity.getCategory().equals(category)){
                activities.add(activity);
            }
        }
        return activities;
    }

    public RegisterActivities getDeposits() {
        return deposits;
    }

    public RegisterActivities getExpenditures() {
        return expenditures;
    }
}