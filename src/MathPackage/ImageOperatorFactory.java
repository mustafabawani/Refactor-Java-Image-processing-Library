package MathPackage;

public class ImageOperatorFactory {
    public ImageOperation createOperator(String operatorType, float blendRatio) {
        if (operatorType.equals("Add")) {
            return new AddOperation();
        } else if (operatorType.equals("Blend")) {
            return new BlendOperation(blendRatio);
        } else {
            throw new IllegalArgumentException("Invalid operator type: " + operatorType);
        }
    }
}
