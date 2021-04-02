package gr.cmc;

import java.math.BigDecimal;

public class ConverterService {

    private static final BigDecimal byteConversionValueBD = new BigDecimal(1024);
    private static final BigDecimal singleByteValueBD = new BigDecimal(8);


    public static BigDecimal convertBytes(double numberToBeConverted, DigitalMeasurement from, DigitalMeasurement to) {
        // Setting our initial variables
        BigDecimal bigDecimalToBeConverted = new BigDecimal(numberToBeConverted);
        // If the conversion ends or begins from/to bit
        boolean isBitsConversion = false;

        int distance = calculateDistance(from, to);

        if (from.getPosition() == 1 || to.getPosition() == 1) {
            isBitsConversion = true;
        }

        return calculateDigitalMeasurement(bigDecimalToBeConverted, isBitsConversion, distance);
    }

    private static BigDecimal calculateDigitalMeasurement(BigDecimal convertedNumberBD, boolean isBitsConversion, int distance) {
        if (distance > 0) {
            if (isBitsConversion) {
                convertedNumberBD = convertedNumberBD.multiply(singleByteValueBD);
                distance--;
            }
            for (int i = 0; i < distance; i++) {
                convertedNumberBD = convertedNumberBD.multiply(byteConversionValueBD);
            }
        } else if (distance < 0) {
            if (isBitsConversion) {
                convertedNumberBD = convertedNumberBD.divide(singleByteValueBD);
                distance++;
            }
            for (int i = 0; i > distance; i--) {
                convertedNumberBD = convertedNumberBD.divide(byteConversionValueBD);
            }
        }
        return convertedNumberBD;
    }

    //todo: finish method by adding enumeration parameters
    public static BigDecimal convertPixels(double numberToBeConverted) {
        // Setting our initial variables
        BigDecimal bigDecimalToBeConverted = new BigDecimal(numberToBeConverted);
        // Setting the conversion value from unit to unit:
        BigDecimal conversionValueBD = new BigDecimal(1000);
        int distance = 2;
        //int distance = calculateDistance(from, to);

        return useGenericConverter(bigDecimalToBeConverted, distance, conversionValueBD);
    }

    private static int calculateDistance(DigitalMeasurement from, DigitalMeasurement to) {
        int startingPosition = from.getPosition();
        int endingPosition = to.getPosition();
        return startingPosition - endingPosition;
    }

    private static BigDecimal useGenericConverter(BigDecimal convertedNumberBD,
                                                  int distance,
                                                  BigDecimal genericConversionValueBD) {
        if (distance > 0) {
            for (int i = 0; i < distance; i++) {
                convertedNumberBD = convertedNumberBD.multiply(genericConversionValueBD);
            }
        } else if (distance < 0) {
            for (int i = 0; i > distance; i--) {
                convertedNumberBD = convertedNumberBD.divide(genericConversionValueBD);
            }
        }
        return convertedNumberBD;
    }
}
