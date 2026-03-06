public class ScaniaFactory implements CarFactory {
    CarModel model;
    Scania scania = new Scania();

    @Override
    public void addCar() {
        model.addCar(scania);
    }

    @Override
    public Car removeCar() {
        model.removeCar(scania);
        return scania;
    }
}
