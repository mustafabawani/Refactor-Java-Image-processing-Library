package MathPackage;

import imageFX.MyImage;

public class ImageProcessor {
    private ImageOperation operator;

    public void setOperator(ImageOperation operator) {
        this.operator = operator;
    }

    public void processImages(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        operator.apply(sourceImg1, sourceImg2, resultImg);
    }
}
