import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car carS = new Saab95();
    private Car carV = new Volvo240();

    @Test
    void turnLeft() {
        carS.turnLeft();
        assertEquals(270, carS.getDirectionDeg());
        carV.turnLeft();
        assertEquals(270, carV.getDirectionDeg());
    }

    @Test
    void turnRight() {
        carS.turnRight();
        assertEquals(90, carS.getDirectionDeg());
        carV.turnRight();
        assertEquals(90, carV.getDirectionDeg());
    }

    @Test
    void move() {
        carS.move();
        assertEquals(carS.getCurrentSpeed(), carS.getY());
        carS.turnRight();
        carS.move();
        assertEquals(carS.getCurrentSpeed(), carS.getX());
        carS.turnRight();
        carS.move();
        assertEquals(carS.getCurrentSpeed(), carS.getY());
        carS.turnRight();
        carS.move();
        assertEquals(carS.getCurrentSpeed(), carS.getX());

        carV.move();
        assertEquals(carV.getCurrentSpeed(), carV.getY());
        carV.turnRight();
        carV.move();
        assertEquals(carV.getCurrentSpeed(), carV.getX());
        carV.turnRight();
        carV.move();
        assertEquals(carV.getCurrentSpeed(), carV.getY());
        carV.turnRight();
        carV.move();
        assertEquals(carV.getCurrentSpeed(), carV.getX());
    }

    @Test
    public void gas() {
        carS.gas(1);
        assertEquals(1.25, carS.getCurrentSpeed());
        carS.gas(1);
        assertEquals(2.5, carS.getCurrentSpeed());
        try {
            carS.gas(1.5);
            assertEquals(1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals(1, 1);
        }
        double firstSpeed = carS.getCurrentSpeed();
        carS.gas(0.5);
        assertTrue(firstSpeed < carS.getCurrentSpeed());

        carV.gas(1);
        assertEquals(1.25, carV.getCurrentSpeed());
        carV.gas(1);
        assertEquals(2.5, carV.getCurrentSpeed());
        try {
            carV.gas(1.5);
            assertEquals(1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals(1, 1);
        }
        double firstSpeedV = carV.getCurrentSpeed();
        carV.gas(0.5);
        assertTrue(firstSpeedV < carV.getCurrentSpeed());
    }

    @Test
    void brake() {
        carS.gas(1);
        carS.brake(1);
        assertEquals(0, carS.getCurrentSpeed());
        try {
            carS.gas(0.5);
            carS.brake(1.5);
            assertEquals(1,2);
        } catch (IllegalArgumentException e){
            assertEquals(2,2);
        }
        double firstSpeed = carS.getCurrentSpeed();
        carS.brake(0.5);
        assertTrue(firstSpeed > carS.getCurrentSpeed());

        carV.gas(1);
        carV.brake(1);
        assertEquals(0, carS.getCurrentSpeed());
        try {
            carV.gas(0.5);
            carV.brake(1.5);
            assertEquals(1,2);
        } catch (IllegalArgumentException e){
            assertEquals(2,2);
        }
        double firstSpeedV = carV.getCurrentSpeed();
        carV.brake(0.5);
        assertTrue(firstSpeedV > carV.getCurrentSpeed());
    }
}
