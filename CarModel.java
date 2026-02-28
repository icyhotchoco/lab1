import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CarModel {
    ArrayList<Car> cars = new ArrayList<>();
    Garage <Volvo240> garage = new Garage<>(10);
    HashMap<Integer, CarViewData> position = new HashMap<>();
    Point carWorkshopPoint = new Point(300,0);

    void moveit(Integer key, CarViewData carViewData) {
        this.position.put(key, carViewData);
    }
    public boolean entersGarage(Car car) {
        double carSize = car.getX() + 100; //100 är längden på bilbilden ca
        return (carSize >= garage.getX());
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
