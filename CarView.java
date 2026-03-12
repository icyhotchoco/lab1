import javax.swing.*;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    CarModel model;
    private static final int X = 1000;
    private static final int Y = 700;
    int gasAmount = 0;

    DrawPanel drawPanel = new DrawPanel(X, Y-300, model);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    // Constructor
    public CarView(String framename, CarModel model) {
        this.model = model;
        initComponents(framename);
        model.addObserver(drawPanel);
    }
    public void addButton(JButton b, int i) {
        controlPanel.add(b, i);
        this.repaint();
    }
    public int getGasAmount() { return gasAmount; }
    public int getX() { return X; }
    public int getY() { return Y;}

    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout());
        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);


        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setLayout(new GridLayout(4,3));
        this.add(controlPanel);
        controlPanel.setBackground(new Color(172, 174, 209));

        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}