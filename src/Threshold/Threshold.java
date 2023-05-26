package Threshold;

import imageFX.MyImage;

public class Threshold {

    public static void averageOfRGBValue(MyImage img, int thresholdValue) {
        applyThreshold(img, thresholdValue, (r, g, b) -> (r + g + b) / 3);
    }

    public static void toBinary(MyImage img, int thresholdValue) {
        applyThreshold(img, thresholdValue, (r, g, b) -> (int) (0.2126 * r + 0.7152 * g + 0.0722 * b));
    }

    public static void redPixel(MyImage img, int thresholdValue) {
        applyThreshold(img, thresholdValue, (r, g, b) -> r);
    }

    public static void greenPixel(MyImage img, int thresholdValue) {
        applyThreshold(img, thresholdValue, (r, g, b) -> g);
    }

    public static void bluePixel(MyImage img, int thresholdValue) {
        applyThreshold(img, thresholdValue, (r, g, b) -> b);
    }

    public static void autoThreshold(MyImage img) {
        applyAutoThreshold(img, (r, g, b) -> (r + g + b) / 3);
    }

    public static void autoThreshold_usingRedValueOfPixels(MyImage img) {
        applyAutoThreshold(img, (r, g, b) -> r);
    }

    public static void autoThreshold_usingGreenValueOfPixels(MyImage img) {
        applyAutoThreshold(img, (r, g, b) -> g);
    }

    public static void autoThreshold_usingBlueValueOfPixels(MyImage img) {
        applyAutoThreshold(img, (r, g, b) -> b);
    }

    public static void adaptiveThreshold_Mean(MyImage img, int maskSize, int C) {
        applyAdaptiveThreshold(img, maskSize, C, true);
    }

    public static void adaptiveThreshold_Median(MyImage img, int maskSize, int C) {
        applyAdaptiveThreshold(img, maskSize, C, false);
    }

    public static void adaptiveThreshold_MaxMin(MyImage img, int maskSize, int C) {
        applyAdaptiveThreshold(img, maskSize, C, true);
    }

    private static void applyThreshold(MyImage img, int thresholdValue, RGBOperation operation) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int r = img.getRed(x, y);
                int g = img.getGreen(x, y);
                int b = img.getBlue(x, y);
                int avg = operation.apply(r, g, b);

                if (avg >= thresholdValue) {
                    img.setPixel(x, y, 255, 255, 255, 255);  // set WHITE
                } else {
                    img.setPixel(x, y, 255, 0, 0, 0);  // set BLACK
                }
            }
        }
    }

    private static void applyAutoThreshold(MyImage img, RGBOperation operation) {
        int thresholdValue = 128;

        while (true) {
            long sum1 = 0;
            long sum2 = 0;
            int count1 = 0;
            int count2 = 0;

            for (int y = 0; y < img.getImageHeight(); y++) {
                for (int x = 0; x < img.getImageWidth(); x++) {
                    int r = img.getRed(x, y);
                    int g = img.getGreen(x, y);
                    int b = img.getBlue(x, y);
                    int avg = operation.apply(r, g, b);

                    if (avg >= thresholdValue) {
                        sum1 += avg;
                        count1++;
                    } else {
                        sum2 += avg;
                        count2++;
                    }
                }
            }

            int mean1 = (count1 > 0) ? (int) (sum1 / count1) : 0;
            int mean2 = (count2 > 0) ? (int) (sum2 / count2) : 0;
            int newThresholdValue = (mean1 + mean2) / 2;

            if (newThresholdValue == thresholdValue)
                break;

            thresholdValue = newThresholdValue;
        }

        applyThreshold(img, thresholdValue, operation);
    }

    private static void applyAdaptiveThreshold(MyImage img, int maskSize, int C, boolean useMean) {
        int halfMaskSize = maskSize / 2;

        for (int y = halfMaskSize; y < img.getImageHeight() - halfMaskSize; y++) {
            for (int x = halfMaskSize; x < img.getImageWidth() - halfMaskSize; x++) {
                int sum = 0;
                int count = 0;

                for (int j = -halfMaskSize; j <= halfMaskSize; j++) {
                    for (int i = -halfMaskSize; i <= halfMaskSize; i++) {
                        int r = img.getRed(x + i, y + j);
                        int g = img.getGreen(x + i, y + j);
                        int b = img.getBlue(x + i, y + j);
                        int pixelValue = useMean ? (r + g + b) / 3 : img.getMedian(x + i, y + j);
                        sum += pixelValue;
                        count++;
                    }
                }

                int avg = sum / count;
                int thresholdValue = avg - C;
                int pixelValue = useMean ? (img.getRed(x, y) + img.getGreen(x, y) + img.getBlue(x, y)) / 3 : img.getMedian(x, y);

                if (pixelValue >= thresholdValue) {
                    img.setPixel(x, y, 255, 255, 255, 255);  // set WHITE
                } else {
                    img.setPixel(x, y, 255, 0, 0, 0);  // set BLACK
                }
            }
        }
    }

    private interface RGBOperation {
        int apply(int r, int g, int b);
    }
}
