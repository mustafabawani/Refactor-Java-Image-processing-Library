package Mask;

abstract class Shape {
    public abstract int[] draw(int diameter);
    public abstract int[] fill(int diameter);
    ///////////////////////////// FLOOD FILL ///////////////////////////////////

    /**
     * This method will floodfill the image.
     *
     * @param width the width of the image
     * @param height the height of the image
     * @param cx x coordinate of the center of the image
     * @param cy y coordinate of the center of the image
     * @param oldColor the color to be replaced
     * @param newColor the color that will replace the oldColor
     */
    public void floodFill(int width, int height, int cx, int cy, int oldColor, int newColor,int[] mask){
        if(cx<0 || cx>=width || cy<0 || cy>=height){
            return;
        }

        if(mask[cx+cy*width] == oldColor){
            mask[cx+cy*width] = newColor;
            floodFill(width, height, cx+1, cy,   oldColor, newColor, mask);
            floodFill(width, height, cx,   cy+1, oldColor, newColor, mask);
            floodFill(width, height, cx-1, cy,   oldColor, newColor, mask);
            floodFill(width, height, cx,   cy-1, oldColor, newColor, mask);
        }
    }
}
