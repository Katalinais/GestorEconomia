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
        ArrayList<String> categories = Persistence.loadCategoriesXml("data/categoriesDeposits.xml");
        deposits.setCategories(categories);
        ArrayList<Activity> activities = Persistence.loadActivitiesXml("data/deposits.xml");
        deposits.setActivities(activities);
    }
}
