public class Ramp {
    private int angle = 0;
    private int maxAngle;

    public Ramp(int maxAngle){
        this.maxAngle = maxAngle;
    }
    public int getMaxAngle() { return maxAngle; }
    public int getAngle() {
        return angle;
    }

    public void raisePlatform(double currentSpeed) {
        if (currentSpeed > 0) {
            throw new IllegalArgumentException();
        }
        angle = Math.min(angle + 1,maxAngle);
    }
    public void lowerPlatform(double currentSpeed) {
        if (currentSpeed > 0) {
            throw new IllegalArgumentException();
        }
        angle = Math.max(angle - 1,0);
    }
    public boolean isUndrivable() {
        return (angle != 0);
    }
}
