import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer {

    CarModel model;
    private BufferedImage background;
    private HashMap<String, BufferedImage> objectImages = new HashMap<>();
    private HashMap<Integer, CarViewData> position = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            BufferedImage scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/Scania.png"));
            BufferedImage saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/Saab95.png"));
            BufferedImage volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/Volvo240.png"));
            BufferedImage carWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/VolvoBrand.png"));
            background = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/14104_113697.jpg"));
            objectImages.put("Volvo240", volvoImage);
            objectImages.put("Saab95", saabImage);
            objectImages.put("Scania", scaniaImage);
            objectImages.put("Volvo Garage", carWorkshopImage);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        for (CarViewData object : position.values()) {
            g.drawImage(objectImages.get(object.getName()), object.getX(), object.getY(), null);
        }
    }
    @Override
    public void place(Integer key, CarViewData carViewData) {
        this.position.put(key, carViewData);
    }

    @Override
    public void remove(Integer key) {
        this.position.remove(key);
    }

    @Override
    public void refresh() {
        this.repaint();
    }
}
