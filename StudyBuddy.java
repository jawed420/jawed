import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class StudyBuddy extends JFrame {

    BufferedImage backgroundImage;

    public StudyBuddy() {
        setTitle("Thank You");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        try {
            backgroundImage = ImageIO.read(new File("watermark.png")); // Add your image here
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }


        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                if (backgroundImage != null) {
                    int x = (getWidth() - backgroundImage.getWidth()) / 2;
                    int y = (getHeight() - backgroundImage.getHeight()) / 2;
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f)); // 20% opacity
                    g2d.drawImage(backgroundImage, x, y, null);
                }
            }
        };
        panel.setLayout(new BorderLayout());

        JLabel thankYouLabel = new JLabel("Thank You!", JLabel.CENTER);
        thankYouLabel.setFont(new Font("Serif", Font.BOLD, 36));
        thankYouLabel.setForeground(new Color(0, 102, 204)); // Soft blue

        panel.add(thankYouLabel, BorderLayout.CENTER);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudyBuddy();
    }
}
