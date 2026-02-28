import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CarController {
    CarView view;
    CarModel model;

    public CarController(CarView view, CarModel model) {
        this.view = view;
        this.model = model;
    }
    private final int delay = 50;
    protected javax.swing.Timer timer = new Timer(delay, new CarController.TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = model.getCarListSize() - 1; i >= 0; i--) {
                model.carmove(i);
                view.drawPanel.repaint();
            }
        }
    }
}
