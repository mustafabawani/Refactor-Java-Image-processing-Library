package Intensity;

import imageFX.MyImage;

public class GreenIntensityCalculationStrategy implements IntensityCalculationStrategy {
    @Override
    public int calculateIntensity(MyImage img, int x, int y) {
        return img.getGreen(x, y);
    }
}
