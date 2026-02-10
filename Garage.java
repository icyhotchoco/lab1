import java.util.ArrayList;

public class Garage <A extends Car>{
    ArrayList<A> garage;
    int max;
    public Garage(int max) {
        this.garage = new ArrayList<A>();
        this.max = max;
    }
    public void addCar (A car) {
        if (garage.size() >= max)
            throw new IllegalStateException("The garage is full");
        garage.add(car);
    }
    public A removeCar(A car) {
        garage.remove(car); //removes the object instead of the index
        return car;
    }
}
