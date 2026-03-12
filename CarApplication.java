
public class CarApplication {
    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarView view = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(view,model);
        model.addVolvo();
        model.addSaab();
        model.addScania();
        model.initializeGarage();

        // Start the timer
        model.timer.start();
    }
}
