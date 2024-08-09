import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static int[][] get2DPixelArraySlow(BufferedImage sampleImage, Graphics2D g) {
        int width = sampleImage.getWidth();
        int height = sampleImage.getHeight();
        int[][] result = new int[height][width];
        g.setColor(Color.blue);
        int counter = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row][col] = sampleImage.getRGB(col, row);
                System.out.println(result[row][col]);

                /*
                if (result[row][col] == -16777216) {
                    g.drawRect(col,row,1, 1);
                    counter += 1;
                }

                 */


            }
        }

        System.out.println(counter);
        return result;
    }


    public static void main(String[] args) throws IOException {
        String imagePath = "Resources/Image.png";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g = (Graphics2D) myPicture.getGraphics();

        // Draw map
        int[][] result = get2DPixelArraySlow(myPicture, g);

        //System.out.println(Arrays.deepToString(result));

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