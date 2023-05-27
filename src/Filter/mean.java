package Filter;

import imageFX.ImageFX;
import imageFX.MyImage;

public class Mean {

    public static void meanFilter_RGB(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];

        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int alpha = 0;
                int red = 0;
                int green = 0;
                int blue = 0;
                int count = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (isOutOfBounds(r, c, height, width)) {
                            continue;
                        } else {
                            alpha += img.getAlpha(c, r);
                            red += img.getRed(c, r);
                            green += img.getGreen(c, r);
                            blue += img.getBlue(c, r);
                            count++;
                        }
                    }
                }
                int p = calculateMeanPixelValue(alpha, red, green, blue, count);
                outputPixels[x + y * width] = p;
            }
        }

        setOutputPixels(img, outputPixels);
    }

    public static void meanFilter_ZeroFill(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];

        int width = img.getImageWidth();
        int height = img.getImageHeight();

        int buff[];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                buff = new int[maskSize * maskSize];
                int i = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (isOutOfBounds(r, c, height, width)) {
                            buff[i] = 0;
                        } else {
                            buff[i] = img.getPixel(c, r);
                        }
                        i++;
                    }
                }
                int p = calculateMeanPixelValueFromBuffer(buff);
                outputPixels[x + y * width] = p;
            }
        }

        setOutputPixels(img, outputPixels);
    }

    public static void meanFilter_ValueFill(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];

        int width = img.getImageWidth();
        int height = img.getImageHeight();

        int buff[];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                buff = new int[maskSize * maskSize];
                int i = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (isOutOfBounds(r, c, height, width)) {
                            int tr = getValidRow(r, height);
                            int tc = getValidColumn(c, width);
                            buff[i] = img.getPixel(tc, tr);
                        } else {
                            buff[i] = img.getPixel(c, r);
                        }
                        i++;
                    }
                }
                int p = calculateMeanPixelValueFromBuffer(buff);
                outputPixels[x + y * width] = p;
            }
        }

        setOutputPixels(img, outputPixels);
    }

    private static boolean isOutOfBounds(int r, int c, int height, int width) {
        return r < 0 || r >= height || c < 0 || c >= width;
    }

    private static int getValidRow(int r, int height) {
        if (r < 0) {
            return r + 1;
        } else if (r == height) {
            return r - 1;
        }
        return r;
    }

    private static int getValidColumn(int c, int width) {
        if (c < 0) {
            return c + 1;
        } else if (c == width) {
            return c - 1;
        }
        return c;
    }

    private static int calculateMeanPixelValue(int alpha, int red, int green, int blue, int count) {
        int meanAlpha = alpha / count;
        int meanRed = red / count;
        int meanGreen = green / count;
        int meanBlue = blue / count;
        return ImageFX.getPixelValueFromARGBValue(meanAlpha, meanRed, meanGreen, meanBlue);
    }

    private static int calculateMeanPixelValueFromBuffer(int[] buff) {
        int sa = 0;
        int sr = 0;
        int sg = 0;
        int sb = 0;

        for (int i = 0; i < buff.length; i++) {
            sa += ImageFX.getAlphaValueFromPixelValue(buff[i]);
            sr += ImageFX.getRedValueFromPixelValue(buff[i]);
            sg += ImageFX.getGreenValueFromPixelValue(buff[i]);
            sb += ImageFX.getBlueValueFromPixelValue(buff[i]);
        }

        int meanAlpha = sa / buff.length;
        int meanRed = sr / buff.length;
        int meanGreen = sg / buff.length;
        int meanBlue = sb / buff.length;
        return ImageFX.getPixelValueFromARGBValue(meanAlpha, meanRed, meanGreen, meanBlue);
    }

    private static void setOutputPixels(MyImage img, int[] outputPixels) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
    }
}
