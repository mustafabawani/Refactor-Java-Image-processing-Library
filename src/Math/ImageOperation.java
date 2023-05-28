package MathPackage;

import imageFX.MyImage;

public interface ImageOperation {
    void applyAdd(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);
    void applyAdd(MyImage sourceImg1, int C, MyImage resultImg);

    void applyBlend(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg, float blendRatio);

    void applyDivide(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyDivide(MyImage sourceImg1, int C, MyImage resultImg);

    void applyAnd(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyAnd(MyImage sourceImg1, int C, MyImage resultImg);

    void applyNand(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyNand(MyImage sourceImg1, int C, MyImage resultImg);

    void applyNor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyNor(MyImage sourceImg1, int C, MyImage resultImg);

    void applyOr(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyOr(MyImage sourceImg1, int C, MyImage resultImg);

    void applyXnor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyXnor(MyImage sourceImg1, int C, MyImage resultImg);

    void applyXor(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyXor(MyImage sourceImg1, int C, MyImage resultImg);

    void applyMul(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applyMul(MyImage sourceImg1, int C, MyImage resultImg);

    void applySub(MyImage sourceImg1, MyImage sourceImg2, MyImage resultImg);

    void applySub(MyImage sourceImg1, int C, MyImage resultImg);


}

