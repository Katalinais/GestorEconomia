package view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;

public class Footer extends JPanel {
    private JButton addCategory;
    private JButton search;
    private JButton graphics;

    public Footer() {
        initComponents();
        addComponents();
    }

    public void initComponents(){
        addCategory = new JButton();
        addCategory.setText("Añadir Categoría");
        addCategory.setFont(new Font("Open Sans Extrabold", 1, 12));
        addCategory.setOpaque(true);
        addCategory.setBackground(new Color(255,255,255));
        addCategory.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));

        search = new JButton();
        search.setText("Buscar");
        search.setOpaque(true);
        search.setFont(new Font("Open Sans Extrabold", 1, 12));
        search.setBackground(new Color(255,255,255));
        search.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));

        graphics = new JButton();
        graphics.setText("Ver Gráfica");
        setOpaque(true);
        graphics.setFont(new Font("Open Sans Extrabold", 1, 12));
        graphics.setBackground(new Color(255,255,255));
        graphics.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255)));
    }

    public void addComponents(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(addCategory)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graphics)
                )
        );

        layout.setVerticalGroup(layout.createParallelGroup()
                .addComponent(addCategory)
                .addComponent(search)
                .addComponent(graphics)
        );
    }

}
