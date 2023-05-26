package Mask;

public class Circle extends Shape{
    ///////////////////////////// CIRCLE ///////////////////////////////////////

    /**
     * This will return a square mask with circumference of the circle set to 1.
     *
     * @param diameter diameter of the circle. [An odd integer like 9, 11, 13 etc]
     * @return 2D mask
     */
    public int[] draw(int diameter)
    {
        int radius = diameter/2;
        int mask[] = new int[diameter * diameter];
        int x = 0, y = radius, p = 1 - radius;
        int cx = diameter/2, cy = diameter/2;

        while(x<=y){
            //draw circumference of the circle circle
            mask[(cx+x)+(cy+y)*diameter] = 1;
            mask[(cx-x)+(cy+y)*diameter] = 1;
            mask[(cx+x)+(cy-y)*diameter] = 1;
            mask[(cx-x)+(cy-y)*diameter] = 1;
            mask[(cx+y)+(cy+x)*diameter] = 1;
            mask[(cx-y)+(cy+x)*diameter] = 1;
            mask[(cx+y)+(cy-x)*diameter] = 1;
            mask[(cx-y)+(cy-x)*diameter] = 1;

            x++;
            if(p<0){
                p+=2*x+1;
            }else{
                y--;
                p+=2*(x-y)+1;
            }
        }
        return mask;
    }
    /**
     * This will return a square mask with circle filled with 1.
     *
     * @param diameter diameter of the circle. [An odd integer like 9, 11, 13...]
     * @return 2D mask
     */
    public int[] fill(int diameter)
    {
        int radius = diameter/2;
        int cx = diameter/2, cy = diameter/2;

        //draw circle
        int mask[] = draw(diameter);

        //fill circle
        floodFill(diameter, diameter, cx, cy, 0, 1,mask);

        return mask;
    }
}
