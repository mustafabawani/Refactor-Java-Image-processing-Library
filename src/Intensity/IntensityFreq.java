package Intensity;

import imageFX.MyImage;

public class IntensityFreq {
    public static int getMaxIntensity(MyImage img, IntensityCalculationStrategy intensityCalculationStrategy) {
        int[] intensityFreq = new int[256];
        int maxFreq = 0;
        int maxIntensity = 0;

        // Image dimension
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        // Get intensity
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                intensityFreq[intensityCalculationStrategy.calculateIntensity(img, x, y)]++;
            }
        }

        // Search max intensity
        for (int i = 0; i < 256; i++) {
            if (intensityFreq[i] > maxFreq) {
                maxIntensity = i;
                maxFreq = intensityFreq[i];
            }
        }

        return maxIntensity;
    }

    public static int getMinIntensity(MyImage img, IntensityCalculationStrategy intensityCalculationStrategy) {
        int[] intensityFreq = new int[256];
        int minFreq;
        int minIntensity;

        // Image dimension
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        // Get intensity
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                intensityFreq[intensityCalculationStrategy.calculateIntensity(img, x, y)]++;
            }
        }

        // Min intensity
        minFreq = width * height + 1;
        minIntensity = 0;

        // Search min intensity
        for (int i = 0; i < 256; i++) {
            if (intensityFreq[i] < minFreq && intensityFreq[i] > 0) {
                minIntensity = i;
                minFreq = intensityFreq[i];
            }
        }

        return minIntensity;
    }

    public static int[] getColorMaxIntensity(MyImage img) {
        IntensityCalculationStrategy redStrategy = IntensityCalculationStrategyFactory.createStrategy("red");
        IntensityCalculationStrategy greenStrategy = IntensityCalculationStrategyFactory.createStrategy("green");
        IntensityCalculationStrategy blueStrategy = IntensityCalculationStrategyFactory.createStrategy("blue");

        int redMax = getMaxIntensity(img, redStrategy);
        int greenMax = getMaxIntensity(img, greenStrategy);
        int blueMax = getMaxIntensity(img, blueStrategy);

        return new int[]{redMax, greenMax, blueMax};
    }

    public static int[] getColorMinIntensity(MyImage img) {
        IntensityCalculationStrategy redStrategy = IntensityCalculationStrategyFactory.createStrategy("red");
        IntensityCalculationStrategy greenStrategy = IntensityCalculationStrategyFactory.createStrategy("green");
        IntensityCalculationStrategy blueStrategy = IntensityCalculationStrategyFactory.createStrategy("blue");

        int redMin = getMinIntensity(img, redStrategy);
        int greenMin = getMinIntensity(img, greenStrategy);
        int blueMin = getMinIntensity(img, blueStrategy);

        return new int[]{redMin, greenMin, blueMin};
    }
}
