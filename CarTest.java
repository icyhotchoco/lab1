import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private final Car saab95 = new Saab95();
    private final Truck scania = new Scania();
    private final TransportCar transport = new TransportCar();

    @Test
    void platform() {
        scania.raisePlatform();
        assertEquals(1, scania.getAngle());
        scania.lowerPlatform();
        assertEquals(0, scania.getAngle());
    }
    @Test
    void addCar() { //funkar inte
        transport.addCar(saab95);
        assertEquals(saab95.getY(), transport.getY());
        assertEquals(saab95.getX(), transport.getX());
    }
    @Test
    void removeCar() { // funkar inte
        transport.removeCar();
        assertTrue(saab95.getY() != transport.getY());
    }
    @Test
    void turnLeft() {
        saab95.turnLeft();
        assertEquals(270, saab95.getDirectionDeg());
    }
    @Test
    void turnRight() {
        saab95.turnRight();
        assertEquals(90, saab95.getDirectionDeg());
    }

    @Test
    void move() {
        saab95.move();
        assertEquals(saab95.getCurrentSpeed(), saab95.getY());
        saab95.turnRight();
        saab95.move();
        assertEquals(saab95.getCurrentSpeed(), saab95.getX());
        saab95.turnRight();
        saab95.move();
        assertEquals(saab95.getCurrentSpeed(), saab95.getY());
        saab95.turnRight();
        saab95.move();
        assertEquals(saab95.getCurrentSpeed(), saab95.getX());
    }

    @Test
    public void gas() {
        saab95.gas(1);
        assertEquals(1.25, saab95.getCurrentSpeed());
        saab95.gas(1);
        assertEquals(2.5, saab95.getCurrentSpeed());
        try {
            saab95.gas(1.5);
            assertEquals(1, 2);
        } catch (IllegalArgumentException e) {
            assertEquals(1, 1);
        }
        double firstSpeed = saab95.getCurrentSpeed();
        saab95.gas(0.5);
        assertTrue(firstSpeed < saab95.getCurrentSpeed());
    }

    @Test
    void brake() {
        saab95.gas(1);
        saab95.brake(1);
        assertEquals(0, saab95.getCurrentSpeed());
        try {
            saab95.gas(0.5);
            saab95.brake(1.5);
            assertEquals(1,2);
        } catch (IllegalArgumentException e){
            assertEquals(2,2);
        }
        double firstSpeed = saab95.getCurrentSpeed();
        saab95.brake(0.5);
        assertTrue(firstSpeed > saab95.getCurrentSpeed());
    }
}
