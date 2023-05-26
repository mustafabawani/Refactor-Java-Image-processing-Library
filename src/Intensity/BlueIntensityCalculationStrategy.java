package Intensity;

import imageFX.MyImage;

public class BlueIntensityCalculationStrategy implements IntensityCalculationStrategy {
    @Override
    public int calculateIntensity(MyImage img, int x, int y) {
        return img.getBlue(x, y);
    }
}