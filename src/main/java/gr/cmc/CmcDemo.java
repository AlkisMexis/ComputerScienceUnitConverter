package gr.cmc;

public class CmcDemo {
    // todo: try and implement ping conversion, check if variable names are okay, etc.
    public static void main(String[] args) {
        double number = 5;

        ConverterService.convert(number, DigitalMeasurement.KILOBYTE, DigitalMeasurement.MEGABYTE);

        // Byte conversion
        double byteResult1 = ConverterService.convert(number, DigitalMeasurement.KILOBYTE, DigitalMeasurement.MEGABYTE);
        double byteResult2 = ConverterService.convert(number, DigitalMeasurement.MEGABYTE, DigitalMeasurement.KILOBYTE);
        System.out.println(byteResult1);
        System.out.println(byteResult2);


        //Generic conversion
        double genericResult1 = ConverterService.convert(number, FrequencyMeasurement.GIGAHERTZ, FrequencyMeasurement.MEGAHERTZ);
        double genericResult2 = ConverterService.convert(number, ResolutionMeasurement.MEGAPIXEL, ResolutionMeasurement.GIGAPIXEL);
        System.out.println(genericResult1);
        System.out.println(genericResult2);
    }
}
