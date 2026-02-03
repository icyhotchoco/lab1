import java.awt.*;
import java.util.ArrayList;

public class TransportCar extends Car {
    private ArrayList<Car> load;
    public boolean isUp = false;
    public TransportCar () {
        super(2, 250, 0, Color.pink, "CarTransport", 15.0);
        ArrayList<Car> load = new ArrayList<Car>();

    }

    @Override
    public void gas(double amount) {
        if (amount > 1 || amount < 0 || isUp == true)
            throw new IllegalArgumentException();
        incrementSpeed(amount);

    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void raiseRamp() {
        if (currentSpeed > 0)
            throw new IllegalArgumentException();
        isUp = true;
    }
    public void lowerRamp() {
        isUp = false;
    }

public void addCar (Car car) {
        if (load.size() > 10 || this.weight < 5.0)
            throw new IllegalArgumentException();
        load.add(car);
        
}

public void removeCar (Car car) {
        if (load.size() == 0)
            throw new IllegalArgumentException();
        load.remove(car);
}
}
