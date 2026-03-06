public class VolvoFactory implements CarFactory{
    CarModel model;
    Volvo240 volvo = new Volvo240();
    @Override
    public void addCar() {
        model.addCar(volvo);
    }

    @Override
    public Car removeCar() {
        model.removeCar(volvo);
        return volvo;
    }
}
