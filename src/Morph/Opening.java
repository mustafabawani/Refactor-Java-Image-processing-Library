package Morph;
import imageFX.MyImage;
public class Opening {
    public static void binaryImage(MyImage img, boolean erodeBlackPixel, boolean dilateBlackPixel){
        Erosion.binaryImage(img, erodeBlackPixel);
        Dilation.binaryImage(img, dilateBlackPixel);
    }
}
