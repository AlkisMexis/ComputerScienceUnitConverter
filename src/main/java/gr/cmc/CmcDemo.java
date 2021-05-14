package gr.cmc;

public class CmcDemo {
    // todo: try and implement ping conversion, check if variable names are okay, etc.
    public static void main(String[] args) {

        // double number = Double.parseDouble(args[0]);

        double number = 5;


        System.out.println(DigitalMeasurement.KILOBYTE.getClass());

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

        //Time conversion
        double genericResult3 = ConverterService.convert(1, NetworkSpeedMeasurement.HOURS, NetworkSpeedMeasurement.MILLISECONDS);
        System.out.println(genericResult3);

        //bits per second conversion
        double genericResult4 = ConverterService.convert(number, UploadandDownloadSpeedMeasurement.bps, UploadandDownloadSpeedMeasurement.mbps);
        System.out.println(genericResult4);

        // Error on purpose
        double randomResult = ConverterService.convert(number, FrequencyMeasurement.GIGAHERTZ, ResolutionMeasurement.MEGAPIXEL);
        System.out.println(randomResult);
    }
}
