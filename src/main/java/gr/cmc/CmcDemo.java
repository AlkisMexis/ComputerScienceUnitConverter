package gr.cmc;

import java.math.BigDecimal;

public class CmcDemo {
    public static void main(String[] args) {
        double number = 5;

        BigDecimal result1 = ConverterService.convertBytes(number, DigitalMeasurement.KILOBYTE, DigitalMeasurement.MEGABYTE);
        BigDecimal result2 = ConverterService.convertBytes(number, DigitalMeasurement.MEGABYTE, DigitalMeasurement.KILOBYTE);
        System.out.println(result1.doubleValue());
        System.out.println(result2.doubleValue());
    }
}
