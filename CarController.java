import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarController {
    CarView view;
    CarModel model;

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Raise Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addVolvoButton = new JButton("Add a Volvo");
    JButton addSaabButton = new JButton("Add a Saab");
    JButton addScaniaButton = new JButton("Add a Scania");
    JButton removeCarButton = new JButton("Remove last added Car");
    JButton addRandomCarButton = new JButton("Add a random Car");

    public CarController(CarView view, CarModel model) {
        this.view = view;
        this.model = model;

        view.addButton(gasButton, 0);
        view.addButton(turboOnButton, 1);
        view.addButton(liftBedButton, 2);
        view.addButton(brakeButton, 3);
        view.addButton(turboOffButton, 4);
        view.addButton(lowerBedButton, 5);
        view.addButton(addVolvoButton, 6);
        view.addButton(addSaabButton, 7);
        view.addButton(addScaniaButton, 8);
        view.addButton(addRandomCarButton, 9);
        view.addButton(removeCarButton, 10);

        startButton.setBackground(new Color(80, 168, 6));
        startButton.setForeground(Color.white);
        startButton.setPreferredSize(new Dimension(view.getX()/5-15,200));
        view.add(startButton);

        stopButton.setBackground(new Color(169, 13, 6));
        stopButton.setForeground(Color.white);
        stopButton.setPreferredSize(new Dimension(view.getX()/5-15,200));
        view.add(stopButton);

        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.startCars();}
        });
        stopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.stopCars(); }
        });
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { model.gas(view.getGasAmount()); }
        });
        brakeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.brake(view.getGasAmount()); }
        });
        turboOnButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.turboOn(); }
        });
        turboOffButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.turboOff(); }
        });
        liftBedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.raisePlatform(); }
        });
        lowerBedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.lowerPlatform(); }
        });
        addVolvoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.addVolvo();}
        });
        addSaabButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.addSaab(); }
        });
        addScaniaButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.addScania();}
        });
        addRandomCarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.addRandomCar(); }
        });
        removeCarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) { model.removeCar(); }
        });
    }

}
