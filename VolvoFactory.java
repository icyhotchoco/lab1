public class VolvoFactory implements CarFactory{
    CarModel model;
    public VolvoFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        model.addCar(new Volvo240());
    }
}
