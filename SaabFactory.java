public class SaabFactory implements CarFactory{
    CarModel model;
    Saab95 saab = new Saab95();
    @Override
    public void addCar() {
        model.addCar(saab);
    }

    @Override
    public Car removeCar() {
        model.removeCar(saab);
        return saab;
    }
}
