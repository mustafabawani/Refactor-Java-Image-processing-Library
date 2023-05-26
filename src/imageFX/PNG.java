package imageFX;

import java.awt.image.BufferedImage;

public class PNG implements FileOperations {
    public BufferedImage updateImageObject(int width,int height)
    {
        return (new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
    }
}
