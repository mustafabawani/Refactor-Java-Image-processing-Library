
package imageFX.filter;

import imageFX.ImageFX;
import imageFX.MyImage;

import java.util.Arrays;

public class Median {

    public static void medianFilter(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        int buff[];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                buff = new int[maskSize * maskSize];
                int count = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (r < 0 || r >= height || c < 0 || c >= width) {
                            continue;
                        } else {
                            buff[count] = img.getPixel(c, r);
                            count++;
                        }
                    }
                }
                
                Arrays.sort(buff);
                outputPixels[x + y * width] = buff[count / 2];
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
    }

    public static void medianFilter_RGB(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        int red[], green[], blue[];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a = img.getAlpha(x, y);
                red = new int[maskSize * maskSize];
                green = new int[maskSize * maskSize];
                blue = new int[maskSize * maskSize];
                int count = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (r < 0 || r >= height || c < 0 || c >= width) {
                            continue;
                        } else {
                            red[count] = img.getRed(c, r);
                            green[count] = img.getGreen(c, r);
                            blue[count] = img.getBlue(c, r);
                            count++;
                        }
                    }
                }

                Arrays.sort(red);
                Arrays.sort(green);
                Arrays.sort(blue);

                int index = (count % 2 == 0) ? count / 2 - 1 : count / 2;
                int p = ImageFX.getPixelValueFromARGBValue(a, red[index], green[index], blue[index]);
                outputPixels[x + y * width] = p;
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
    }

    public static void medianFilter_ZeroFill(MyImage img, int maskSize) {
        int outputPixels[] = new int[img

.getImageTotalPixels()];
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
                Arrays.sort(buff);
                outputPixels[x + y * width] = buff[(maskSize * maskSize) / 2];
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
    }

    public static void medianFilter_ValueFill(MyImage img, int maskSize) {
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
                Arrays.sort(buff);
                outputPixels[x + y * width] = buff[(maskSize * maskSize) / 2];
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setPixelToValue(x, y, outputPixels[x + y * width]);
            }
        }
    }
}
