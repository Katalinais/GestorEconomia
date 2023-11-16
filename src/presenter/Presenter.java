package presenter;

import model.Management;
import view.ViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private Management management;
    private ViewFrame view;

    public Presenter(){
        view = new ViewFrame(this);
        management = new Management();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();

        if (source.equals("enterActivity")) {
            view.showAddActivityPanel();
        } else if (source.equals("searchDate")) {
            view.showSearchByDatePanel();
        } else if (source.equals("searchCategory")) {
            view.showSearchByCategoryPanel();
        } else if (source.equals("addCategory")) {
            view.showAddCategoryPanel();
        } else if (source.equals("graphic")) {
            view.showGraphicPanel();
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
    }
}