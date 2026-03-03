import java.awt.*;
import java.util.ArrayList;

public class Garage <A extends Car>{ // Garage kan bara bestå av typen Car, vi gör den abstrakt, parametrisk polymorfism
    ArrayList<A> garage;
    int max;
    int x;
    int y;
    String modelName;

    public int getX() { return x; }
    public int getY() { return y; }
    public String getModelName() { return modelName; }
    public Garage(int max, String modelName, int x, int y) {
        this.modelName = modelName;
        this.garage = new ArrayList<A>();
        this.max = max;
        this.x = x;
        this.y = y;
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