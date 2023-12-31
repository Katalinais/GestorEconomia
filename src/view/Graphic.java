package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Graphic extends JDialog {

    private JLabel graphicLabel;
    private JToggleButton depositsButton;
    private JToggleButton expendituresButton;

    public Graphic() {
        initComponents();
    }

    private void initComponents() {

        graphicLabel = new JLabel();
        depositsButton = new JToggleButton();
        expendituresButton = new JToggleButton();

        setLayout(new GridBagLayout());

        graphicLabel.setFont(new Font("Segoe UI", 1, 18));
        graphicLabel.setForeground(new Color(238, 164, 250));
        graphicLabel.setText("Grafica:");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(graphicLabel, gbc);

        depositsButton.setText("Ingresos");

        expendituresButton.setText("Egresos");

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 10);
        add(depositsButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        add(expendituresButton, gbc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(depositsButton);
        buttonGroup.add(expendituresButton);
    }

    public JToggleButton getDepositsButton() {
        return depositsButton;
    }

    public JToggleButton getExpendituresButton() {
        return expendituresButton;
    }
}
