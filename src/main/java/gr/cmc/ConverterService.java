package gr.cmc;

import java.math.BigDecimal;

public class ConverterService {

    public static BigDecimal convertBytes(double numberToBeConverted, DigitalMeasurement from, DigitalMeasurement to) {
        BigDecimal convertedNumberBD = new BigDecimal(numberToBeConverted);
        int conversionValue = 1024;
        BigDecimal conversionValueBD = new BigDecimal(conversionValue);
        int byteValue = 8;
        BigDecimal byteValueBD = new BigDecimal(byteValue);
        boolean isBitsConversion = false;

        int startingPosition = from.getPosition();
        int endingPosition = to.getPosition();
        int distance = startingPosition - endingPosition;

        if (startingPosition == 1 || endingPosition == 1) {
            isBitsConversion = true;
        }


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
}
