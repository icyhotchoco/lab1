public class VolvoFactory implements CarFactory{
    CarModel model;
    public VolvoFactory(CarModel model) {
        this.model = model;
    }
    @Override
    public void createCar() {
        Volvo240 volvo = new Volvo240();
        model.addCar(volvo);
        volvo.setY(0);
    }
}
