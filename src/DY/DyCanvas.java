package DY;
import imageFX.MyImage;
public class DyCanvas {

    /**
     * This method will replace the text area with the image that is placed beneath it.
     * This function takes two images. One is the photo image and the other is the text
     * image. The text image has a white background and a text message written in black color.
     * The text image is placed on top of the photo image. This function will replace the
     * text pixels of the text image with the photo pixels of the photo image that is
     * beneath it.
     *
     * @param textImg The image object that holds the text message image.
     * @param photoImg The image object that holds the photo image.
     */

    public static void Layer_pictureText(MyImage textImg, MyImage photoImg){
        //test image dimension
        int tWidth = textImg.getImageWidth();
        int tHeight = textImg.getImageHeight();

        //photo image dimension
        int pWidth = photoImg.getImageWidth();
        int pHeight = photoImg.getImageHeight();
        int pTotalPixel = photoImg.getImageTotalPixels();

        for(int y = 0; y < tHeight; y++){
            for(int x = 0; x < tWidth; x++){
                //get text image RGB value
                int r = textImg.getRed(x, y);
                int g = textImg.getGreen(x, y);
                int b = textImg.getBlue(x, y);

                //check whether pixel is not WHITE
                if(r != 255 || g != 255 || b != 255){
                    if((x+y*pWidth)<= pTotalPixel){
                        //photo image exists below text image. take photo image RGB value
                        r = photoImg.getRed(x, y);
                        g = photoImg.getGreen(x, y);
                        b = photoImg.getBlue(x, y);

                        //set photo image pixel value to text image pixel value
                        textImg.setPixel(x, y, 255, r, g, b);
                    }
                }
            }
        }
        }
}
