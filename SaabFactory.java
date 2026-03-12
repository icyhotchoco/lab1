public class SaabFactory implements CarFactory{
    @Override
    public Saab95 createCar() {
        return new Saab95();
    }
}
