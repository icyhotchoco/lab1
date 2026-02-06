import java.util.ArrayList;

public class Garage <A extends Car> {
    ArrayList<A> garage;

    public Garage() {
        ArrayList<A> garage = new ArrayList<A>();

    }
    public void addCar(A car) {
        garage.add(car);

    }

}

