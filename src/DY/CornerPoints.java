package DY;

import imageFX.MyImage;
import Morph.HitMissOperator;
import MathPackage.*;



public class CornerPoints {

        /**
         * This method will find the corner points of a binary image using hit-miss morphological technique.
         *
         * @param img The image on which corner points detection operation is performed
         * @return Binary Image having only corner points.
         */
        public static void binaryImage(MyImage img){

            /**
             * The 2D mask array has three types of values.
             * 0 for BLACK i.e., BACKGROUND
             * 1 for WHITE i.e., FOREGROUND
             * 2 for DON'T CARE
             *
             * How it works:
             * To find the corner points we perform the hit-miss operation 4 times on the image img
             * using 4 different mask separately.
             * Then we perform LogicalOR operation on the 4 images to get the final result.
             */

            int[][] masks = {
                    {2,1,2,0,1,1,0,0,2},
                    {2,1,2,1,1,0,2,0,0},
                    {2,0,0,1,1,0,2,1,2},
                    {0,0,2,0,1,1,2,1,2},
            };
            // perform hit miss on all 4 masks
            MyImage[] images = new MyImage[masks.length];
            for (int i = 0; i < masks.length; i++) {
                images[i] = new MyImage(img);
                HitMissOperator.binaryImage(images[i], masks[i]);
            }
            //LogicalOR the 4 images
            ColorImage colorImageOperations= (ColorImage) ImageOperatorFactory.createOperator("color");
            colorImageOperations.applyOr(images[0], images[1], img);
            colorImageOperations.applyOr(images[0], images[1], img);
            colorImageOperations.applyOr(images[0], images[1], img);
        }
}//class ends here
