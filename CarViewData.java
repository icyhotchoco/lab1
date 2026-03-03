public class CarViewData {
    private final int x;
    private final int y;
    private final String name;

    public CarViewData(double x, double y, String name) {
        this.x = (int) x;
        this.y = (int) y;
        this.name = name;
    }
    public String getName() { return this.name; }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
}
