package Morph;
import imageFX.MyImage;
public class Thinning {

        /**
         * This method will perform thinning operation on the binary image.
         *
         * @param img The binary image on which thinning is performed.
         * @param mask The mask used for thinning. [Mask is a 2D matrix stored in 1D array]
         * @param maskSize The size of the mask. [No. of rows in the 2D mask matrix]
         */
        public static void binaryImage(MyImage img, int mask[], int maskSize){
            /**
             * How it works:
             * If we consider an image I and a mask M, then thinning T can be expressed as:
             * T(I,M) = I - HitMiss(I,M)
             */
            MyImage tmp = new MyImage(img);
            HitMiss.binaryImage(tmp, mask, maskSize);
            Subtract.binaryImage(img, tmp, img);
        }
}
