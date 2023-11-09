package view;

import javax.swing.*;
import com.toedter.calendar.JCalendar;

import java.awt.*;

public class DetailsPanel extends JPanel {
    private JButton expenditures;
    private JButton deposits;
    private JLabel amount;
    private JTextField amountField;
    private JLabel category;
    private JComboBox categorySelection;
    private JLabel date;
    private JTextField dateText;
    private JButton dateButton;

    public DetailsPanel(){
        setBackground(new Color(255,120,35));
        initComponents();
        addComponents();
    }

    public void initComponents(){
        amount = new JLabel();
        amount.setText("Cantidad($):");

        amountField = new JTextField();
        amountField.setPreferredSize(new Dimension(400,25));

        category = new JLabel();
        category.setText("Categoría:");

        categorySelection = new JComboBox<>();
        categorySelection.setPreferredSize(new Dimension(400,25));

        date = new JLabel();
        date.setText("Fecha");

        dateText = new JTextField();
        dateText.setPreferredSize(new Dimension(375,25));

        dateButton = new JButton();
        dateButton.setPreferredSize(new Dimension(25,25));

        expenditures = new JButton();
        expenditures.setText("Egresos");

        deposits = new JButton();
        deposits.setText("Ingresos");
    }

    public void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridy = 0;
        gbc.gridx = 1;
        add(expenditures, gbc);

        gbc.gridx = 1;
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createRigidArea(new Dimension(10, 0)));  // Espacio de 10 píxeles
        horizontalBox.add(deposits);
        add(horizontalBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(amount, gbc);

        gbc.gridx = 1;
        add(amountField, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(category, gbc);

        gbc.gridx = 1;
        add(categorySelection, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(date, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(dateText, gbc);


        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(dateButton, gbc);
    }

}
