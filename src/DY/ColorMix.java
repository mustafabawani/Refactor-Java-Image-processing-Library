package DY;

import imageFX.ImageFX;
import imageFX.MyImage;

public class ColorMix {
    /**
     * This method will generate an image of different shade out of the entered image.
     *
     * @param img The image color to mix.
     */
    public static void colorMix1(MyImage img) {
        applyColorMix(img, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1});
    }

    public static void colorMix2(MyImage img) {
        applyColorMix(img, new int[]{9, -1, -3, 1, 2, 1, -3, -1, 9});
    }

    public static void colorMix3(MyImage img) {
        applyColorMix(img, new int[]{3, -1, -3, 1, 2, 1, -3, -1, 3});
    }

    private static void applyColorMix(MyImage img, int[] mask) {
        int maskSize = 3;
        int[] buff;
        int[] outputPixels = new int[img.getImageTotalPixels()];

        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int i = 0;
                buff = new int[9];
                for (int r = y - (maskSize / 2); r <= y + (maskSize / 2); r++) {
                    for (int c = x - (maskSize / 2); c <= x + (maskSize / 2); c++) {
                        int pixel;
                        if (r < 0 || r >= height || c < 0 || c >= width) {
                            int tr = Math.max(0, Math.min(r, height - 1));
                            int tc = Math.max(0, Math.min(c, width - 1));
                            pixel = img.getPixel(tc, tr);
                        } else {
                            pixel = img.getPixel(c, r);
                        }
                        buff[i] = pixel;
                        i++;
                    }
                }

                int sa = 0, sr = 0, sg = 0, sb = 0;
                for (i = 0; i < 9; i++) {
                    sa += mask[i] * ImageFX.getAlphaValueFromPixelValue(buff[i]);
                    sr += mask[i] * ImageFX.getRedValueFromPixelValue(buff[i]);
                    sg += mask[i] * ImageFX.getGreenValueFromPixelValue(buff[i]);
                    sb += mask[i] * ImageFX.getBlueValueFromPixelValue(buff[i]);
                }

                int p = ImageFX.getPixelValueFromARGBValue(sa, sr, sg, sb);
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

