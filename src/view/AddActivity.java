package view;

import java.awt.*;
import javax.swing.*;

public class AddActivity extends JDialog {
    private JToggleButton depositsButton;
    private JButton addButton;
    private JToggleButton expendituresButton;
    private JComboBox<String> categoriesComboBox;
    private JLabel moneyLabel;
    private JLabel categoryLabel;
    private JLabel dateLabel;
    private JLabel totalBalance;
    private JLabel amountLabel;
    private JLabel addActivityLabel;
    private JTextField amountTextField;
    private JTextField calendar;

    public AddActivity() {
        initComponents();
    }

    private void initComponents() {

        moneyLabel = new JLabel();
        amountLabel = new JLabel();
        categoryLabel = new JLabel();
        dateLabel = new JLabel();
        amountTextField = new JTextField(30);
        categoriesComboBox = new JComboBox<>();
        addButton = new JButton();
        totalBalance = new JLabel();
        moneyLabel = new JLabel();
        depositsButton = new JToggleButton();
        expendituresButton = new JToggleButton();
        addActivityLabel = new JLabel();
        calendar = new JTextField(30);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        addActivityLabel.setFont(new Font("Segoe UI", 3, 18));
        addActivityLabel.setForeground(new Color(238, 164, 250));
        addActivityLabel.setText("Ingresar Actividad:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets.bottom = 20;
        add(addActivityLabel, gbc);

        depositsButton.setText("Ingresos");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.right = 5;
        add(depositsButton, gbc);

        expendituresButton.setText("Egresos");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets.left = 5;
        add(expendituresButton, gbc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(depositsButton);
        buttonGroup.add(expendituresButton);


        amountLabel.setFont(new Font("Segoe UI", 3, 18));
        amountLabel.setText("Cantidad ($):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 5);
        add(amountLabel, gbc);

        amountTextField.setColumns(10);
        amountTextField.setFont((new Font("Segoe UI", 3, 18)));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 0);
        add(amountTextField, gbc);

        categoryLabel.setFont(new Font("Segoe UI", 3, 18));
        categoryLabel.setText("Categoria:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 5);
        add(categoryLabel, gbc);

        categoriesComboBox.setModel(
                new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoriesComboBox.setFont(new Font("Segoe UI", 3, 18));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 0);
        add(categoriesComboBox, gbc);

        dateLabel.setFont(new Font("Segoe UI", 3, 18));
        dateLabel.setText("Fecha:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 5);
        add(dateLabel, gbc);

        calendar.setColumns(10);
        calendar.setFont((new Font("Segoe UI", 3, 18)));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 10, 0);
        add(calendar, gbc);

        addButton.setBackground(new Color(252, 240, 122));
        addButton.setFont(new Font("Segoe UI", 3, 18));
        addButton.setText("Ingresar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 0, 20, 0);
        add(addButton, gbc);

        totalBalance.setFont(new Font("Segoe UI", 3, 18));
        totalBalance.setText("Saldo disponible:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 0, 5);
        add(totalBalance, gbc);

        moneyLabel.setFont(new Font("Segoe UI", 3, 18));
        moneyLabel.setText("$");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(moneyLabel, gbc);
    }

    public JToggleButton getDepositsButton() {
        return depositsButton;
    }

    public JToggleButton getExpendituresButton() {
        return expendituresButton;
    }

    public JComboBox<String> getCategoriesComboBox() {
        return categoriesComboBox;
    }

    public JTextField getAmountTextField() {
        return amountTextField;
    }

    public JTextField getCalendar() {
        return calendar;
    }
}

