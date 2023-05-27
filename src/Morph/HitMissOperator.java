package Morph;
import imageFX.MyImage;
public class HitMissOperator {

    private static final int BLACK = 0;
    private static final int WHITE = 255;

    public static void binaryImage(MyImage img, int[] mask) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();
        int output[] = new int[width * height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (isMaskMatch(img, mask, x, y)) {
                    output[x + y * width] = WHITE;
                } else {
                    output[x + y * width] = BLACK;
                }
            }
        }

        updateImage(img, output);
    }

    private static boolean isMaskMatch(MyImage img, int[] mask, int startX, int startY) {
        int maskSize = mask.length;
        int maskHalfSize = maskSize / 2;

        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int my = 0; my < maskSize; my++) {
            for (int mx = 0; mx < maskSize; mx++) {
                int imgX = startX - maskHalfSize + mx;
                int imgY = startY - maskHalfSize + my;

                if (imgX >= 0 && imgX < width && imgY >= 0 && imgY < height) {
                    int maskValue = mask[mx + my * maskSize];
                    int imgValue = img.getRed(imgX, imgY);

                    if (maskValue <= 1 && imgValue != maskValue * WHITE) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void updateImage(MyImage img, int[] output) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                int v = output[x + y * img.getImageWidth()];
                img.setPixel(x, y, WHITE, v, v, v);
            }
        }
    }
}
