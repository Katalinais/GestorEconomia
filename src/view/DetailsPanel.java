package view;

import javax.swing.*;
import com.toedter.calendar.JCalendar;

import java.awt.*;

public class DetailsPanel extends JPanel {
    private JLabel amount;
    private JTextField amountField;
    private JLabel category;
    private JComboBox categorySelection;
    private JLabel date;
    private JTextField dateText;
    private JButton dateButton;

    public DetailsPanel(){
        initComponents();
        addComponents();
    }

    public void initComponents(){
        amount = new JLabel();
        amount.setText("Cantidad($):");

        amountField = new JTextField();

        category = new JLabel();
        category.setText("Categoría:");

        categorySelection = new JComboBox<>();

        date = new JLabel();
        date.setText("Fecha");

        dateText = new JTextField();

        dateButton = new JButton();
        dateButton.setPreferredSize(new Dimension(10,10));

    }

    public void addComponents() {
        setLayout(new GridBagLayout()); // Establece el diseño del panel como GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(amount, gbc);

        gbc.gridx = 1;
        add(amountField, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(category, gbc);

        gbc.gridx = 1;
        add(categorySelection, gbc);

        gbc.weighty = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(date, gbc);

        gbc.gridx = 1;
        add(dateText, gbc);

        gbc.gridx = 2;
        add(dateButton, gbc);

        // Agrega los demás componentes con sus restricciones aquí
    }

}
