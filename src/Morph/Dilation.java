package Morph;

import imageFX.MyImage;

import java.util.ArrayList;
import java.util.Collections;

public class Dilation {
    public static void applyDilation(MyImage img, boolean dilateBackgroundPixel) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();
        int[] output = new int[width * height];
        int targetValue = dilateBackgroundPixel ? 0 : 255;
        int reverseValue = targetValue == 255 ? 0 : 255;

        // perform dilation
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (img.getRed(x, y) == targetValue) {
                    if (surroundingPixelCheck(img,x, y, targetValue)) {
                        output[x + y * width] = reverseValue;
                    } else {
                        output[x + y * width] = targetValue;
                    }
                } else {
                    output[x + y * width] = reverseValue;
                }
            }
        }
        updateImagePixels(img,output);
    }

    private static void updateImagePixels(MyImage img,int[] output) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int v = output[x + y * img.getImageWidth()];
                img.setPixel(x, y, 255, v, v, v);
            }
        }
    }

    private static boolean surroundingPixelCheck(MyImage img,int x, int y, int targetValue) {
        for (int ty = y - 1; ty <= y + 1; ty++) {
            for (int tx = x - 1; tx <= x + 1; tx++) {
                if (withinBounds(img,tx, ty) && img.getRed(tx, ty) != targetValue) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean withinBounds(MyImage img,int x, int y) {
        return y >= 0 && y < img.getImageHeight() && x >= 0 && x < img.getImageWidth();
    }

    public static void applyDilationOnGrayscale(MyImage img,int[] mask, int maskSize) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();
        int[] output = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ArrayList<Integer> buff = getMaskPixels(img,x, y, mask, maskSize);
                buff.sort(Collections.reverseOrder());
                output[x + y * width] = buff.get(0);
            }
        }
        updateImagePixels(img,output);
    }

    private static ArrayList<Integer> getMaskPixels(MyImage img,int x, int y, int[] mask, int maskSize) {
        ArrayList<Integer> buff = new ArrayList<>();
        for (int ty = y - maskSize / 2, mr = 0; ty <= y + maskSize / 2; ty++, mr++) {
            for (int tx = x - maskSize / 2, mc = 0; tx <= x + maskSize / 2; tx++, mc++) {
                if (withinBounds(img,tx, ty) && mask[mc + mr * maskSize] == 1) {
                    buff.add(img.getRed(tx, ty));
                }
            }
        }
        return buff;
    }
}