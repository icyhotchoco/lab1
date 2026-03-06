public class VolvoFactory implements CarFactory{
    CarModel model;
    Volvo240 volvo = new Volvo240();

    @Override
    public void createCar() {
        model.addCar(volvo);
    }
}
