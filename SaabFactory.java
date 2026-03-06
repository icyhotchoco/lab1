public class SaabFactory implements CarFactory{
    CarModel model;
    Saab95 saab = new Saab95();

    @Override
    public void createCar() {
        model.addCar(saab);
    }
}
