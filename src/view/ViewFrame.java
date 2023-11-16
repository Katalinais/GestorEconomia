package view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.event.*;

public class ViewFrame extends JFrame {

    private Graphic graphic;
    private AddActivity addActivity;
    private SearchByDate searchByDate;
    private SearchByCategory searchByCategory;
    private AddCategory addCategory;
    private MainMenu viewPanel;

    public ViewFrame(ActionListener listener) {
        super("KATABILIDAD");
        setVisible(true);
        initComponents(listener);
        setSize(400, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
    }

    public void initComponents(ActionListener listener) {
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
        addActivity = new AddActivity();
        addActivity.setVisible(true);
        addActivity.setLocation(430, 130);
        addActivity.setSize(400, 450);
    }

    public void showSearchByDatePanel() {
        searchByDate = new SearchByDate();
        searchByDate.setVisible(true);
        searchByDate.setLocation(430, 130);
        searchByDate.setSize(550, 600);
    }

    public void showSearchByCategoryPanel() {
        searchByCategory = new SearchByCategory();
        searchByCategory.setVisible(true);
        searchByCategory.setLocation(430, 130);
        searchByCategory.setSize(550, 650);
    }

    public void showAddCategoryPanel() {
        addCategory = new AddCategory();
        addCategory.setVisible(true);
        addCategory.setLocation(430, 130);
        addCategory.setSize(350, 250);
    }

}