import java.awt.*;
import java.util.ArrayList;

public class Garage <A extends Car>{ // Garage kan bara bestå av typen Car, vi gör den abstrakt, parametrisk polymorfism
    ArrayList<A> garage;
    int max;
    int x;
    int y;

    public int getX() { return x; }
    public int getY() { return y; }
    public Garage(int max) {
        this.garage = new ArrayList<A>();
        this.max = max;
    }
    public void addCar (A car) {
        if (garage.size() >= max)
            throw new IllegalStateException("The garage is full");
        garage.add(car);
    }
    public A removeCar(A car) { // ger den mest specifika typen när man har A som return type
        garage.remove(car); //removes the object instead of the index
        return car;
    }
}