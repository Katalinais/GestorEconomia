package presenter;

import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private View view;

    public Presenter(){
        view = new View();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
    }
}