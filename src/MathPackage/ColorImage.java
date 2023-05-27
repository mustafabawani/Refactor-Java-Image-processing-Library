package MathPackage;

import imageFX.MyImage;

public class ColorImage implements ImageOperation{
    public void applyAdd(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        int width = sourceImg1.getImageWidth(); //ADD
        int height = sourceImg1.getImageHeight();

        //variable
        int pRED, pGREEN, pBLUE, rRED, rGREEN, rBLUE;

        /**
         * Add pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //add the RGB components of the two source image
                pRED = sourceImg1.getRed(x, y) + sourceImg2.getRed(x, y);
                pGREEN = sourceImg1.getGreen(x, y) + sourceImg2.getGreen(x, y);
                pBLUE = sourceImg1.getBlue(x, y) + sourceImg2.getBlue(x, y);

                //find result
                rRED = (pRED>255)?255:pRED;
                rGREEN = (pGREEN>255)?255:pGREEN;
                rBLUE = (pBLUE>255)?255:pBLUE;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    @Override
    public void applyAdd(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth(); //ADD
        int height = sourceImg1.getImageHeight();

        //variable
        int pRED, pGREEN, pBLUE, rRED, rGREEN, rBLUE;

        /**
         * Add pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //add the RGB components of the two source image
                pRED = sourceImg1.getRed(x, y) + C;
                pGREEN = sourceImg1.getGreen(x, y) + C;
                pBLUE = sourceImg1.getBlue(x, y) + C;

                //find result
                rRED = (pRED>255)?255:pRED;
                rGREEN = (pGREEN>255)?255:pGREEN;
                rBLUE = (pBLUE>255)?255:pBLUE;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyBlend(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg, float blendRatio)
    {
        //image dimension - common for all the three images //Blend
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * blend pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //blend the RGB components of the two source image
                rRED = (int)((blendRatio*sourceImg1.getRed(x, y)) + ((1-blendRatio)*sourceImg2.getRed(x, y)));
                rGREEN = (int)((blendRatio*sourceImg1.getGreen(x, y)) + ((1-blendRatio)*sourceImg2.getGreen(x, y)));
                rBLUE = (int)((blendRatio*sourceImg1.getBlue(x, y)) + ((1-blendRatio)*sourceImg2.getBlue(x, y)));

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyDivide(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
//image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * divide pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //divide
                if(sourceImg2.getRed(x, y) > 0){
                    rRED = sourceImg1.getRed(x, y) / sourceImg2.getRed(x, y);
                }else{
                    rRED = 0;
                }

                if(sourceImg2.getGreen(x, y) > 0){
                    rGREEN = sourceImg1.getGreen(x, y) / sourceImg2.getGreen(x, y);
                }else{
                    rGREEN = 0;
                }

                if(sourceImg2.getBlue(x, y) > 0){
                    rBLUE = sourceImg1.getBlue(x, y) / sourceImg2.getBlue(x, y);
                }else{
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyDivide(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * divide pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //divide
                rRED = sourceImg1.getRed(x, y) / C;
                rGREEN = sourceImg1.getGreen(x, y) / C;
                rBLUE = sourceImg1.getBlue(x, y) / C;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyAnd(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalAND pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logical AND the RGB components of the two source image
                rRED = sourceImg1.getRed(x, y) & sourceImg2.getRed(x, y);
                rGREEN = sourceImg1.getGreen(x, y) & sourceImg2.getGreen(x, y);
                rBLUE = sourceImg1.getBlue(x, y) & sourceImg2.getBlue(x, y);

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyAnd(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalAND pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //LogicalAND the RGB components of the two source image
                rRED = sourceImg1.getRed(x, y) & C;
                rGREEN = sourceImg1.getGreen(x, y) & C;
                rBLUE = sourceImg1.getBlue(x, y) & C;

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyNand(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalNAND pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalNAND the RGB components of the two source image
                rRED = ~(sourceImg1.getRed(x, y) & sourceImg2.getRed(x, y));
                rGREEN = ~(sourceImg1.getGreen(x, y) & sourceImg2.getGreen(x, y));
                rBLUE = ~(sourceImg1.getBlue(x, y) & sourceImg2.getBlue(x, y));

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyNand(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalNAND pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalNAND the RGB components of the two source image
                rRED = ~(sourceImg1.getRed(x, y) & C);
                rGREEN = ~(sourceImg1.getGreen(x, y) & C);
                rBLUE = ~(sourceImg1.getBlue(x, y) & C);

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyNor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalNOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalNOR the RGB components of the two source image
                rRED = ~(sourceImg1.getRed(x, y) | sourceImg2.getRed(x, y));
                rGREEN = ~(sourceImg1.getGreen(x, y) | sourceImg2.getGreen(x, y));
                rBLUE = ~(sourceImg1.getBlue(x, y) | sourceImg2.getBlue(x, y));

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    public void applyNor(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalNOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalNOR the RGB components of the two source image
                rRED = ~(sourceImg1.getRed(x, y) | C);
                rGREEN = ~(sourceImg1.getGreen(x, y) | C);
                rBLUE = ~(sourceImg1.getBlue(x, y) | C);

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyOr(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalOR pixels
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //logicalOR the RGB components of the two source image
                rRED = sourceImg1.getRed(x, y) | sourceImg2.getRed(x, y);
                rGREEN = sourceImg1.getGreen(x, y) | sourceImg2.getGreen(x, y);
                rBLUE = sourceImg1.getBlue(x, y) | sourceImg2.getBlue(x, y);

                if (rRED > 255) {
                    rRED = 255;
                } else if (rRED < 0) {
                    rRED = 0;
                }

                if (rGREEN > 255) {
                    rGREEN = 255;
                } else if (rGREEN < 0) {
                    rGREEN = 0;
                }

                if (rBLUE > 255) {
                    rBLUE = 255;
                } else if (rBLUE < 0) {
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    public void applyOr(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalOR the RGB components of the two source image
                rRED = sourceImg1.getRed(x, y) | C;
                rGREEN = sourceImg1.getGreen(x, y) | C;
                rBLUE = sourceImg1.getBlue(x, y) | C;

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyXnor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalXNOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalXNOR the RGB components of the two source image
                rRED = ~(sourceImg1.getRed(x, y) ^ sourceImg2.getRed(x, y));
                rGREEN = ~(sourceImg1.getGreen(x, y) ^ sourceImg2.getGreen(x, y));
                rBLUE = ~(sourceImg1.getBlue(x, y) ^ sourceImg2.getBlue(x, y));

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    public void applyXnor(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalXNOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalXNOR the RGB components of the two source image
                rRED = ~(sourceImg1.getRed(x, y) ^ C);
                rGREEN = ~(sourceImg1.getGreen(x, y) ^ C);
                rBLUE = ~(sourceImg1.getBlue(x, y) ^ C);

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyXor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalXOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalXOR the RGB components of the two source image
                rRED = sourceImg1.getRed(x, y) ^ sourceImg2.getRed(x, y);
                rGREEN = sourceImg1.getGreen(x, y) ^ sourceImg2.getGreen(x, y);
                rBLUE = sourceImg1.getBlue(x, y) ^ sourceImg2.getBlue(x, y);

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    public void applyXor(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int rRED, rGREEN, rBLUE;

        /**
         * logicalXOR pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //logicalXOR the RGB components of the two source image
                rRED = sourceImg1.getRed(x, y) ^ C;
                rGREEN = sourceImg1.getGreen(x, y) ^ C;
                rBLUE = sourceImg1.getBlue(x, y) ^ C;

                if(rRED>255){
                    rRED = 255;
                }else if(rRED<0){
                    rRED = 0;
                }

                if(rGREEN>255){
                    rGREEN = 255;
                }else if(rGREEN<0){
                    rGREEN = 0;
                }

                if(rBLUE>255){
                    rBLUE = 255;
                }else if(rBLUE<0){
                    rBLUE = 0;
                }

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applyMul(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int pRED, pGREEN, pBLUE, rRED, rGREEN, rBLUE;

        /**
         * multiply pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //multiply the RGB components of the two source image
                pRED = sourceImg1.getRed(x, y) * sourceImg2.getRed(x, y);
                pGREEN = sourceImg1.getGreen(x, y) * sourceImg2.getGreen(x, y);
                pBLUE = sourceImg1.getBlue(x, y) * sourceImg2.getBlue(x, y);

                //find result
                rRED = (pRED>255)?255:pRED;
                rGREEN = (pGREEN>255)?255:pGREEN;
                rBLUE = (pBLUE>255)?255:pBLUE;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    public void applyMul(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int pRED, pGREEN, pBLUE, rRED, rGREEN, rBLUE;

        /**
         * multiply pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //multiply the RGB components of the two source image
                pRED = sourceImg1.getRed(x, y) * C;
                pGREEN = sourceImg1.getGreen(x, y) * C;
                pBLUE = sourceImg1.getBlue(x, y) * C;

                //find result
                rRED = (pRED>255)?255:pRED;
                rGREEN = (pGREEN>255)?255:pGREEN;
                rBLUE = (pBLUE>255)?255:pBLUE;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
    public void applySub(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int pRED, pGREEN, pBLUE, rRED, rGREEN, rBLUE;

        /**
         * subtract pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //subtract the RGB components of the two source image
                pRED = Math.abs(sourceImg1.getRed(x, y) - sourceImg2.getRed(x, y));
                pGREEN = Math.abs(sourceImg1.getGreen(x, y) - sourceImg2.getGreen(x, y));
                pBLUE = Math.abs(sourceImg1.getBlue(x, y) - sourceImg2.getBlue(x, y));

                //find result
                rRED = (pRED<0)?0:pRED;
                rGREEN = (pGREEN<0)?0:pGREEN;
                rBLUE = (pBLUE<0)?0:pBLUE;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }

    public void applySub(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int pRED, pGREEN, pBLUE, rRED, rGREEN, rBLUE;

        /**
         * subtract pixels
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //subtract the RGB components of the two source image
                pRED = Math.abs(sourceImg1.getRed(x, y) - C);
                pGREEN = Math.abs(sourceImg1.getGreen(x, y) - C);
                pBLUE = Math.abs(sourceImg1.getBlue(x, y) - C);

                //find result
                rRED = (pRED<0)?0:pRED;
                rGREEN = (pGREEN<0)?0:pGREEN;
                rBLUE = (pBLUE<0)?0:pBLUE;

                //save result
                resultImg.setPixel(x, y, 255, rRED, rGREEN, rBLUE);
            }
        }
    }
}
