import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car = new Saab95();


    @Test
    void turnLeft() {
        car.turnLeft();
        assertEquals(270, car.getDirectionDeg());
    }

    @Test
    void turnRight() {
        car.turnRight();
        assertEquals(90, car.getDirectionDeg());
    }

    @Test
    void move() {
        car.move();
        assertEquals(car.getCurrentSpeed(), car.getY());
        car.turnRight();
        car.move();
        assertEquals(car.getCurrentSpeed(), car.getX());
        car.turnRight();
        car.move();
        assertEquals(car.getCurrentSpeed(), car.getY());
        car.turnRight();
        car.move();
        assertEquals(car.getCurrentSpeed(), car.getX());
    }

    @Test
    public void gas() {
        car.gas(1);
        assertEquals(1.25, car.getCurrentSpeed());
        car.gas(1);
        assertEquals(2.5, car.getCurrentSpeed());
        try {
            car.gas(1.5);
            assertEquals(1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals(1, 1);
        }
        double firstSpeed = car.getCurrentSpeed();
        car.gas(0.5);
        assertTrue(firstSpeed < car.getCurrentSpeed());

    }

    @Test
    void brake() {
        car.gas(1);
        car.brake(1);
        assertEquals(0, car.getCurrentSpeed());
        try {
            car.gas(0.5);
            car.brake(1.5);
            assertEquals(1,2);
        } catch (IllegalArgumentException e){
            assertEquals(2,2); // detta är bs men ska finnas för att det ska fungera så tänk inte för mycket på siffrorna
            //Det går även att lägga till så att den inte får minska mer än den gasat men orkar ej lol.
        }
        double firstSpeed = car.getCurrentSpeed();
        car.brake(0.5);
        assertTrue(firstSpeed > car.getCurrentSpeed());

    }
}
