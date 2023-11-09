package view;

import javax.swing.*;

public class View extends JFrame {

    private DetailsPanel detailsPanel;

    public View(){
        super("Gestor Ingresos-Egresos");
        setSize(1000, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    public void initComponents(){
        detailsPanel = new DetailsPanel();
        add(detailsPanel);
    }
}
