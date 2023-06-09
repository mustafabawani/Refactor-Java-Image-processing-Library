package imageFX;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {

    private String filePath;

    public FileReader(String filePath) {
        this.filePath=filePath;
    }

    public BufferedImage ReadFile(BufferedImage image)
    {
        try {
            File file = new File(filePath);
            image = ImageIO.read(file);

            return image;
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        }
    }



}
