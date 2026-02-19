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
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    Garage <Volvo240> garage = new Garage<>(10);
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        // Add a volvo to list of cars
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = cars.size() - 1 ; i >= 0 ; i--) {
                if (overlap(cars.get(i))) {
                    cars.get(i).turnRight();
                    cars.get(i).turnRight();
                }
                if (cars.get(i) instanceof Volvo240 && entersGarage(cars.get(i))) {
                    frame.drawPanel.isInGarage = true;
                    garage.addCar((Volvo240) cars.get(i));
                    cars.remove(cars.get(i));
                }
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).getX());
                int y = (int) Math.round(cars.get(i).getY());
                if (cars.get(i) instanceof Volvo240) { frame.drawPanel.volvomoveit(x,y); }
                if (cars.get(i) instanceof Saab95) { frame.drawPanel.saabmoveit(x,y); }
                if (cars.get(i) instanceof Scania) { frame.drawPanel.scaniamoveit(x,y); }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    public boolean overlap(Car car) {
        double carSize = (car.getX()) + (frame.drawPanel.volvoImage.getWidth());
        return (carSize > frame.drawPanel.getWidth() || car.getX() < 0);
    }
    public boolean entersGarage(Car car) {
        double carSize = car.getX() + frame.drawPanel.volvoImage.getWidth();
        return (carSize >= frame.drawPanel.carWorkshopPoint.getX());
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn(); //funkar men saab går bara snabbare om man gasar först, åker konstigt
            }
        }
    }
    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff(); //samma
            }
        }
    }
    void raisePlatform() {
        for (Car car : cars) {
            if (car instanceof Truck) {
                ((Truck) car).raisePlatform();
            }
        }
    }
    void lowerPlatform() {
        for (Car car : cars) {
            if (car instanceof Truck) {
                ((Truck) car).lowerPlatform();
            }
        }
    }
    void startCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }
    void stopCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}
