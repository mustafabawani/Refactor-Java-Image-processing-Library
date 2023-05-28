package MathPackage;

import imageFX.MyImage;

public class ImageProcessor {
    private String operation;
    private int c=0;

    private float blendRatio;

    public ImageProcessor(String operation)
    {
        this.operation=operation;
    }

    public void setC(int c)
    {
        this.c=c;
    }

    public int getC()
    {
        return c;
    }

    public void setBlendRatio(float blendRatio)
    {
        this.blendRatio=blendRatio;
    }

    public float getBlendRatio() {
        return blendRatio;
    }

    public void processImages(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        ImageOperation grayscaleOperation = ImageOperatorFactory.createOperator("GRAYSCALE");
        ImageOperation colorOperation = ImageOperatorFactory.createOperator("COLOR");
        if(operation.equalsIgnoreCase("ADD"))
        {
            grayscaleOperation.applyAdd(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyAdd(sourceImg1,c,resultImg);
            colorOperation.applyAdd(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyAdd(sourceImg1,c,resultImg);

        }
        if(operation.equalsIgnoreCase("BLEND"))
        {
            grayscaleOperation.applyBlend(sourceImg1,sourceImg2,resultImg,blendRatio);
            colorOperation.applyBlend(sourceImg1,sourceImg2,resultImg,blendRatio);
        }
        if(operation.equalsIgnoreCase("AND"))
        {
            grayscaleOperation.applyAnd(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyAnd(sourceImg1,c,resultImg);
            colorOperation.applyAnd(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyAnd(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("DIVIDE"))
        {
            grayscaleOperation.applyDivide(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyDivide(sourceImg1,c,resultImg);
            colorOperation.applyDivide(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyDivide(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("NAND"))
        {
            grayscaleOperation.applyNand(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyNand(sourceImg1,c,resultImg);
            colorOperation.applyNand(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyNand(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("NOR"))
        {
            grayscaleOperation.applyNor(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyNor(sourceImg1,c,resultImg);
            colorOperation.applyNor(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyNor(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("OR"))
        {
            grayscaleOperation.applyOr(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyOr(sourceImg1,c,resultImg);
            colorOperation.applyOr(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyOr(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("XNOR"))
        {
            grayscaleOperation.applyXnor(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyXnor(sourceImg1,c,resultImg);
            colorOperation.applyXnor(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyXnor(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("XOR"))
        {
            grayscaleOperation.applyXor(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyXor(sourceImg1,c,resultImg);
            colorOperation.applyXor(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyXor(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("MULTIPLY"))
        {
            grayscaleOperation.applyMul(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applyMul(sourceImg1,c,resultImg);
            colorOperation.applyMul(sourceImg1,sourceImg2,resultImg);
            colorOperation.applyMul(sourceImg1,c,resultImg);
        }
        if(operation.equalsIgnoreCase("SUBTRACT"))
        {
            grayscaleOperation.applySub(sourceImg1,sourceImg2,resultImg);
            grayscaleOperation.applySub(sourceImg1,c,resultImg);
            colorOperation.applySub(sourceImg1,sourceImg2,resultImg);
            colorOperation.applySub(sourceImg1,c,resultImg);
        }


    }
}
