package DY;

import imageFX.MyImage;

public class DyMosaic {

    private static void createMosaic(MyImage img, int DYColor, int mSize) {
        int r = (DYColor >> 16) & 0xFF;
        int g = (DYColor >> 8) & 0xFF;
        int b = DYColor & 0xFF;

        int buff = 20;
        int lim = Math.max(Math.max(r, g), b);
        lim = (((255 - lim) / 2) > buff) ? buff : ((255 - lim) / 2);

        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y += mSize) {
            for (int x = 0; x < width; x += mSize) {
                int c;
                if (lim > 0) {
                    c = (int) (Math.random() * lim);
                    c = ((int) (Math.random() * 2)) == 0 ? c : -1 * c;
                } else {
                    lim = buff;
                    c = -1 * (int) (Math.random() * lim);
                }

                int[] rgb = new int[3];
                rgb[0] = (c + r) > 0 ? (c + r) : r;
                rgb[1] = (c + g) > 0 ? (c + g) : g;
                rgb[2] = (c + b) > 0 ? (c + b) : b;

                for (int yi = 0; yi < mSize && y + yi < height; yi++) {
                    for (int xi = 0; xi < mSize && x + xi < width; xi++) {
                        img.setPixel(x + xi, y + yi, 255, rgb[0], rgb[1], rgb[2]);
                    }
                }
            }
        }
    }

    public static void random(MyImage img, int DYColor, int pieceSize) {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        int color = (255 << 24) | (r << 16) | (g << 8) | b;
        createMosaic(img, color, pieceSize);
    }

    public static void colorMosaic(MyImage img, int DYColor, int pieceSize) {
        createMosaic(img, DYColor, pieceSize);
    }

    public static void rgbMosaic(MyImage img, int r, int g, int b, int pieceSize) {
        int DYColor = (255 << 24) | (r << 16) | (g << 8) | b;
        createMosaic(img, DYColor, pieceSize);
    }
}