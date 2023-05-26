package Intensity;

import imageFX.MyImage;

public class RedIntensityCalculationStrategy  implements IntensityCalculationStrategy {
    @Override
    public int calculateIntensity(MyImage img, int x, int y) {
        return img.getRed(x, y);
    }
}
