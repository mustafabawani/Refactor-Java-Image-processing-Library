package imageFX;

import java.awt.image.BufferedImage;

public class ImageFX {

    public static int getAlphaValueFromPixelValue(int pixelVal) {
        return (pixelVal >> 24) & 0xFF;
    }

    public static int getRedValueFromPixelValue(int pixelVal) {
        return (pixelVal >> 16) & 0xFF;
    }

    public static int getGreenValueFromPixelValue(int pixelVal) {
        return (pixelVal >> 8) & 0xFF;
    }

    public static int getBlueValueFromPixelValue(int pixelVal) {
        return pixelVal & 0xFF;
    }

    public static int getPixelValueFromARGBValue(int a, int r, int g, int b) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public static void HSI_createHSIImage(MyImage img) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int a = img.getAlpha(x, y);
                int h = (int) (img.HSI_getHue(x, y) * 255 / 359);
                int s = (int) (img.HSI_getSaturation(x, y) * 255);
                int i = (int) (img.HSI_getIntensity(x, y) * 255);
                img.setPixel(x, y, a, h, s, i);
            }
        }
    }

    public static void HSI_changeImageHue(MyImage img, double hue) {
        applyHSIChange(img, (x, y) -> img.HSI_setHue(x, y, hue));
    }

    public static void HSI_changeImageSaturation(MyImage img, double saturation) {
        applyHSIChange(img, (x, y) -> img.HSI_setSaturation(x, y, saturation));
    }

    public static void HSI_changeImageIntensity(MyImage img, double intensity) {
        applyHSIChange(img, (x, y) -> img.HSI_setIntensity(x, y, intensity));
    }

    public static void HSV_changeImageHue(MyImage img, double hue) {
        applyHSVChange(img, (x, y) -> img.HSV_setHue(x, y, hue));
    }

    public static void HSV_changeImageSaturation(MyImage img, double saturation) {
        applyHSVChange(img, (x, y) -> img.HSV_setSaturation(x, y, saturation));
    }

    public static void HSV_changeImageValue(MyImage img, double value) {
        applyHSVChange(img, (x, y) -> img.HSV_setValue(x, y, value));
    }

    public static void HSL_changeImageHue(MyImage img, double hue) {
        applyHSLChange(img, (x, y) -> img.HSL_setHue(x, y, hue));
    }

    public static void HSL_changeImageSaturation(MyImage img, double saturation) {
        applyHSLChange(img, (x, y) -> img.HSL_setSaturation(x, y, saturation));
    }

    public static void HSL_changeImageLightness(MyImage img, double lightness) {
        applyHSLChange(img, (x, y) -> img.HSL_setLightness(x, y, lightness));
    }

    public static void rotateLeft(MyImage img) {
        BufferedImage bi = createRotatedImage(img,

 false);
        img.modifyImageObject(img.getImageHeight(), img.getImageWidth(), bi);
    }

    public static void rotateRight(MyImage img) {
        BufferedImage bi = createRotatedImage(img, true);
        img.modifyImageObject(img.getImageHeight(), img.getImageWidth(), bi);
    }

    public static void flipHorizontal(MyImage img) {
        applyFlip(img, true);
    }

    public static void flipVertical(MyImage img) {
        applyFlip(img, false);
    }

    public static void transparentAllPixels(MyImage img, int alpha) {
        applyAlphaTransparency(img, alpha, true);
    }

    public static void transparentAlphaPixels(MyImage img, int alpha) {
        applyAlphaTransparency(img, alpha, false);
    }

    public static void grayScale_Average(MyImage img) {
        applyGrayScaleConversion(img, (r, g, b) -> (r + g + b) / 3);
    }

    public static void grayScale_Lightness(MyImage img) {
        applyGrayScaleConversion(img, (r, g, b) -> (Math.max(Math.max(r, g), b) + Math.min(Math.min(r, g), b)) / 2);
    }

    public static void grayScale_Luminosity(MyImage img) {
        applyGrayScaleConversion(img, (r, g, b) -> (int) (0.2126 * r + 0.7152 * g + 0.0722 * b));
    }

    public static void grayScale_setRGBValueToRedValue(MyImage img) {
        applyGrayScaleSetRGBValue(img, (r, g, b) -> r);
    }

    public static void grayScale_setRGBValueToGreenValue(MyImage img) {
        applyGrayScaleSetRGBValue(img, (r, g, b) -> g);
    }

    public static void grayScale_setRGBValueToBlueValue(MyImage img) {
        applyGrayScaleSetRGBValue(img, (r, g, b) -> b);
    }

    public static void createRandomImage(MyImage img) {
        applyImageCreation(img, (x, y) -> {
            int a = (int) (Math.random() * 256);
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);
            return getPixelValueFromARGBValue(a, r, g, b);
        });
    }

    public static void createColorImage(MyImage img, int color) {
        applyImageCreation(img, (x, y) -> color);
    }

    public static void crop(MyImage img, int x, int y, int width, int height) {
        BufferedImage bi = createCroppedImage(img, x, y, width, height);
        img.modifyImageObject(width, height, bi);
    }

    public static void negative(MyImage img) {
        applyColorTransformation(img, (r, g, b) -> {
            int a = img.getAlpha(x, y);
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            return getPixelValueFromARGBValue(a, r, g, b);
        });
    }

    public static void sepiaTone(MyImage img) {
        applyColorTransformation(img, (r, g, b) -> {
            int a = img.getAlpha(x, y);
            int tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            int tg = (

int) (0.349 * r + 0.686 * g + 0.168 * b);
            int tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);
            r = (tr > 255) ? 255 : tr;
            g = (tg > 255) ? 255 : tg;
            b = (tb > 255) ? 255 : tb;
            return getPixelValueFromARGBValue(a, r, g, b);
        });
    }

    public static void pixelation(MyImage img, int maskSize) {
        applyPixelation(img, maskSize);
    }

    public static void redImage(MyImage img) {
        applyColorChannel(img, true, false, false);
    }

    public static void greenImage(MyImage img) {
        applyColorChannel(img, false, true, false);
    }

    public static void blueImage(MyImage img) {
        applyColorChannel(img, false, false, true);
    }

    public static void changeImageRedValue(MyImage img, int red) {
        applyColorValueChange(img, red, true, false, false);
    }

    public static void changeImageGreenValue(MyImage img, int green) {
        applyColorValueChange(img, green, false, true, false);
    }

    public static void changeImageBlueValue(MyImage img, int blue) {
        applyColorValueChange(img, blue, false, false, true);
    }

    public static void contrast(MyImage img) {
        applyContrast(img);
    }

    public static void sharpen(MyImage img) {
        applyConvolutionFilter(img, new int[]{0, -1, 0, -1, 5, -1, 0, -1, 0}, 3);
    }

    public static void blur_D9(MyImage img) {
        applyConvolutionFilter(img, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 3);
    }

    public static void blur_D16(MyImage img) {
        applyConvolutionFilter(img, new int[]{1, 2, 1, 2, 4, 2, 1, 2, 1}, 3);
    }

    private static void applyHSIChange(MyImage img, HSIChangeFunction changeFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                changeFunction.apply(x, y);
            }
        }
    }

    private static void applyHSVChange(MyImage img, HSVChangeFunction changeFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                changeFunction.apply(x, y);
            }
        }
    }

    private static void applyHSLChange(MyImage img, HSLChangeFunction changeFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                changeFunction.apply(x, y);
            }
        }
    }

    private static void applyFlip(MyImage img, boolean isHorizontal) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width / 2; x++) {
                int

 newX = isHorizontal ? width - 1 - x : x;
                int newY = isHorizontal ? y : height - 1 - y;

                int pixel = img.getPixel(x, y);
                int newPixel = img.getPixel(newX, newY);

                img.setPixel(x, y, newPixel);
                img.setPixel(newX, newY, pixel);
            }
        }
    }

    private static void applyAlphaTransparency(MyImage img, int alpha, boolean applyToAllPixels) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int a = img.getAlpha(x, y);
                int r = getRedValueFromPixelValue(pixel);
                int g = getGreenValueFromPixelValue(pixel);
                int b = getBlueValueFromPixelValue(pixel);

                if (applyToAllPixels || a < alpha) {
                    int newPixel = getPixelValueFromARGBValue(alpha, r, g, b);
                    img.setPixel(x, y, newPixel);
                }
            }
        }
    }

    private static void applyGrayScaleConversion(MyImage img, GrayScaleConversionFunction conversionFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int a = img.getAlpha(x, y);
                int r = getRedValueFromPixelValue(pixel);
                int g = getGreenValueFromPixelValue(pixel);
                int b = getBlueValueFromPixelValue(pixel);
                int grayScaleValue = conversionFunction.convert(r, g, b);
                int newPixel = getPixelValueFromARGBValue(a, grayScaleValue, grayScaleValue, grayScaleValue);
                img.setPixel(x, y, newPixel);
            }
        }
    }

    private static void applyGrayScaleSetRGBValue(MyImage img, GrayScaleSetRGBValueFunction setRGBValueFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int a = img.getAlpha(x, y);
                int r = setRGBValueFunction.apply(pixel, 0, 0);
                int g = setRGBValueFunction.apply(pixel, 0, 1);
                int b = setRGBValueFunction.apply(pixel, 0, 2);
                int newPixel = getPixelValueFromARGBValue(a, r, g, b);
                img.setPixel(x, y, newPixel);
            }
        }
    }

    private static void applyImageCreation(MyImage img, ImageCreationFunction creationFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = creationFunction.create(x, y);
                img.setPixel(x, y, pixel);
            }
        }
    }

    private static BufferedImage createCroppedImage(MyImage img, int x, int y, int width, int height) {
        BufferedImage croppedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int sourceX = x + i;
                int sourceY = y + j;
               

 int pixel = img.getPixel(sourceX, sourceY);
                croppedImage.setRGB(i, j, pixel);
            }
        }
        return croppedImage;
    }

    private static void applyColorTransformation(MyImage img, ColorTransformationFunction transformationFunction) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int a = img.getAlpha(x, y);
                int r = getRedValueFromPixelValue(pixel);
                int g = getGreenValueFromPixelValue(pixel);
                int b = getBlueValueFromPixelValue(pixel);
                int newPixel = transformationFunction.transform(r, g, b);
                img.setPixel(x, y, getPixelValueFromARGBValue(a, newPixel, newPixel, newPixel));
            }
        }
    }

    private static void applyPixelation(MyImage img, int maskSize) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y += maskSize) {
            for (int x = 0; x < width; x += maskSize) {
                int startX = x;
                int startY = y;
                int endX = Math.min(x + maskSize, width);
                int endY = Math.min(y + maskSize, height);

                int avgR = 0;
                int avgG = 0;
                int avgB = 0;

                int numPixels = (endX - startX) * (endY - startY);

                for (int j = startY; j < endY; j++) {
                    for (int i = startX; i < endX; i++) {
                        int pixel = img.getPixel(i, j);
                        avgR += getRedValueFromPixelValue(pixel);
                        avgG += getGreenValueFromPixelValue(pixel);
                        avgB += getBlueValueFromPixelValue(pixel);
                    }
                }

                avgR /= numPixels;
                avgG /= numPixels;
                avgB /= numPixels;

                int avgPixel = getPixelValueFromRGBValue(avgR, avgG, avgB);

                for (int j = startY; j < endY; j++) {
                    for (int i = startX; i < endX; i++) {
                        img.setPixel(i, j, avgPixel);
                    }
                }
            }
        }
    }

    private static void applyColorChannel(MyImage img, boolean redChannel, boolean greenChannel, boolean blueChannel) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int a = img.getAlpha(x, y);
                int r = redChannel ? getRedValueFromPixelValue(pixel) : 0;
                int g = greenChannel ? getGreenValueFromPixelValue(pixel) : 0;
                int b = blueChannel ? getBlueValueFromPixelValue(pixel) : 0;
                int newPixel = getPixelValueFromARGBValue(a, r, g, b);
                img.setPixel(x, y, newPixel);
            }
        }
    }

    private static void applyColorValueChange(MyImage img, int value, boolean changeRed, boolean changeGreen, boolean changeBlue) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel

(x, y);
                int a = img.getAlpha(x, y);
                int r = changeRed ? Math.max(0, Math.min(255, getRedValueFromPixelValue(pixel) + value)) : getRedValueFromPixelValue(pixel);
                int g = changeGreen ? Math.max(0, Math.min(255, getGreenValueFromPixelValue(pixel) + value)) : getGreenValueFromPixelValue(pixel);
                int b = changeBlue ? Math.max(0, Math.min(255, getBlueValueFromPixelValue(pixel) + value)) : getBlueValueFromPixelValue(pixel);
                int newPixel = getPixelValueFromARGBValue(a, r, g, b);
                img.setPixel(x, y, newPixel);
            }
        }
    }

    private static void applyContrast(MyImage img) {
        int[] histogram = calculateHistogram(img);
        int totalPixels = img.getImageWidth() * img.getImageHeight();
        int[] cumulativeHistogram = calculateCumulativeHistogram(histogram, totalPixels);
        int minCumulative = findMinCumulative(cumulativeHistogram);
        int maxCumulative = findMaxCumulative(cumulativeHistogram);
        int[] lookupTable = calculateContrastLookupTable(minCumulative, maxCumulative);

        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int a = img.getAlpha(x, y);
                int r = lookupTable[getRedValueFromPixelValue(pixel)];
                int g = lookupTable[getGreenValueFromPixelValue(pixel)];
                int b = lookupTable[getBlueValueFromPixelValue(pixel)];
                int newPixel = getPixelValueFromARGBValue(a, r, g, b);
                img.setPixel(x, y, newPixel);
            }
        }
    }

    private static int[] calculateHistogram(MyImage img) {
        int[] histogram = new int[256];

        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int pixel = img.getPixel(x, y);
                int r = getRedValueFromPixelValue(pixel);
                int g = getGreenValueFromPixelValue(pixel);
                int b = getBlueValueFromPixelValue(pixel);
                int grayScaleValue = (r + g + b) / 3;
                histogram[grayScaleValue]++;
            }
        }

        return histogram;
    }

    private static int[] calculateCumulativeHistogram(int[] histogram, int totalPixels) {
        int[] cumulativeHistogram = new int[256];
        cumulativeHistogram[0] = histogram[0];

        for (int i = 1; i < 256; i++) {
            cumulativeHistogram[i] = cumulativeHistogram[i - 1] + histogram[i];
        }

        return cumulativeHistogram;
    }

    private static int findMinCumulative(int[] cumulativeHistogram) {
        for (int i = 0; i < 256; i++) {
            if (cumulativeHistogram[i] > 0) {
                return cumulativeHistogram[i];
            }
        }

        return 0;
    }

    private static int findMaxCumulative(int[] cumulativeHistogram) {
        for (int i = 255; i >= 0; i--) {
            if (cumulativeHistogram[i] < cumulativeHistogram[255]) {
                return cumulativeHistogram[i];
            }
        }

        return cumulativeHistogram[255];
    }

    private static int[] calculateContrastLookupTable(int minCumulative, int max

Cumulative) {
        int[] lookupTable = new int[256];

        for (int i = 0; i < 256; i++) {
            lookupTable[i] = (int) (((double) (i - minCumulative) / (maxCumulative - minCumulative)) * 255);
        }

        return lookupTable;
    }

    private static int getPixelValueFromARGBValue(int a, int r, int g, int b) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    private static int getPixelValueFromRGBValue(int r, int g, int b) {
        return (255 << 24) | (r << 16) | (g << 8) | b;
    }

    private static int getRedValueFromPixelValue(int pixel) {
        return (pixel >> 16) & 0xFF;
    }

    private static int getGreenValueFromPixelValue(int pixel) {
        return (pixel >> 8) & 0xFF;
    }

    private static int getBlueValueFromPixelValue(int pixel) {
        return pixel & 0xFF;
    }

    private static int getAlphaValueFromPixelValue(int pixel) {
        return (pixel >> 24) & 0xFF;
    }

    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}