import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel{
    private final ArrayList<Car> cars = new ArrayList<>();
    private final Garage <Volvo240> garage = new Garage<>(10, "Volvo Garage", 300, 0);
    private final List<Observer> observers = new ArrayList<>();
    private SaabFactory saabFactory = new SaabFactory(this);
    private VolvoFactory volvoFactory = new VolvoFactory(this);
    private ScaniaFactory scaniaFactory = new ScaniaFactory(this);
    public void initializeGarage(){
        CarViewData carViewData = new CarViewData(garage.getX(), garage.getY(), garage.getModelName());
        for (Observer o : observers) {
            o.place(garage.hashCode(), carViewData);
        }
    }
    public void addObserver(Observer observer) { observers.add(observer);}
    public void addCar(Car car) { cars.add(car); }
    public void removeCar() {
        if (cars.size() > 0) {
        Car lastCar = cars.getLast();
        cars.remove(lastCar); }
    }
    void addRandomCar() {
        Random r = new Random();
        int r1 = r.nextInt(3);

        if (r1 == 0) { volvoFactory.createCar(); }
        if (r1 == 1) { saabFactory.createCar(); }
        if (r1 == 2) { scaniaFactory.createCar(); }
    }
    void addVolvo() {
        volvoFactory.createCar();
    }
    void addSaab() {
        saabFactory.createCar();
    }
    void addScania() {
        scaniaFactory.createCar();
    }
    public boolean overlap(Car car) {
        double carSize = (car.getX()) + 100; //100 är ungefär längden på bilbilden
        return (carSize > 1000 || car.getX() < 0); //1000 är bredden på drawpanel, hårdkodat, dåligt
    }
    public void carmove() { //den här koden brukade vara i carController timerlistener
        for (int i = cars.size() - 1; i >= 0; i--) {
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
                for (Observer o : observers) {
                    o.place(cars.get(i).hashCode(), carViewData);
                }
                cars.remove(cars.get(i));
                return;
            }
            cars.get(i).move();
            CarViewData carViewData = new CarViewData(x, y, cars.get(i).getModelName());
            for (Observer o : observers) {
                o.place(cars.get(i).hashCode(), carViewData);
            }
        }
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
