package imageFX;

import java.awt.image.BufferedImage;

public class ImageFX{
    /**
     * This method will return alpha value from the pixel value.
     *
     * @param pixelVal The pixel value from which alpha value is calculated.
     * @return Alpha value [0-255].
     */
    public static int getAlphaValueFromPixelValue(int pixelVal){
        return (pixelVal>>24) & 0xFF;
    }

    /**
     * This method will return red value from the pixel value.
     *
     * @param pixelVal The pixel value from which red value is calculated.
     * @return Red value [0-255].
     */
    public static int getRedValueFromPixelValue(int pixelVal){
        return (pixelVal>>16) & 0xFF;
    }

    /**
     * This method will return green value from the pixel value.
     *
     * @param pixelVal The pixel value from which green value is calculated.
     * @return Green value [0-255].
     */
    public static int getGreenValueFromPixelValue(int pixelVal){
        return (pixelVal>>8) & 0xFF;
    }

    /**
     * This method will return blue value from the pixel value.
     *
     * @param pixelVal The pixel value from which blue value is calculated.
     * @return Blue value [0-255].
     */
    public static int getBlueValueFromPixelValue(int pixelVal){
        return pixelVal & 0xFF;
    }

    /**
     * This method will return pixel value from the ARGB value.
     *
     * @param a Alpha value [0-255].
     * @param r Red value [0-255].
     * @param g Green value [0-255].
     * @param b Blue value [0-255].
     * @return Pixel value.
     */
    public static int getPixelValueFromARGBValue(int a, int r, int g, int b){
        return (a<<24) | (r<<16) | (g<<8) | b;
    }

    /**
     * This method will replace the RGB value of each pixel with the HSI value.
     *
     * @param img The image whose HSI image is created.
     */
    public static void HSI_createHSIImage(MyImage img) {
        iterateImagePixels(img, (x, y) -> {
            int a = img.getAlpha(x, y);
            int h = (int) (img.HSI_getHue(x, y) * 255 / 359);
            int s = (int) (img.HSI_getSaturation(x, y) * 255);
            int i = (int) (img.HSI_getIntensity(x, y) * 255);
            img.setPixel(x, y, a, h, s, i);
        });
    }

    /**
     * This method will change the hue value of the image using HSI (Hue-Saturation-Intensity) color model.
     *
     * @param img The image pixels to change.
     * @param hue The hue value to set in degree [0-360].
     */
    public static void HSI_changeImageHue(MyImage img, double hue) {
        iterateImagePixels(img, (x, y) -> img.HSI_setHue(x, y, hue));
    }

    /**
     * This method will change the saturation value of the image using HSI (Hue-Saturation-Intensity) color model.
     *
     * @param img        The image pixels to change.
     * @param saturation The saturation value [0-1].
     */
    public static void HSI_changeImageSaturation(MyImage img, double saturation) {
        iterateImagePixels(img, (x, y) -> img.HSI_setSaturation(x, y, saturation));
    }

    /**
     * This method will change the intensity value of the image using HSI (Hue-Saturation-Intensity) color model.
     *
     * @param img       The image pixels to change.
     * @param intensity The intensity value [0-255].
     */
    public static void HSI_changeImageIntensity(MyImage img, double intensity) {
        iterateImagePixels(img, (x, y) -> img.HSI_setIntensity(x, y, intensity));
    }

    /**
     * This method will change the hue of the image using HSV (Hue-Saturation-Value) color model.
     *
     * @param img The image pixels to change.
     * @param hue The hue value to set in degree [0-360].
     */
    public static void HSV_changeImageHue(MyImage img, double hue) {
        iterateImagePixels(img, (x, y) -> img.HSV_setHue(x, y, hue));
    }

    /**
     * This method will change the saturation of the image using HSV (Hue-Saturation-Value) color model.
     *
     * @param img        The image pixels to change.
     * @param saturation The saturation value [0-1].
     */
    public static void HSV_changeImageSaturation(MyImage img, double saturation) {
        iterateImagePixels(img, (x, y) -> img.HSV_setSaturation(x, y, saturation));
    }

    /**
     * This method will change the value of the image using HSV (Hue-Saturation-Value) color model.
     *
     * @param img   The image pixels to change.
     * @param value The value [0-1].
     */
    public static void HSV_changeImageValue(MyImage img, double value) {
        iterateImagePixels(img, (x, y) -> img.HSV_setValue(x, y, value));
    }

    /**
     * This method will change the hue of the image using HSL (Hue-Saturation-Lightness) color model.
     *
     * @param img The image pixels to change.
     * @param hue The hue value to set in degree [0-360].
     */
    public static void HSL_changeImageHue(MyImage img, double hue) {
        iterateImagePixels(img, (x, y) -> img.HSL_setHue(x, y, hue));
    }

    /**
     * This method will change the saturation of the image using HSL (Hue-Saturation-Lightness) color model.
     *
     * @param img        The image pixels to change.
     * @param saturation The saturation value [0-1].
     */
    public static void HSL_changeImageSaturation(MyImage img, double saturation) {
        iterateImagePixels(img, (x, y) -> img.HSL_setSaturation(x, y, saturation));
    }

    /**
     * This method will change the lightness of the image using HSL (Hue-Saturation-Lightness) color model.
     *
     * @param img       The image pixels to change.
     * @param lightness The lightness [0-1].
     */
    public static void HSL_changeImageLightness(MyImage img, double lightness) {
        iterateImagePixels(img, (x, y) -> img.HSL_setLightness(x, y, lightness));
    }

    /**
     * Helper method to iterate over the pixels of the image and apply a transformation.
     *
     * @param img         The image pixels to iterate.
     * @param transformation The transformation to apply to each pixel.
     */
    private static void iterateImagePixels(MyImage img, PixelTransformation transformation) {
        for (int y = 0; y < img.getImageHeight(); y++) {
            for (int x = 0; x < img.getImageWidth(); x++) {
                transformation.transformPixel(x, y);
            }
        }
    }


    // Rotation Methods

    /**
     * This method will rotate the image left.
     *
     * @param img The image to rotate.
     */
    public static void rotateLeft(MyImage img){
        BufferedImage bi = new BufferedImage(img.getImageHeight(), img.getImageWidth(), BufferedImage.TYPE_INT_ARGB);
        for(int sx = img.getImageWidth()-1, y = 0; sx >= 0; sx--, y++){
            for(int sy = 0, x = 0; sy < img.getImageHeight(); sy++, x++){
                bi.setRGB(x, y, img.getPixel(sx, sy));
            }
        }
        img.modifyImageObject(img.getImageHeight(), img.getImageWidth(), bi);
    }

    /**
     * This method will rotate the image right.
     *
     * @param img The image to rotate.
     */
    public static void rotateRight(MyImage img){
        BufferedImage bi = new BufferedImage(img.getImageHeight(), img.getImageWidth(), BufferedImage.TYPE_INT_ARGB);
        for(int sx = 0, y = 0; sx < img.getImageWidth(); sx++, y++){
            for(int sy = img.getImageHeight()-1 , x = 0; sy >= 0; sy--, x++){
                bi.setRGB(x, y, img.getPixel(sx, sy));
            }
        }
        img.modifyImageObject(img.getImageHeight(), img.getImageWidth(), bi);
    }


    // Flip Methods

    /**
     * This method will flip the image horizontally.
     *
     * @param img The image to be flipped horizontally.
     */
    public static void flipHorizontal(MyImage img){
        for(int xi = 0, xj = img.getImageWidth() - 1 ; xi < xj; xi++, xj--){
            for(int y = 0; y < img.getImageHeight(); y++){
                int t = img.getPixel(xi, y);
                img.setPixelToValue(xi, y, img.getPixel(xj, y));
                img.setPixelToValue(xj, y, t);
            }
        }
    }


    /**
     * This method will flip the image vertically.
     *
     * @param img The image to be flipped vertically.
     */
    public static void flipVertical(MyImage img){
        for(int yi = 0, yj = img.getImageHeight() - 1 ; yi < yj; yi++, yj--){
            for(int x = 0; x < img.getImageWidth(); x++){
                int t = img.getPixel(x, yi);
                img.setPixelToValue(x, yi, img.getPixel(x, yj));
                img.setPixelToValue(x, yj, t);
            }
        }
    }

    // Transparency Methods

    /**
     * This method will change the transparency (alpha) of all the pixels of the image.
     * Works well with .png files.
     *
     * @param img The image pixels to change.
     * @param alpha The alpha value [0-255] to set in each pixels of the image.
     */
    public static void transparentAllPixels(MyImage img, int alpha){
        for(int y = 0; y < img.getImageHeight(); y++){
            for(int x = 0; x < img.getImageWidth(); x++){
                img.setAlpha(x, y, alpha);
            }
        }
    }

    /**
     * This method will change the transparency (alpha) of those pixels which have
     * alpha value greater than 0.
     * Works well with .png files.
     *
     * @param img The image pixels to change.
     * @param alpha The alpha value [0-255] to set in each pixels of the image.
     */
    public static void transparentAlphaPixels(MyImage img, int alpha){
        for(int y = 0; y < img.getImageHeight(); y++){
            for(int x = 0; x < img.getImageWidth(); x++){
                if(img.getAlpha(x, y) > 0){
                    img.setAlpha(x, y, alpha);
                }
            }
        }
    }

    // Grayscale Methods

    /**
     * This method will turn color image to gray scale image.
     * It will set the RGB value of the pixel to (R+G+B)/3
     *
     * @param img The image pixels to change.
     */
    public static void grayScale_Average(MyImage img) {
        modifyPixels(img, (x, y) -> {
            int gray = calculateGrayAverage(img.getRed(x, y), img.getGreen(x, y), img.getBlue(x, y));
            img.setPixel(x, y, img.getAlpha(x, y), gray, gray, gray);
        });
    }

    public static void grayScale_Lightness(MyImage img) {
        modifyPixels(img, (x, y) -> {
            int gray = calculateGrayLightness(img.getRed(x, y), img.getGreen(x, y), img.getBlue(x, y));
            img.setPixel(x, y, img.getAlpha(x, y), gray, gray, gray);
        });
    }

    public static void  grayScale_Luminosity(MyImage img) {
        modifyPixels(img, (x, y) -> {
            int gray = calculateGrayLuminosity(img.getRed(x, y), img.getGreen(x, y), img.getBlue(x, y));
            img.setPixel(x, y, img.getAlpha(x, y), gray, gray, gray);
        });
    }

    public static void grayScale_setRGBValueToRedValue(MyImage img) {
        modifyPixels(img, (x, y) -> {
            int red = img.getRed(x, y);
            img.setPixel(x, y, img.getAlpha(x, y), red, red, red);
        });
    }

    public static void grayScale_setRGBValueToGreenValue(MyImage img) {
        modifyPixels(img, (x, y) -> {
            int green = img.getGreen(x, y);
            img.setPixel(x, y, img.getAlpha(x, y), green, green, green);
        });
    }

    public static void grayScale_setRGBValueToBlueValue(MyImage img) {
        modifyPixels(img, (x, y) -> {
            int blue = img.getBlue(x, y);
            img.setPixel(x, y, img.getAlpha(x, y), blue, blue, blue);
        });
    }

    // Helper methods for grayscale conversion

    private static int calculateGrayAverage(int red, int green, int blue) {
        return (red + green + blue) / 3;
    }

    private static int calculateGrayLightness(int red, int green, int blue) {
        int max = Math.max(Math.max(red, green), blue);
        int min = Math.min(Math.min(red, green), blue);
        return (max + min) / 2;
    }

    private static int calculateGrayLuminosity(int red, int green, int blue) {
        return (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);
    }

    // Helper method for pixel modification

    private static void modifyPixels(MyImage img, PixelTransformation transformation) {
        int width = img.getImageWidth();
        int height = img.getImageHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                transformation.transformPixel(x, y);
            }
        }
    }


    /**
     * Functional interface for a pixel transformation.
     */
    private interface PixelTransformation {
        void transformPixel(int x, int y);
    }




}