package gr.cmc.enumer;

import gr.cmc.GenericMeasurement;
import gr.cmc.Measurement;

public enum ResolutionMeasurement implements Measurement, GenericMeasurement {
    PIXEL(1),
    KILOPIXEL(2),
    MEGAPIXEL(3),
    GIGAPIXEL(4),
    TERAPIXEL(5);

    private final int position;

    ResolutionMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {

        return position;
    }
}

