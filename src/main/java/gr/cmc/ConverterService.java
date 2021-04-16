package gr.cmc;

import java.math.BigDecimal;

public class ConverterService {

    // Digital Measurement
    private static final BigDecimal byteConversionValueBD = new BigDecimal(1024);
    private static final BigDecimal singleByteValueBD = new BigDecimal(8);

    // Generic Measurement
    private static final BigDecimal genericConversionValueBD = new BigDecimal(1000);

    // Time Measurement
    private static final BigDecimal timeConversionValueBD = new BigDecimal(60);

    // Don't let anyone instantiate this class.
    private ConverterService() {
    }

    public static double convert(double numberToBeConverted, Measurement from, Measurement to) {
        // If both instances are not of same type, then stop the execution of the method and return 0
        // For example, if conversion is from pixels to hertz, the program should return 0
        if (!(from.getClass().equals(to.getClass()))) {
            return 0;
        }

        // Setting initial variables
        BigDecimal bigDecimalToBeConverted = BigDecimal.valueOf(numberToBeConverted);
        int distance = calculateDistance(from, to);

        if (from instanceof GenericMeasurement) {
            return useGenericConverter(bigDecimalToBeConverted, distance).doubleValue();
        } else if (from instanceof DigitalMeasurement) {
            return useByteConverter(bigDecimalToBeConverted, distance, (DigitalMeasurement) from, (DigitalMeasurement) to).doubleValue();
        } else if (from instanceof NetworkSpeedMeasurement) {
            return useNetworkSpeedConverter(bigDecimalToBeConverted, distance, (NetworkSpeedMeasurement) from, (NetworkSpeedMeasurement) to).doubleValue();
        }
        return 0;
    }

    private static BigDecimal useByteConverter(BigDecimal numberToBeConvertedBD, int distance, DigitalMeasurement from, DigitalMeasurement to) {
        // If the conversion ends or begins from/to bit
        boolean isBitsConversion = false;

        if (from.getPosition() == 1 || to.getPosition() == 1) {
            isBitsConversion = true;
        }

        return calculateDigitalMeasurement(numberToBeConvertedBD, isBitsConversion, distance);
    }

    private static BigDecimal useNetworkSpeedConverter(BigDecimal numberToBeConvertedBD, int distance, NetworkSpeedMeasurement from, NetworkSpeedMeasurement to) {
        boolean isMillisecondsConversion = false;

        if (from.getPosition() == 1 || to.getPosition() == 1) {
            isMillisecondsConversion = true;
        }
        return calculateNetworkSpeedMeasurement(numberToBeConvertedBD, isMillisecondsConversion, distance);
    }

    private static BigDecimal calculateNetworkSpeedMeasurement(BigDecimal convertedNumberBD, boolean isMillisecondsConversion, int distance) {
        if (distance > 0) {
            if (isMillisecondsConversion) {
                convertedNumberBD = convertedNumberBD.multiply(genericConversionValueBD);
                distance--;
            }
            for (int i = 0; i < distance; i++) {
                convertedNumberBD = convertedNumberBD.multiply(timeConversionValueBD);
            }
        } else if (distance < 0) {
            if (isMillisecondsConversion) {
                convertedNumberBD = convertedNumberBD.divide(genericConversionValueBD);
                distance++;
            }
            for (int i = 0; i > distance; i--) {
                convertedNumberBD = convertedNumberBD.divide(timeConversionValueBD);
            }
        }
        return convertedNumberBD;
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

    private static int calculateDistance(Measurement from, Measurement to) {
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
