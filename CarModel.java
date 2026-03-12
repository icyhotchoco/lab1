import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel{
    private final ArrayList<Car> cars = new ArrayList<>();
    private final Garage <Volvo240> garage = new Garage<>(10, "Volvo Garage", 300, 0);
    private final List<Observer> observers = new ArrayList<>();
    private SaabFactory saabFactory = new SaabFactory();
    private VolvoFactory volvoFactory = new VolvoFactory();
    private ScaniaFactory scaniaFactory = new ScaniaFactory();
    private final int delay = 50;
    protected javax.swing.Timer timer = new Timer(delay, new CarModel.TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if (overlap(car)) {
                    car.turnRight();
                    car.turnRight();
                }
                if (car instanceof Volvo240 && entersGarage(car)) {
                    garage.addCar((Volvo240) car);
                    x = 1000;
                    CarViewData carViewData = new CarViewData(x, y, car.getModelName());
                    for (Observer o : observers) {
                        o.place(car.hashCode(), carViewData);
                    }
                    cars.remove(car);
                    return;
                }
                car.move();
                CarViewData carViewData = new CarViewData(x, y, car.getModelName());
                for (Observer o : observers) {
                    o.place(car.hashCode(), carViewData);
                }
            }
            for (Observer o : observers) {
                o.refresh();
            }
        }
    }

    public void initializeGarage(){
        CarViewData carViewData = new CarViewData(garage.getX(), garage.getY(), garage.getModelName());
        for (Observer o : observers) {
            o.place(garage.hashCode(), carViewData);
        }
    }
    public void addObserver(Observer observer) { observers.add(observer);}
    public void notifyCarRemoved(Integer key) {
        for (Observer o : observers) {
            o.remove(key);
        }
    }

    public void addCar(Car car) {
        if (cars.size() < 10) {
            cars.add(car);
        }
    }
    public void removeCar() {
        if (cars.size() > 0) {
            Car lastCar = cars.getLast();
            cars.remove(lastCar);
            notifyCarRemoved(lastCar.hashCode());
        }
    }
    void addRandomCar() {
        Random r = new Random();
        int r1 = r.nextInt(3);

        if (r1 == 0) { addVolvo(); }
        if (r1 == 1) { addSaab(); }
        if (r1 == 2) { addScania(); }
    }
    void addVolvo() {
        if (cars.size() < 10) {
            cars.add(volvoFactory.createCar());
        }
    }
    void addSaab() {
        if (cars.size() < 10) {
            cars.add(saabFactory.createCar());
        }
    }
    void addScania() {
        if (cars.size() < 10) {
            cars.add(scaniaFactory.createCar());
        }
    }
    public boolean overlap(Car car) {
        double carSize = (car.getX()) + 100; //100 är ungefär längden på bilbilden
        return (carSize > 1000 || car.getX() < 0); //1000 är bredden på drawpanel
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
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
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
