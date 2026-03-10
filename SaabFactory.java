public class SaabFactory implements CarFactory{
    CarModel model;
    public SaabFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() { model.addCar(new Saab95()); }
}
