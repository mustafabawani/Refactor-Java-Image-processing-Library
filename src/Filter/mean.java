package Filter;

import imageFX.MyImage;
import imageFX.*;

public class mean {

    public static void meanFilter_RGB(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];
        int width = img.getImageWidth();
        int height = img.getImageHeight();
        
        int alpha, red, green, blue;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                alpha = 0;
                red = 0;
                green = 0;
                blue = 0;
                int count = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (r < 0 || r >= height || c < 0 || c >= width) {
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

                int p = ImageFX.getPixelValueFromARGBValue(alpha / count, red / count, green / count, blue / count);
                outputPixels[x + y * width] = p;
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
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
                        if (r < 0 || r >= height || c < 0 || c >= width) {
                            buff[i] = 0;
                        } else {
                            buff[i] = img.getPixel(c, r);
                        }
                        i++;
                    }
                }

                int sa = 0, sr = 0, sg = 0, sb = 0;
                for (i = 0; i < maskSize * maskSize; i++) {
                    sa += ImageFX.getAlphaValueFromPixelValue(buff[i]);
                    sr += ImageFX.getRedValueFromPixelValue(buff[i]);
                    sg += ImageFX.getGreenValueFromPixelValue(buff[i]);
                    sb += ImageFX.getBlueValueFromPixelValue(buff[i]);
                }

                int p = ImageFX.getPixelValueFromARGBValue(sa / (maskSize * maskSize), sr / (maskSize * maskSize),
                        sg / (maskSize * maskSize), sb / (maskSize * maskSize));
                outputPixels[x + y * width] = p;


            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
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
                        if (r < 0 || r >= height || c < 0 || c >= width) {
                            int tr = r, tc = c;
                            if (r < 0) {
                                tr = r + 1;
                            } else if (r == height) {
                                tr = r - 1;
                            }
                            if (c < 0) {
                                tc = c + 1;
                            } else if (c == width) {
                                tc = c - 1;
                            }
                            buff[i] = img.getPixel(tc, tr);
                        } else {
                            buff[i] = img.getPixel(c, r);
                        }
                        i++;
                    }
                }

                int sa = 0, sr = 0, sg = 0, sb = 0;
                for (i = 0; i < maskSize * maskSize; i++) {
                    sa += ImageFX.getAlphaValueFromPixelValue(buff[i]);
                    sr += ImageFX.getRedValueFromPixelValue(buff[i]);
                    sg += ImageFX.getGreenValueFromPixelValue(buff[i]);
                    sb += ImageFX.getBlueValueFromPixelValue(buff[i]);
                }

                int p = ImageFX.getPixelValueFromARGBValue(sa / (maskSize * maskSize), sr / (maskSize * maskSize),
                        sg / (maskSize * maskSize), sb / (maskSize * maskSize));
                outputPixels[x + y * width] = p;
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
    }
}