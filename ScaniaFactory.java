public class ScaniaFactory implements CarFactory {
    CarModel model;
    Scania scania = new Scania();
    public ScaniaFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        model.addCar(scania);
    }
}
