import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    CarModel model;
    private BufferedImage background;
    private BufferedImage carWorkshopImage;
    private HashMap<String, BufferedImage> carImages = new HashMap<>();

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
            carWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/VolvoBrand.png"));
            background = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/14104_113697.jpg"));
            carImages.put("Volvo240", volvoImage);
            carImages.put("Saab95", saabImage);
            carImages.put("Scania", scaniaImage);
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
        for (CarViewData car : model.position.values()) {
            g.drawImage(carImages.get(car.getName()), car.getX(), car.getY(), null);
        }
        g.drawImage(carWorkshopImage, model.getCarWorkshopPoint().x, model.getCarWorkshopPoint().y, null);
    }
}
