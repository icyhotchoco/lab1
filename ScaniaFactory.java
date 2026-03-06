public class ScaniaFactory implements CarFactory {
    CarModel model;
    Scania scania = new Scania();

    @Override
    public void createCar() {
        model.addCar(scania);
    }
}
