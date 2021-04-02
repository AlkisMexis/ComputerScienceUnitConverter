package gr.cmc;

import java.math.BigDecimal;

public class CmcDemo {
    public static void main(String[] args) {
        double number = 5;

        // Byte conversion
        BigDecimal byteResult1 = ConverterService.convertBytes(number, DigitalMeasurement.KILOBYTE, DigitalMeasurement.MEGABYTE);
        BigDecimal byteResult2 = ConverterService.convertBytes(number, DigitalMeasurement.MEGABYTE, DigitalMeasurement.KILOBYTE);
        System.out.println(byteResult1.doubleValue());
        System.out.println(byteResult2.doubleValue());

        // Pixel conversion
        BigDecimal bigDecimal = ConverterService.convertPixels(number);
        System.out.println(bigDecimal.doubleValue());
    }
}
