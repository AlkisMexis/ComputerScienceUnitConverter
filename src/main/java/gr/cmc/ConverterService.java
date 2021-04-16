package gr.cmc;

import java.math.BigDecimal;

public class ConverterService {

    private static final BigDecimal byteConversionValueBD = new BigDecimal(1024);
    private static final BigDecimal genericConversionValueBD = new BigDecimal(1000);
    private static final BigDecimal singleByteValueBD = new BigDecimal(8);
    private static final BigDecimal minutesConversionValueBD = new BigDecimal(60);
    private static final BigDecimal hoursConversionValueBD = new BigDecimal(120);

    // Don't let anyone instantiate this class.
    private ConverterService() {
    }

    public static double convert(double numberToBeConverted, GenericMeasurement from, GenericMeasurement to) {
        // Checking if it's generic conversion or not
        boolean isGenericConversion = false;
        if (!(from instanceof DigitalMeasurement && to instanceof DigitalMeasurement)) {
            isGenericConversion = true;
        }

        // Setting initial variables
        BigDecimal bigDecimalToBeConverted = BigDecimal.valueOf(numberToBeConverted);

        int distance = calculateDistance(from, to);

        if (isGenericConversion) {
            return useGenericConverter(bigDecimalToBeConverted, distance).doubleValue();
        } else {
            return useByteConverter(bigDecimalToBeConverted, distance, (DigitalMeasurement) from, (DigitalMeasurement) to).doubleValue();
        }
    }

    private static BigDecimal useByteConverter(BigDecimal numberToBeConvertedBD, int distance, DigitalMeasurement from, DigitalMeasurement to) {
        // If the conversion ends or begins from/to bit
        boolean isBitsConversion = false;

        if (from.getPosition() == 1 || to.getPosition() == 1) {
            isBitsConversion = true;
        }

        return calculateDigitalMeasurement(numberToBeConvertedBD, isBitsConversion, distance);
    }

    private static BigDecimal useMinutesConverter(BigDecimal numberToBeConvertedBD, int distance, NetworkSpeedMeasurement from, NetworkSpeedMeasurement to) {
        boolean itsMinutesConversion = false;

        if (from.getPosition() == 5) {
            itsMinutesConversion = true;
        }
        return numberToBeConvertedBD;
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

    private static int calculateDistance(GenericMeasurement from, GenericMeasurement to) {
        int startingPosition = from.getPosition();
        int endingPosition = to.getPosition();
        return startingPosition - endingPosition;
    }

    private static BigDecimal useGenericConverter(BigDecimal numberToBeConverted, int distance) {
        if (distance > 0) {
            for (int i = 0; i < distance; i++) {
                numberToBeConverted = numberToBeConverted.multiply(genericConversionValueBD);
            }
        } else if (distance < 0) {
            for (int i = 0; i > distance; i--) {
                numberToBeConverted = numberToBeConverted.divide(genericConversionValueBD);
            }
        }
        return numberToBeConverted;
    }
}
