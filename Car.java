import java.awt.*;

public abstract class Car implements Movable{
    private double xPos = 0;
    private double yPos = 0;
    private int directionDeg = 0;
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public Car( int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }
    public double getY() {
        return this.yPos;
    }
    public double getX() {
        return this.xPos;
    }
    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }
    public int getDirectionDeg(){
        return this.directionDeg;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor(); // en abstrakt metod som kan anropa i andra klasser med @Override

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount) {
        if (amount > 1 || amount < 0) {
            throw new IllegalArgumentException("Value needs to be between 0 and 1");
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount > 1 || amount < 0) {
            throw new IllegalArgumentException("Value needs to be between 0 and 1");
        }
        decrementSpeed(amount);
    }

    @Override
    public void turnLeft() {
        directionDeg -=90 ;
        directionDeg = (directionDeg % 360 + 360) % 360;
    }

    @Override
    public void turnRight() {
        directionDeg += 90;
        directionDeg = (directionDeg % 360 + 360) % 360;
    }

    @Override
    public void move() {
        if (directionDeg == 90) {
            xPos += currentSpeed;
        } else if (directionDeg == 0) {
            yPos += currentSpeed;
        } else if (directionDeg == 270) {
            xPos -= currentSpeed;
        } else if (directionDeg == 180) {
            yPos -= currentSpeed;
        }
    }
}
