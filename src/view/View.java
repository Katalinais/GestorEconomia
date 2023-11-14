package view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private DetailsPanel detailsPanel;
    private Footer footer;

    public View(){
        super("Gestor Ingresos-Egresos");
        setSize(540, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    public void initComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        detailsPanel = new DetailsPanel();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(detailsPanel, gbc);



        footer = new Footer();
        gbc.weighty = 0.0;
        gbc.gridy = 4;
        add(footer, gbc);
    }
}
