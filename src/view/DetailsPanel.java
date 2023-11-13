package view;

import javax.swing.*;

import java.awt.*;

public class DetailsPanel extends JPanel {
    private JLabel amount;
    private JTextField amountField;
    private JLabel category;
    private JComboBox categorySelection;
    private JLabel date;
    private JTextField dateText;
    private JButton dateButton;
    private JLabel balance;
    private JLabel balanceTxt;

    public DetailsPanel(){
        setBackground(new Color(255,120,35));
        initComponents();
        addComponents();
    }

    public void initComponents(){
        amount = new JLabel();
        amount.setText("Cantidad($):");
        amount.setFont(new Font(Font.SERIF, Font.PLAIN, 18));

        amountField = new JTextField();
        amountField.setPreferredSize(new Dimension(200,25));

        category = new JLabel();
        category.setText("Categoría:");
        category.setFont(new Font(Font.SERIF, Font.PLAIN, 18));

        categorySelection = new JComboBox<>();
        categorySelection.setPreferredSize(new Dimension(200,25));

        date = new JLabel();
        date.setText("Fecha");
        date.setFont(new Font(Font.SERIF, Font.PLAIN, 18));

        dateText = new JTextField();
        dateText.setPreferredSize(new Dimension(175,25));

        dateButton = new JButton();
        dateButton.setPreferredSize(new Dimension(25,25));

        balance = new JLabel();
        balance.setText("Saldo Total: ");
        balance.setFont(new Font(Font.SERIF, Font.PLAIN, 18));

        balanceTxt = new JLabel();
        balanceTxt.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        balanceTxt.setText("40000");
    }

    public void addComponents() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(amount, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(category, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(balance)
                                )
                                .addGroup(layout.createParallelGroup()
                                        .addComponent(amountField, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categorySelection, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dateText, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dateButton, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        )
                                        .addComponent(balanceTxt)
                                ))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(amount)
                                .addGap(5)
                                .addComponent(category)
                                .addGap(5)
                                .addComponent(date)
                                .addGap(10)
                                .addComponent(balance)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(amountField, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(2)
                                .addComponent(categorySelection, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(2)
                                .addGroup(layout.createParallelGroup()
                                        .addGap(2)
                                        .addComponent(dateText, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(12)
                                .addComponent(balanceTxt)
                        )
        );
    }
}
