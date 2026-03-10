public class SaabFactory implements CarFactory{
    CarModel model;
    public SaabFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        Saab95 saab = new Saab95();
        model.addCar(saab);
        saab.setY(100);
    }
}
