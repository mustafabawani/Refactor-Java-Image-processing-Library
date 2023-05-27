package MathPackage;

public class ImageOperatorFactory {
    public static ImageOperation createOperator(String imageType) {
        if(imageType == null) {
            return null;
        }
        if(imageType.equalsIgnoreCase("GRAYSCALE")) {
            return new GrayScale();
        } else if(imageType.equalsIgnoreCase("COLOR")) {
            return new ColorImage();
        }
        return null;
    }
}
