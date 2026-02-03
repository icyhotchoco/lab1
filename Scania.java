import java.awt.*;

public class Scania extends Car {
    int angle = 0;
    public Scania() {
        super(2, 200, 0, Color.YELLOW, "Scania");
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void gas(double amount) {
        if (amount > 1 || amount < 0 || angle > 0) {
            throw new IllegalArgumentException("Value needs to be between 0 and 1");
        }
        incrementSpeed(amount);
    }
    public void platformRaise() {
        if (currentSpeed > 0) {
            throw new IllegalArgumentException();
        }
        angle = Math.min(angle + 10,70);
    }
    public void platformLower() {
        if (currentSpeed > 0) {
            throw new IllegalArgumentException();
        }
        angle = Math.max(angle - 10,0);
    }
}

