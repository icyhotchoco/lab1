import java.awt.*;

public class Truck extends Car{
    private Ramp ramp;
    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double weight, Ramp ramp) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, weight);
        this.ramp = ramp;
    }
    public int getAngle() { return ramp.getAngle(); }
    public boolean isUndrivable() { return ramp.isUndrivable(); }
    public void raisePlatform() { ramp.raisePlatform(this.currentSpeed);}
    public void lowerPlatform() { ramp.lowerPlatform(this.currentSpeed);}

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }
    @Override
    public void gas(double amount) {
        if (ramp.isUndrivable()) {
            throw new IllegalArgumentException();
        }
        super.gas(amount); //gets access to the whole gas method in the superclass
    }
}
