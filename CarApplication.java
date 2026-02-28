
public class CarApplication {
    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarView view = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(view,model);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        Scania scania = new Scania();
        saab95.setY(100.0);
        scania.setY(200.0);
        // Add a volvo to list of cars
        model.addCar(volvo240);
        model.addCar(saab95);
        model.addCar(scania);

        // Start a new view and send a reference of self
        //cc.view = new CarView("CarSim 1.0", model);

        // Start the timer
        cc.timer.start();
    }
}
