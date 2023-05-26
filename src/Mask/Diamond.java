package Mask;

public class Diamond extends Shape{
    /**
     * This will return a square mask having diamond shape set to 1.
     *
     * @param width The width of the square mask. [An odd integer like 9, 11, 13 etc]
     * @return 2D mask
     */
    public int[] draw(int width)
    {
        int mask[] = new int[width * width];
        int x = 0, y = width/2;
        int cx = width/2, cy = width/2;

        while(x<=y){
            //draw diamond
            mask[(cx+x)+(cy+y)*width] = 1;
            mask[(cx-x)+(cy+y)*width] = 1;
            mask[(cx+x)+(cy-y)*width] = 1;
            mask[(cx-x)+(cy-y)*width] = 1;
            mask[(cx+y)+(cy+x)*width] = 1;
            mask[(cx-y)+(cy+x)*width] = 1;
            mask[(cx+y)+(cy-x)*width] = 1;
            mask[(cx-y)+(cy-x)*width] = 1;

            x++;
            y--;
        }
        return mask;
    }
    public int[] fill(int width)
    {
        int cx = width/2, cy = width/2;

        //draw diamond
        int [] mask = draw(width);

        //fill diamond
        floodFill(width, width, cx, cy, 0, 1,mask);

        return mask;
    }
    /**
     * This will return a square mask with of diamond shape with corner filled with 1.
     *
     * @param width The width of the square mask. [An odd integer like 9, 11, 13...]
     * @return 2D mask
     */
    public int[] fillDiamondCorners(int width){
        int cx = width/2, cy = width/2;

        //draw diamond
        int[] mask = draw(width);

        //fill diamond
        floodFill(width, width, cx, cy, 0, 1,mask);

        //invert
        for(int y = 0; y < width; y++){
            for(int x = 0; x < width; x++){
                mask[x+y*width] = (mask[x+y*width]==1)?0:1;
            }
        }

        return mask;
    }
}
