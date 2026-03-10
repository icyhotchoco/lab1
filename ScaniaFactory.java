public class ScaniaFactory implements CarFactory {
    CarModel model;
    public ScaniaFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        Scania scania = new Scania();
        model.addCar(scania);
        scania.setY(200);
    }
}
