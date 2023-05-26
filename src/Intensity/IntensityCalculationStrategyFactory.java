package Intensity;

public class IntensityCalculationStrategyFactory {
    public static IntensityCalculationStrategy createStrategy(String type) {
        return switch (type) {
            case "grayscale" -> new GrayscaleIntensityCalculationStrategy();
            case "red" -> new RedIntensityCalculationStrategy();
            case "green" -> new GreenIntensityCalculationStrategy();
            case "blue" -> new BlueIntensityCalculationStrategy();
            default -> throw new IllegalArgumentException("Invalid intensity calculation strategy type.");
        };
    }
}
