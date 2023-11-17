package presenter;

import model.Activity;
import model.Management;
import persistence.Persistence;
import view.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter implements ActionListener {
    private Management management;
    private ViewFrame view;

    public Presenter(){
        view = new ViewFrame(this);
        management = new Management();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();

        switch (source) {
            case "enterActivity":
                view.showAddActivityPanel();
                break;
            case "depositsAdd":
                view.setCategoriesToAdd(management.getDeposits().getCategories());
                break;
            case "expendituresAdd":
                view.setCategoriesToAdd(management.getExpenditures().getCategories());
                break;
            case "searchDate":
                view.showSearchByDatePanel();
                break;
            case "searchCategory":
                view.showSearchByCategoryPanel();
                break;
            case "addCategory":
                view.showAddCategoryPanel();
                break;
            case "graphic":
                view.showGraphicPanel();
                break;
            case "addActivity":
                addActivity(view.menuSelectToAdd());
                break;
            case "searchByDate":
                searchByDate(view.menuSelectToSearchByDate());
                break;
            case "depositsSearch":
                view.setCategoriesToSearch(management.getDeposits().getCategories());
                break;
            case "expendituresSearch":
                view.setCategoriesToSearch(management.getExpenditures().getCategories());
                break;
            case "searchByCategory":
                searchByCategory(view.menuSelectToSearchByCategory());
                break;
            default:
                System.exit(0);
        }
    }

    public void addActivity(String menu){
        switch (menu){
            case "deposits":
                addActivityDeposits();
                break;
            case "expenditures":
                addActivityExpenditures();
                break;
        }
    }

    public void addActivityDeposits(){
        view.setCategoriesToAdd(management.getDeposits().getCategories());
        int amount = Integer.parseInt(view.amountToAdd());
        String category = view.categoryOfTheActivity();
        LocalDate goInDate = view.dateToAdd();
        Activity activity = new Activity(amount, category, goInDate);
        management.addDepositActivity(activity);
        Persistence.addActivity(activity, "data/deposits.json");
    }
    public void addActivityExpenditures(){
        view.setCategoriesToAdd(management.getExpenditures().getCategories());
        int amount = Integer.parseInt(view.amountToAdd());
        String category = view.categoryOfTheActivity();
        LocalDate goInDate = view.dateToAdd();
        Activity activity = new Activity(amount, category, goInDate);
        management.addExpenditureActivity(activity);
        Persistence.addActivity(activity, "data/expenditures.json");
    }

    public void searchByDate(String menu){
        switch (menu){
            case "deposits":
                searchByDateDeposits();
                break;
            case "expenditures":
                searchByDateExpenditures();
                break;
        }
    }

    public void searchByDateDeposits(){
        LocalDate date = view.dateToSearch();
        ArrayList<Activity> activities = management.searchByDate(date,management.getDeposits());
        view.showInformationTableByDate(activities);
    }

    public void searchByDateExpenditures(){
        LocalDate date = view.dateToSearch();
        ArrayList<Activity> activities = management.searchByDate(date,management.getExpenditures());
        view.showInformationTableByDate(activities);
    }
    public void searchByCategory(String menu){
        switch (menu){
            case "deposits":
                searchByCategoryDeposits();
                break;
            case "expenditures":
                searchByCategoryExpenditures();
                break;
        }
    }

    public void searchByCategoryDeposits(){
        String category = view.categoryToSearch();
        ArrayList<Activity> activities = management.searchByCategory(category,management.getDeposits());
        view.showInformationTableByCategory(activities);
    }
    public void searchByCategoryExpenditures(){
        String category = view.categoryToSearch();
        ArrayList<Activity> activities = management.searchByCategory(category,management.getExpenditures());
        view.showInformationTableByCategory(activities);
    }


    public static void main(String[] args) {
        Presenter presenter = new Presenter();
    }
}