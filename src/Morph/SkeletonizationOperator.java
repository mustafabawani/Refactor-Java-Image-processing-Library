package Morph;

import imageFX.MyImage;

public class SkeletonizationOperator {
    public static void binaryImage(MyImage img) {
        int[][] MASKS = {
                {0, 0, 0, 2, 1, 2, 1, 1, 1},
                {0, 2, 1, 0, 1, 1, 0, 2, 1},
                {1, 1, 1, 2, 1, 2, 0, 0, 0},
                {1, 2, 0, 1, 1, 0, 1, 2, 0},
                {2, 0, 0, 1, 1, 0, 2, 1, 2},
                {0, 0, 2, 0, 1, 1, 2, 1, 2},
                {2, 1, 2, 0, 1, 1, 0, 0, 2},
                {2, 1, 2, 1, 1, 0, 2, 0, 0}
        };
        MyImage tmpImg;
        int count = 0;

        do {
            tmpImg = new MyImage(img);

            for (int[] mask : MASKS) {
                Thinning.binaryImage(img, mask, 3);
            }

            count++;
            System.out.println("Skeletonization() Loop Executed: " + count + " times.");
        } while (!img.isEqual(tmpImg));
    }
}
