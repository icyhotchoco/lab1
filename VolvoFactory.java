public class VolvoFactory implements CarFactory{
    @Override
    public Volvo240 createCar() {
        return new Volvo240();
    }
}
