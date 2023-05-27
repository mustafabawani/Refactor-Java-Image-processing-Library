package MathPackage;
import imageFX.MyImage;

public class GrayScale implements  ImageOperation {
    public void applyAdd(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();
        int p, result;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                p = sourceImg1.getBlue(x, y) + sourceImg2.getBlue(x, y);
                result = (p > 255) ? 255 : p;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    @Override
    public void applyAdd(MyImage sourceImg1, int C, MyImage resultImg) {
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();
        int p, result;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                p = sourceImg1.getBlue(x, y) + C;
                result = (p > 255) ? 255 : p;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyBlend(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg, float blendRatio) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * blend pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = (int) ((blendRatio * sourceImg1.getBlue(x, y)) + ((1 - blendRatio) * sourceImg2.getBlue(x, y)));
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyDivide(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * divide pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (sourceImg2.getBlue(x, y) > 0) {
                    result = sourceImg1.getBlue(x, y) / sourceImg2.getBlue(x, y);
                } else {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyDivide(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * divide pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) / C;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyAnd(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalAND pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) & sourceImg2.getBlue(x, y);
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyAnd(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalAND pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) & C;
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyNand(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalNAND pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = ~(sourceImg1.getBlue(x, y) & sourceImg2.getBlue(x, y));
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyNand(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalNAND pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = ~(sourceImg1.getBlue(x, y) & C);
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyNor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalNOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = ~(sourceImg1.getBlue(x, y) | sourceImg2.getBlue(x, y));
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyNor(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalNOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = ~(sourceImg1.getBlue(x, y) | C);
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyOr(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) | sourceImg2.getBlue(x, y);
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }

    }

    public void applyOr(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) | C;
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyXnor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalXNOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = ~(sourceImg1.getBlue(x, y) ^ sourceImg2.getBlue(x, y));
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyXnor(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalXNOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = ~(sourceImg1.getBlue(x, y) ^ C);
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyXor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg) {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalXOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) ^ sourceImg2.getBlue(x, y);
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyXor(MyImage sourceImg1, int C, MyImage resultImg) {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int result;

        /**
         * logicalXOR pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result = sourceImg1.getBlue(x, y) ^ C;
                if (result > 255) {
                    result = 255;
                } else if (result < 0) {
                    result = 0;
                }
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyMul(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int p, result;

        /**
         * multiply pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                p = sourceImg1.getBlue(x, y) * sourceImg2.getBlue(x, y);
                result = (p>255)?255:p;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applyMul(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int p, result;

        /**
         * multiplication pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                p = sourceImg1.getBlue(x, y) * C;
                result = (p>255)?255:p;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }
    public void applySub(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg)
    {
        //image dimension - common for all the three images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int p, result;

        /**
         * subtract pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                p = Math.abs(sourceImg1.getBlue(x, y) - sourceImg2.getBlue(x, y));
                result = (p<0)?0:p;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }

    public void applySub(MyImage sourceImg1, int C, MyImage resultImg)
    {
        //image dimension - common for the two images
        int width = sourceImg1.getImageWidth();
        int height = sourceImg1.getImageHeight();

        //variable
        int p, result;

        /**
         * subtract pixels
         * Grayscale image will have same value for RGB so take any one component.
         */
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                p = Math.abs(sourceImg1.getBlue(x, y) - C);
                result = (p<0)?0:p;
                resultImg.setPixel(x, y, 255, result, result, result);
            }
        }
    }
}
