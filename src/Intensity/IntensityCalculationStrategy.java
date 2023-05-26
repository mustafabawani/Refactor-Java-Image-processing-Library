package Intensity;

import imageFX.MyImage;

public interface IntensityCalculationStrategy {
    int calculateIntensity(MyImage img, int x,int y);
}
