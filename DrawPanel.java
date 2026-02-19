import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage background;
    // To keep track of a single car's position
    Point volvoPoint = new Point();
    boolean isInGarage = false;
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    BufferedImage carWorkshopImage;
    Point carWorkshopPoint = new Point(300,0);

    // TODO: Make this general for all cars

    void volvomoveit(int x, int y) { // behöver generaliseras bättre
        volvoPoint.x = x;
        volvoPoint.y = y;
    }
    void saabmoveit(int x, int y) {
        saabPoint.x = x;
        saabPoint.y = y;
    }
    void scaniamoveit(int x, int y) {
        scaniaPoint.x = x;
        scaniaPoint.y = y;

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //carImage = ImageIO.read(new File("pictures/volvo.png"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/Saab95.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/Volvo240.jpg"));
            carWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/VolvoBrand.jpg"));
            background = ImageIO.read(DrawPanel.class.getResourceAsStream("pictures/14104_113697.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background,0,0,null);
        if (!isInGarage) {
            g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        }
        g.drawImage(saabImage, saabPoint.x, (saabPoint.y + 100), null);
        g.drawImage(scaniaImage, scaniaPoint.x, (scaniaPoint.y + 200), null);
        g.drawImage(carWorkshopImage, carWorkshopPoint.x, carWorkshopPoint.y, null);
    }
}
