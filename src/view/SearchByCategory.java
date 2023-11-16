package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchByCategory extends JDialog {

    private JButton searchButton;
    private JButton deposits;
    private JButton expenditures;
    private JComboBox<String> categoryComboBox;
    private JLabel searchByCategoryLabel;
    private JLabel category;
    private JScrollPane jScrollPane1;
    private JTable informationTable;

    public SearchByCategory() {
        initComponents();
    }

    private void initComponents() {

        searchByCategoryLabel = new JLabel();
        category = new JLabel();
        searchButton = new JButton();
        jScrollPane1 = new JScrollPane();
        informationTable = new JTable();
        deposits = new JButton();
        expenditures = new JButton();
        categoryComboBox = new JComboBox<>();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        searchByCategoryLabel.setFont(new Font("Segoe UI", 1, 18));
        searchByCategoryLabel.setForeground(new Color(238, 164, 250));
        searchByCategoryLabel.setText("Buscar por Categoria:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets.bottom = 20;
        add(searchByCategoryLabel, gbc);

        deposits.setText("Ingresos");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.right = 5;
        add(deposits, gbc);

        expenditures.setText("Egresos");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.left = 5;
        add(expenditures, gbc);

        category.setFont(new Font("Segoe UI", 1, 14));
        category.setText("Categoria:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(category, gbc);

        categoryComboBox.setModel(
                new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(categoryComboBox, gbc);

        searchButton.setBackground(new Color(252, 240, 122));
        searchButton.setFont(new Font("Segoe UI", 1, 14));
        searchButton.setText("Buscar");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(searchButton, gbc);

        informationTable.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null },
                        { null, null },
                        { null, null },
                        { null, null }
                },
                new String[] {
                        "Fecha", "Cantidad"
                }));
        jScrollPane1.setViewportView(informationTable);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(jScrollPane1, gbc);
    }
}