package gr.cmc.enumer;

import gr.cmc.Measurement;

public enum NetworkSpeedMeasurement implements Measurement {

    MILLISECONDS(1),
    SECONDS(2),
    MINUTES(3),
    HOURS(4);

    private final int position;

    NetworkSpeedMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
