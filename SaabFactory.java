public class SaabFactory implements CarFactory{
    CarModel model;
    Saab95 saab = new Saab95();
    public SaabFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        model.addCar(saab);
        System.out.println("car created");
    }
}
