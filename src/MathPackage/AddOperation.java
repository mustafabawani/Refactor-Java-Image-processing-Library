package MathPackage;
import imageFX.MyImage;

public class AddOperation implements ImageOperation{
    public void apply(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = sourceImg1.getRed(x, y) + sourceImg2.getRed(x, y);
                int green = sourceImg1.getGreen(x, y) + sourceImg2.getGreen(x, y);
                int blue = sourceImg1.getBlue(x, y) + sourceImg2.getBlue(x, y);

                resultImg.setPixel(x, y, 255, clamp(red), clamp(green), clamp(blue));
            }
        }

    }
    private int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }
}
