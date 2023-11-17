package view;

import java.awt.*;
import javax.swing.*;

public class AddCategory extends JDialog {

    private JButton addButton;
    private JToggleButton depositsButton;
    private JToggleButton expendituresButton;
    private JLabel addCategoryLabel;
    private JLabel nameLabel;
    private JTextField nameTextField;

    public AddCategory() {
        initComponents();
    }

    private void initComponents() {

        addCategoryLabel = new JLabel();
        nameLabel = new JLabel();
        nameTextField = new JTextField();
        addButton = new JButton();
        depositsButton = new JToggleButton();
        expendituresButton = new JToggleButton();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        addCategoryLabel.setFont(new Font("Segoe UI", 1, 18));
        addCategoryLabel.setForeground(new Color(238, 164, 250));
        addCategoryLabel.setText("Crear Categoria:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets.bottom = 20;
        add(addCategoryLabel, gbc);

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

        nameLabel.setFont(new Font("Segoe UI", 1, 14));
        nameLabel.setText("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 5);
        add(nameLabel, gbc);

        nameTextField.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(nameTextField, gbc);

        addButton.setBackground(new Color(252, 240, 122));
        addButton.setFont(new Font("Segoe UI", 1, 14));
        addButton.setText("Añadir");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(addButton, gbc);
    }

    public JToggleButton getDepositsButton() {
        return depositsButton;
    }

    public JToggleButton getExpendituresButton() {
        return expendituresButton;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }
}

