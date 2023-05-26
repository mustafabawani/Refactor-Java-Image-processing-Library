package Intensity;

import imageFX.MyImage;

public class Intensity {
    /**
     * This will return the maximum intensity of the given image img using the specified intensity calculation strategy.
     *
     * @param img      The image.
     * @param strategy The intensity calculation strategy.
     * @return maximum intensity.
     */
    public static int getMaxIntensity(MyImage img, IntensityCalculationStrategy strategy) {
        int maxIntensity = 0;

        // Image dimension
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int intensity = strategy.calculateIntensity(img, x, y);
                if (intensity > maxIntensity) {
                    maxIntensity = intensity;
                }
            }
        }
        return maxIntensity;
    }

    /**
     * This will return the minimum intensity of the given image img using the specified intensity calculation strategy.
     *
     * @param img      The image.
     * @param strategy The intensity calculation strategy.
     * @return minimum intensity.
     */
    public static int getMinIntensity(MyImage img, IntensityCalculationStrategy strategy) {
        int minIntensity = 255;

        // Image dimension
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int intensity = strategy.calculateIntensity(img, x, y);
                if (intensity < minIntensity) {
                    minIntensity = intensity;
                }
            }
        }
        return minIntensity;
    }

    /**
     * This will return the maximum intensity values for each RGB channel in the given color image img.
     *
     * @param img The color image.
     * @return maximum intensity array having 3 elements for RGB.
     */
    public static int[] getColorMaxIntensity(MyImage img) {
        IntensityCalculationStrategy redStrategy = IntensityCalculationStrategyFactory.createStrategy("red");
        IntensityCalculationStrategy greenStrategy = IntensityCalculationStrategyFactory.createStrategy("green");
        IntensityCalculationStrategy blueStrategy = IntensityCalculationStrategyFactory.createStrategy("blue");

        int[] maxIntensity = new int[3];
        maxIntensity[0] = getMaxIntensity(img, redStrategy);
        maxIntensity[1] = getMaxIntensity(img, greenStrategy);
        maxIntensity[2] = getMaxIntensity(img, blueStrategy);
        return maxIntensity;
    }

    /**
     * This will return the minimum intensity values for each RGB channel in the given color image img.
     *
     * @param img The color image.
     * @return minimum intensity array having 3 elements for RGB.
     */
    public static int[] getColorMinIntensity(MyImage img) {
        IntensityCalculationStrategy redStrategy = IntensityCalculationStrategyFactory.createStrategy("red");
        IntensityCalculationStrategy greenStrategy = IntensityCalculationStrategyFactory.createStrategy("green");
        IntensityCalculationStrategy blueStrategy = IntensityCalculationStrategyFactory.createStrategy("blue");

        int[] minIntensity = new int[3];
        minIntensity[0] = getMinIntensity(img, redStrategy);
        minIntensity[1] = getMinIntensity(img, greenStrategy);
        minIntensity[2] = getMinIntensity(img, blueStrategy);
        return minIntensity;
    }
}