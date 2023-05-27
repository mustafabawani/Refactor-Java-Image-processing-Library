package Morph;

import imageFX.MyImage;

import java.util.ArrayList;
import java.util.Collections;

public class Dilation {
    private final MyImage img;
    private final int width;
    private final int height;

    public Dilation(MyImage img) {
        this.img = img;
        this.width = img.getImageWidth();
        this.height = img.getImageHeight();
    }

    public void applyDilation(boolean dilateBackgroundPixel) {
        int[] output = new int[width * height];
        int targetValue = dilateBackgroundPixel ? 0 : 255;
        int reverseValue = targetValue == 255 ? 0 : 255;

        // perform dilation
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (img.getRed(x, y) == targetValue) {
                    if (surroundingPixelCheck(x, y, targetValue)) {
                        output[x + y * width] = reverseValue;
                    } else {
                        output[x + y * width] = targetValue;
                    }
                } else {
                    output[x + y * width] = reverseValue;
                }
            }
        }
        updateImagePixels(output);
    }

    public void applyDilation() {
        applyDilation(true);
    }

    private void updateImagePixels(int[] output) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int v = output[x + y * width];
                img.setPixel(x, y, 255, v, v, v);
            }
        }
    }

    private boolean surroundingPixelCheck(int x, int y, int targetValue) {
        for (int ty = y - 1; ty <= y + 1; ty++) {
            for (int tx = x - 1; tx <= x + 1; tx++) {
                if (withinBounds(tx, ty) && img.getRed(tx, ty) != targetValue) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean withinBounds(int x, int y) {
        return y >= 0 && y < height && x >= 0 && x < width;
    }

    public void applyDilationOnGrayscale(int maskSize) {
        int[] output = new int[width * height];
        int[] mask = new int[maskSize * maskSize];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ArrayList<Integer> buff = getMaskPixels(x, y, mask, maskSize);
                buff.sort(Collections.reverseOrder());
                output[x + y * width] = buff.get(0);
            }
        }
        updateImagePixels(output);
    }

    private ArrayList<Integer> getMaskPixels(int x, int y, int[] mask, int maskSize) {
        ArrayList<Integer> buff = new ArrayList<>();
        for (int ty = y - maskSize / 2, mr = 0; ty <= y + maskSize / 2; ty++, mr++) {
            for (int tx = x - maskSize / 2, mc = 0; tx <= x + maskSize / 2; tx++, mc++) {
                if (withinBounds(tx, ty) && mask[mc + mr * maskSize] == 1) {
                    buff.add(img.getRed(tx, ty));
                }
            }
        }
        return buff;
    }

    public void applyDilationOnGrayscale() {
        int defaultMaskSize = 3;
        applyDilationOnGrayscale(defaultMaskSize);
    }
}