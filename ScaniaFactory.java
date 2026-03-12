public class ScaniaFactory implements CarFactory {
    @Override
    public Scania createCar() {
        return new Scania();
    }
}
