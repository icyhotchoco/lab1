import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CarModel {
    private ArrayList<Car> cars = new ArrayList<>();
    private Garage <Volvo240> garage = new Garage<>(10);
    HashMap<Integer, CarViewData> position = new HashMap<>(); //borde vara private men används i DrawPanel
    private Point carWorkshopPoint = new Point(300,0);

    public Point getCarWorkshopPoint() { return carWorkshopPoint; }
    public int getCarListSize() { return cars.size(); }
    public void addCar(Car car) { cars.add(car); }
    void moveit(Integer key, CarViewData carViewData) {
        this.position.put(key, carViewData);
    }

    public boolean overlap(Car car) {
        double carSize = (car.getX()) + 100; //100 är ungefär längden på bilbilden
        return (carSize > 1000 || car.getX() < 0); //1000 är bredden på drawpanel, hårdkodat, dåligt
    }
    public void carmove(int i) { //den här koden brukade vara i carController timerlistener
        int x = (int) Math.round(cars.get(i).getX());
        int y = (int) Math.round(cars.get(i).getY());
        if (overlap(cars.get(i))) {
            cars.get(i).turnRight();
            cars.get(i).turnRight();
        }
        if (cars.get(i) instanceof Volvo240 && entersGarage(cars.get(i))) {
            garage.addCar((Volvo240) cars.get(i));
            x = 1000;
            CarViewData carViewData = new CarViewData(x, y, cars.get(i).getModelName());
            moveit(cars.get(i).hashCode(), carViewData);
            cars.remove(cars.get(i));
            return;
        }
        cars.get(i).move();
        CarViewData carViewData = new CarViewData(x, y, cars.get(i).getModelName());
        moveit(cars.get(i).hashCode(), carViewData);
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
