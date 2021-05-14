package gr.cmc.enumer;

import gr.cmc.GenericMeasurement;
import gr.cmc.Measurement;

public enum FrequencyMeasurement implements Measurement, GenericMeasurement {
    HERTZ(1),
    KILOHERTZ(2),
    MEGAHERTZ(3),
    GIGAHERTZ(4),
    TERAHERTZ(5);

    private final int position;

    FrequencyMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}

