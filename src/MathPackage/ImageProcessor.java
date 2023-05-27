package MathPackage;

import imageFX.MyImage;

public class ImageProcessor {
    private String operation;
    private int c=0;

    public ImageProcessor(String operation)
    {
        this.operation=operation;
    }

    public void setC(int c)
    {
        this.c=c;
    }

    public void processImages(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        ImageOperation grayscaleOperation = ImageOperatorFactory.createOperator("GRAYSCALE");
        ImageOperation colorOperation = ImageOperatorFactory.createOperator("COLOR");
        if(operation=="Add")
        {
            grayscaleOperation.applyAdd(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyAdd(sourceImg1,c,resultImg);
            colorOperation.applyAdd(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyAdd(sourceImg1,c,resultImg);

        }
    }
}
