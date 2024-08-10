import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void get2DPixelArray(BufferedImage sampleImage, Graphics2D g) throws IOException {
        int width = sampleImage.getWidth();
        int height = sampleImage.getHeight();
        int[][] result = new int[height][width];
        FileWriter writer = new FileWriter("C:\\Users\\dylan\\IdeaProjects\\Places I have been - Data visualisation\\src\\Coordinates.txt");
        writer.write("");
        g.setColor(Color.blue);

        // For black map
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                if (result[row][col] == -16777216) {
                    g.drawRect(col, row, 1, 1);
                }
                if (result[row][col] == -7864299) {
                    g.drawRect(col, row, 1, 1);
                }

                result[row][col] = sampleImage.getRGB(col, row);

                String hexColor = String.format("#%06X", (0xFFFFFF & result[row][col]));

                //write coordinates to text file of pixels
                writer.append(hexColor);
                writer.append("\n");

            }
        }
        writer.close();
    }


    public static void main(String[] args) throws IOException {
        String imagePath = "Resources/worldMap.png";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g = (Graphics2D) myPicture.getGraphics();

        // Draw map
        get2DPixelArray(myPicture, g);

        // Show the image on screen
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);




    }
}