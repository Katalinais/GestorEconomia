package view;

import Utilities.Utilities;
import model.Activity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ViewFrame extends JFrame {
    private Graphic graphic;
    private AddActivity addActivity;
    private SearchByDate searchByDate;
    private SearchByCategory searchByCategory;
    private AddCategory addCategory;
    private MainMenu viewPanel;
    private ActionListener listener;

    public ViewFrame(ActionListener listener) {
        super("KATABILIDAD");
        setVisible(true);
        this.listener = listener;
        initComponents(listener);
        setSize(400, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    public void initComponents(ActionListener listener) {
        Image icon = new ImageIcon("img/Logo.png").getImage();
        this.setIconImage(icon);
        viewPanel = new MainMenu(listener);
        viewPanel.setPreferredSize(new Dimension(400, 500));
        this.setContentPane(viewPanel);
    }

    public void showGraphicPanel() {
        graphic = new Graphic();
        graphic.setVisible(true);
        graphic.setLocation(430, 130);
        graphic.setSize(550, 650);
    }

    public void showAddActivityPanel() {
        addActivity = new AddActivity(listener);
        addActivity.setVisible(true);
        addActivity.setLocation(430, 130);
        addActivity.setSize(400, 450);
    }

    public void showSearchByDatePanel() {
        searchByDate = new SearchByDate(listener);
        searchByDate.setVisible(true);
        searchByDate.setLocation(430, 70);
        searchByDate.setSize(550, 700);
    }

    public void showSearchByCategoryPanel() {
        searchByCategory = new SearchByCategory(listener);
        searchByCategory.setVisible(true);
        searchByCategory.setLocation(430, 130);
        searchByCategory.setSize(550, 650);
    }

    public void showAddCategoryPanel() {
        addCategory = new AddCategory(listener);
        addCategory.setVisible(true);
        addCategory.setLocation(430, 130);
        addCategory.setSize(350, 250);
    }

    public String menuSelectToAdd(){
        String menu = "";
        if(addActivity.getDepositsButton().isSelected()){
            menu = "deposits";
        } else if (addActivity.getExpendituresButton().isSelected()) {
            menu = "expenditures";
        }
        return menu;
    }

    public void setCategoriesToAdd(ArrayList<String> categories){
        addActivity.setCategories(categories);
    }

    public String amountToAdd(){
        return addActivity.getAmountTextField().getText();
    }

    public String categoryOfTheActivity(){
        return addActivity.getCategoriesComboBox().getSelectedItem().toString();
    }

    public LocalDate dateToAdd(){
        Date date = addActivity.getCalendar().getDate();
        LocalDate localDate = Utilities.dateToLocalDate(date);
        return localDate;
    }

    //TODO: Revisar este método
    public void showInformationTableByDate(ArrayList<Activity> activities) {
        JTable table = searchByDate.getInformationTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        int requiredRows = activities.size();
        int existingRows = rowCount;

        if (existingRows < requiredRows) {
            int rowsToAdd = requiredRows - existingRows;
            for (int i = 0; i < rowsToAdd; i++) {
                model.addRow(new Object[columnCount]);
            }
        }

        for (int i = 0; i < requiredRows; i++) {
            Activity activity = activities.get(i);
            model.setValueAt(activity.getCategory(), i, 0);
            model.setValueAt(activity.getAmount(), i, 1);
        }
    }

    public void showInformationTableByCategory(ArrayList<Activity> activities) {
        JTable table = searchByCategory.getInformationTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        int requiredRows = activities.size();
        int existingRows = rowCount;

        if (existingRows < requiredRows) {
            int rowsToAdd = requiredRows - existingRows;
            for (int i = 0; i < rowsToAdd; i++) {
                model.addRow(new Object[columnCount]);
            }
        }

        for (int i = 0; i < requiredRows; i++) {
            Activity activity = activities.get(i);
            model.setValueAt(activity.getDate(), i, 0);
            model.setValueAt(activity.getAmount(), i, 1);
        }
    }

    public LocalDate dateToSearch(){
        return Utilities.dateToLocalDate(searchByDate.getDateChooser().getDate());
    }


    public String menuSelectToSearchByDate(){
        String menu = "";
        if(searchByDate.getDepositsButton().isSelected()){
            menu = "deposits";
        } else if (searchByDate.getExpendituresButton().isSelected()) {
            menu = "expenditures";
        }
        return menu;
    }
    public String menuSelectToSearchByCategory(){
        String menu = "";
        if(searchByCategory.getDepositsButton().isSelected()){
            menu = "deposits";
        } else if (searchByCategory.getExpendituresButton().isSelected()) {
            menu = "expenditures";
        }
        return menu;
    }

    public void setCategoriesToSearch(ArrayList<String> categories){
        searchByCategory.setCategories(categories);
    }
    public String categoryToSearch(){
        return searchByCategory.getCategoryComboBox().getSelectedItem().toString();
    }
    public String menuGraphic(){
        String menu = "";
        if(graphic.getDepositsButton().isSelected()){
            menu = "deposits";
        } else if (graphic.getExpendituresButton().isSelected()) {
            menu = "expenditures";
        }
        return menu;
    }
    public String menuAddCategory(){
        String menu = "";
        if(addCategory.getDepositsButton().isSelected()){
            menu = "deposits";
        } else if (addCategory.getExpendituresButton().isSelected()) {
            menu = "expenditures";
        }
        return menu;
    }

    public String categoryToAdd(){
        return addCategory.getNameTextField().getText();
    }

    public void setAmount(String text){
        addActivity.getMoneyLabel().setText(text);
    }
}