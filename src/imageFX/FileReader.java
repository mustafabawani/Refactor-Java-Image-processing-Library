package imageFX;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {
    public FileOperations type;
    private String filePath;

    public FileReader(String filePath) {
//        if(ImageType.PNG==imgType)
//        {
//            type=new PNG();
//        }
//        else
//        {
//            type=new JPG();
//        }
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

    private enum ImageType{
        JPG, PNG
    };
    public BufferedImage updateImageObject(int width, int height)
    {
        return (type.updateImageObject(width,height));
    }

}
