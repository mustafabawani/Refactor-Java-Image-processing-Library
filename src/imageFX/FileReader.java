package imageFX;

import java.awt.image.BufferedImage;

public class FileReader {
    public FileOperations type;

    public FileReader(MyImage.ImageType imgType) {
        if(ImageType.PNG==imgType)
        {
            type=new PNG();
        }
        else
        {
            type=new JPG();
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
