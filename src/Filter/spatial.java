package Filter;

package Filter;

import imageFX.ImageFX;
import imageFX.MyImage;

import java.util.Arrays;

public class Spatial {

    public static void spatialFilter_RGB(MyImage img, int maskSize) {
        int outputPixels[] = new int[img.getImageTotalPixels()];
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        int red[], green[], blue[];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                red = new int[maskSize * maskSize];
                green = new int[maskSize * maskSize];
                blue = new int[maskSize * maskSize];
                int count = 0;
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        if (r < 0 || r >= height || c < 0 || c >= width) {
                            continue;
                        } else if (x == c && y == r) {
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

                int pixelRED = img.getRed(x, y);
                int pixelGREEN = img.getGreen(x, y);
                int pixelBLUE = img.getBlue(x, y);

                int fRED, fGREEN, fBLUE;

                if (pixelRED > red[maskSize * maskSize - 1]) {
                    fRED = red[maskSize * maskSize - 1];
                } else if (pixelRED < red[maskSize * maskSize - count]) {
                    fRED = red[maskSize * maskSize - count];
                } else {
                    fRED = pixelRED;
                }

                if (pixelGREEN > green[maskSize * maskSize - 1]) {
                    fGREEN = green[maskSize * maskSize - 1];
                } else if (pixelGREEN < green[maskSize * maskSize - count]) {
                    fGREEN = green[maskSize * maskSize - count];
                } else {
                    fGREEN = pixelGREEN;
                }

                if (pixelBLUE > blue[maskSize * maskSize - 1]) {
                    fBLUE = blue[maskSize * maskSize - 1];
                } else if (pixelBLUE < blue[maskSize * maskSize - count]) {
                    fBLUE = blue[maskSize * maskSize - count];
                } else {
                    fBLUE = pixelBLUE;
                }

                int p = ImageFX.getPixelValueFromARGBValue(255, fRED, fGREEN, fBLUE);
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
