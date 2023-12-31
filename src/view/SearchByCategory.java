package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchByCategory extends JDialog {

    private JButton searchButton;
    private JToggleButton depositsButton;
    private JToggleButton expendituresButton;
    private JComboBox<String> categoryComboBox;
    private JLabel searchByCategoryLabel;
    private JLabel category;
    private JScrollPane jScrollPane1;
    private JTable informationTable;

    public SearchByCategory(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

        searchByCategoryLabel = new JLabel();
        category = new JLabel();
        searchButton = new JButton();
        jScrollPane1 = new JScrollPane();
        informationTable = new JTable();
        depositsButton = new JToggleButton();
        expendituresButton = new JToggleButton();
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

        depositsButton.setText("Ingresos");
        depositsButton.setActionCommand("depositsSearch");
        depositsButton.addActionListener(listener);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.right = 5;
        add(depositsButton, gbc);

        expendituresButton.setText("Egresos");
        expendituresButton.setActionCommand("expendituresSearch");
        expendituresButton.addActionListener(listener);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.left = 5;
        add(expendituresButton, gbc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(depositsButton);
        buttonGroup.add(expendituresButton);

        category.setFont(new Font("Segoe UI", 1, 14));
        category.setText("Categoria:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(category, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(categoryComboBox, gbc);

        searchButton.setBackground(new Color(252, 240, 122));
        searchButton.setFont(new Font("Segoe UI", 1, 14));
        searchButton.setText("Buscar");
        searchButton.setActionCommand("searchByCategory");
        searchButton.addActionListener(listener);
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

    public JToggleButton getDepositsButton() {
        return depositsButton;
    }

    public JToggleButton getExpendituresButton() {
        return expendituresButton;
    }

    public JComboBox<String> getCategoryComboBox() {
        return categoryComboBox;
    }

    public JTable getInformationTable() {
        return informationTable;
    }

    public void setCategories(ArrayList<String> categories) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(categories.toArray(new String[0]));
        categoryComboBox.setModel(model);
    }
}