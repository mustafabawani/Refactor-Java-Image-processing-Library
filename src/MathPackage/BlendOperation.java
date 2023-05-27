package MathPackage;

import imageFX.MyImage;

public class BlendOperation implements  ImageOperation{
    private float blendRatio;

    public BlendOperation(float blendRatio) {
        this.blendRatio = blendRatio;
    }

    @Override
    public void apply(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = (int) ((blendRatio * sourceImg1.getRed(x, y)) + ((1 - blendRatio) * sourceImg2.getRed(x, y)));
                int green = (int) ((blendRatio * sourceImg1.getGreen(x, y)) + ((1 - blendRatio) * sourceImg2.getGreen(x, y)));
                int blue = (int) ((blendRatio * sourceImg1.getBlue(x, y)) + ((1 - blendRatio) * sourceImg2.getBlue(x, y)));

                resultImg.setPixel(x, y, 255, clamp(red), clamp(green), clamp(blue));
            }
        }

    }
    private int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }
}
