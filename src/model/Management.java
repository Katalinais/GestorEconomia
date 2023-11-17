package model;

import persistence.Persistence;

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
        deposits.setActivities(activitiesDeposits);ArrayList<String> categories = Persistence.readCategories("data/categoriesDeposits.json");
        ArrayList<String> categoriesExpenditures = Persistence.readCategories("data/categoriesExpenditures.json");
        expenditures.setCategories(categoriesExpenditures);
        ArrayList<Activity> activitiesExpenditures = Persistence.readActivities("data/expenditures.json");
        expenditures.setActivities(activitiesExpenditures);
    }

    public RegisterActivities getDeposits() {
        return deposits;
    }

    public RegisterActivities getExpenditures() {
        return expenditures;
    }
}
