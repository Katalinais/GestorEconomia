package model;

import persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

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
    public void addDepositCategory(String category){
        deposits.addCategory(category);
    }
    public void addExpenditureCategory(String category){
        expenditures.addCategory(category);
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

    public int availableBalance(){
        int balance = deposits.totalAmount() - expenditures.totalAmount();
        return balance;
    }

    public RegisterActivities getDeposits() {
        return deposits;
    }

    public RegisterActivities getExpenditures() {
        return expenditures;
    }

    public ArrayList<ArrayList> searchAmountByCategoryDeposits(ArrayList<Activity> activities) {
        ArrayList<ArrayList> information = new ArrayList<>();
        ArrayList<String> categories = deposits.getCategories(); // Suponiendo que tienes este método para obtener las categorías
        HashMap<String, Integer> categoryAmountMap = new HashMap<>();

        // Inicializar el mapa con cada categoría y una cantidad inicial de 0
        for (String category : categories) {
            categoryAmountMap.put(category, 0);
        }

        // Sumar las cantidades por categoría
        for (Activity activity : activities) {
            String category = activity.getCategory();
            int amount = activity.getAmount();

            if (categoryAmountMap.containsKey(category)) {
                int currentAmount = categoryAmountMap.get(category);
                categoryAmountMap.put(category, currentAmount + amount);
            }
        }

        // Convertir el mapa a una lista de listas de información
        for (String category : categories) {
            ArrayList<Object> categoryInfo = new ArrayList<>();
            categoryInfo.add(category);
            categoryInfo.add(categoryAmountMap.get(category));
            information.add(categoryInfo);
        }

        return information;
    }

    public ArrayList<ArrayList> searchAmountByCategoryDeposits() {
        ArrayList<ArrayList> information = new ArrayList<>();
        ArrayList<String> categories = deposits.getCategories(); // Suponiendo que tienes este método para obtener las categorías
        HashMap<String, Integer> categoryAmountMap = new HashMap<>();

        for (String category : categories) {
            categoryAmountMap.put(category, 0);
        }

        for (Activity activity : deposits.getActivities()) {
            String category = activity.getCategory();
            int amount = activity.getAmount();

            if (categoryAmountMap.containsKey(category)) {
                int currentAmount = categoryAmountMap.get(category);
                categoryAmountMap.put(category, currentAmount + amount);
            }
        }

        for (String category : categories) {
            ArrayList<Object> categoryInfo = new ArrayList<>();
            categoryInfo.add(category);
            categoryInfo.add(categoryAmountMap.get(category));
            information.add(categoryInfo);
        }

        return information;
    }
}