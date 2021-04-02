package gr.cmc;

import java.math.BigDecimal;

public class ConverterService {

    private static final BigDecimal conversionValueBD = new BigDecimal(1024);
    private static final BigDecimal byteValueBD = new BigDecimal(8);


    public static BigDecimal convertBytes(double numberToBeConverted, DigitalMeasurement from, DigitalMeasurement to) {
        // Setting our initial variables
        BigDecimal bigDecimalToBeConverted = new BigDecimal(numberToBeConverted);
        // If the conversion ends or begins from/to bit
        boolean isBitsConversion = false;

        int distance = calculateDistance(from, to);

        if (from.getPosition() == 1 || to.getPosition() == 1) {
            isBitsConversion = true;
        }

        return convert(bigDecimalToBeConverted, isBitsConversion, distance);
    }

    private static BigDecimal convert(BigDecimal convertedNumberBD, boolean isBitsConversion, int distance) {
        if (distance > 0) {
            if (isBitsConversion) {
                convertedNumberBD = convertedNumberBD.multiply(byteValueBD);
                distance--;
            }
            for (int i = 0; i < distance; i++) {
                convertedNumberBD = convertedNumberBD.multiply(conversionValueBD);
            }
        } else if (distance < 0) {
            if (isBitsConversion) {
                convertedNumberBD = convertedNumberBD.divide(byteValueBD);
                distance++;
            }
            for (int i = 0; i > distance; i--) {
                convertedNumberBD = convertedNumberBD.divide(conversionValueBD);
            }
        }
        return convertedNumberBD;
    }

    public void HellofromAlkis() {
        System.out.println("gg");

    }
    private static int calculateDistance(DigitalMeasurement from, DigitalMeasurement to) {
        int startingPosition = from.getPosition();
        int endingPosition = to.getPosition();
        return startingPosition - endingPosition;
    }
}
