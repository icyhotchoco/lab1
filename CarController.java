import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    //måste göra cars accessible, arraylistan är nu i carmodel
    CarView view;
    CarModel model;

    private final int delay = 50;
    protected javax.swing.Timer timer = new Timer(delay, new CarController.TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = cars.size() - 1 ; i >= 0 ; i--) {
                int x = (int) Math.round(cars.get(i).getX());
                int y = (int) Math.round(cars.get(i).getY());
                if (view.overlap(cars.get(i))) {
                    cars.get(i).turnRight();
                    cars.get(i).turnRight();
                }
                if (cars.get(i) instanceof Volvo240 && model.entersGarage(cars.get(i))) {
                    garage.addCar((Volvo240) cars.get(i));
                    x = 1000;
                    CarViewData carViewData = new CarViewData(x, y, cars.get(i).getModelName());
                    model.moveit(cars.get(i).hashCode(), carViewData);
                    cars.remove(cars.get(i));
                    return;
                }

                cars.get(i).move();

                CarViewData carViewData = new CarViewData(x, y, cars.get(i).getModelName());
                model.moveit(cars.get(i).hashCode(), carViewData);
                view.drawPanel.repaint();
            }
        }
    }

    // A list of cars, modify if needed

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

}
