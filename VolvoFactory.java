public class VolvoFactory implements CarFactory{
    CarModel model;
    Volvo240 volvo = new Volvo240();
    public VolvoFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        model.addCar(volvo);
    }
}
