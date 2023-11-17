package view;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchByDate extends JDialog {

    private JButton searchButton;
    private JToggleButton depositsButton;
    private JToggleButton expendituresButton;
    private JDateChooser dateChooser;
    private JLabel searchByCategoryLabel;
    private JLabel categoryLabel;
    private JScrollPane jScrollPane1;
    private JTable informationTable;

    public SearchByDate() {
        initComponents();
    }

    private void initComponents() {

        searchByCategoryLabel = new JLabel();
        categoryLabel = new JLabel();
        searchButton = new JButton();
        jScrollPane1 = new JScrollPane();
        informationTable = new JTable();
        depositsButton = new JToggleButton();
        expendituresButton = new JToggleButton();
        dateChooser = new JDateChooser();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        searchByCategoryLabel.setFont(new Font("Segoe UI", 1, 18));
        searchByCategoryLabel.setForeground(new Color(238, 164, 250));
        searchByCategoryLabel.setText("Buscar por Fecha:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets.bottom = 20;
        add(searchByCategoryLabel, gbc);

        depositsButton.setText("Ingresos");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.right = 5;
        add(depositsButton, gbc);

        expendituresButton.setText("Egresos");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.left = 5;
        add(expendituresButton, gbc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(depositsButton);
        buttonGroup.add(expendituresButton);

        categoryLabel.setFont(new Font("Segoe UI", 1, 14));
        categoryLabel.setText("Fecha:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(categoryLabel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(dateChooser, gbc);

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
                        "Categoria", "Cantidad"
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

    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public JTable getInformationTable() {
        return informationTable;
    }
}
