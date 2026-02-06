import java.awt.*;
import java.util.ArrayList;

public class TransportCar extends Truck{
    private ArrayList<Car> load;
    public TransportCar() {
        super(2,250,0, Color.PINK,"Car Transport", 15.0, new Ramp(1));
        ArrayList<Car> load = new ArrayList<>();
    }
    public void addCar(Car car) {
        if (load.size() > 10 || weight > 5.0 || this.isUndrivable() || this.getDistance(car) > 5) {
            throw new IllegalStateException();
        }
        load.add(car);
        car.setY(this.getY());
        car.setX(this.getX());
    }
    public void removeCar() {
        Car car = load.getLast();
        if (this.isUndrivable()) {
            throw new IllegalStateException();
        }
        load.remove(load.getLast());
        car.setY(this.getY() - 1);
    }
}
