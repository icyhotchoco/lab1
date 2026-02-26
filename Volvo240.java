import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100,0, Color.black,"Volvo240", 1.4);
    }
    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
