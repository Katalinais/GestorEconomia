package presenter;

import model.Management;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private Management management;
    private View view;

    public Presenter(){
        view = new View();
        management = new Management();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void actionPerformedExposits(ActionEvent e){

    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
    }
}