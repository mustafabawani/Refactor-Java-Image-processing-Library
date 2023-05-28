package imageFX;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileWriter {
    private String filePath;

    public FileWriter(String filePath) {
        this.filePath=filePath;
    }
    public void writeFile(BufferedImage image,String fileType) {
        try {
            File file = new File(filePath);
            ImageIO.write(image, fileType, file);
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
