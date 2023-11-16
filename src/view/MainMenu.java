package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JPanel {

    private JButton btnSearchCategory;
    private JButton btnSearchDate;
    private JButton btnGraphic;
    private JButton btnAddCategory;
    private JButton btnExit;
    private JButton btnActivity;
    private JLabel icon;

    public MainMenu(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

        setBackground(new Color(110, 92, 245));
        setSize(400, 540);

        btnActivity = new JButton();
        btnSearchCategory = new JButton();
        btnSearchDate = new JButton();
        btnGraphic = new JButton();
        btnAddCategory = new JButton();
        btnExit = new JButton();
        icon = new JLabel();

        btnActivity.setBackground(new Color(252, 240, 122));
        btnActivity.setFont(new Font("Segoe UI", 1, 14));
        btnActivity.setText("Ingresar Actividad");
        btnActivity.setActionCommand("enterActivity");
        btnActivity.addActionListener(listener);

        btnSearchCategory.setBackground(new Color(252, 240, 122));
        btnSearchCategory.setFont(new Font("Segoe UI", 1, 14));
        btnSearchCategory.setText("Buscar por categoria");
        btnSearchCategory.setActionCommand("searchCategory");
        btnSearchCategory.addActionListener(listener);

        btnSearchDate.setBackground(new Color(252, 240, 122));
        btnSearchDate.setFont(new Font("Segoe UI", 1, 14));
        btnSearchDate.setActionCommand("searchDate");
        btnSearchDate.addActionListener(listener);
        btnSearchDate.setText("Buscar por fecha");

        btnGraphic.setBackground(new Color(252, 240, 122));
        btnGraphic.setFont(new Font("Segoe UI", 1, 14));
        btnGraphic.setText("Grafica");
        btnGraphic.addActionListener(listener);
        btnGraphic.setActionCommand("graphic");

        btnAddCategory.setBackground(new Color(252, 240, 122));
        btnAddCategory.setFont(new Font("Segoe UI", 1, 14));
        btnAddCategory.setText("Crear nueva categoria");
        btnAddCategory.setActionCommand("addCategory");
        btnAddCategory.addActionListener(listener);

        btnExit.setBackground(new Color(252, 240, 122));
        btnExit.setFont(new Font("Segoe UI", 1, 14));
        btnExit.setText("Salir");
        btnExit.addActionListener(listener);

        icon.setIcon(new ImageIcon("img/Logo.png"));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.CENTER;
        add(icon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnActivity, gbc);

        gbc.gridy = 2;
        add(btnSearchDate, gbc);

        gbc.gridy = 3;
        add(btnSearchCategory, gbc);

        gbc.gridy = 4;
        add(btnGraphic, gbc);

        gbc.gridy = 5;
        add(btnAddCategory, gbc);

        gbc.gridy = 6;
        add(btnExit, gbc);
    }
}
