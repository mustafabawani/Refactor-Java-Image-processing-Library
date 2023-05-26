package Intensity;

import imageFX.MyImage;

public class GrayscaleIntensityCalculationStrategy implements IntensityCalculationStrategy {
    @Override
    public int calculateIntensity(MyImage img, int x, int y) {
        return img.getRed(x, y); // Assuming grayscale image uses red channel for intensity
    }
}