public class ScaniaFactory implements CarFactory {
    CarModel model;
    public ScaniaFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        model.addCar(new Scania());
    }
}
