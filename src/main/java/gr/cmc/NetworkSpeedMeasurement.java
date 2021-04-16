package gr.cmc;

public enum NetworkSpeedMeasurement implements GenericMeasurement {

    MILLISECONDS(1),
    KILLOSECONDS(2),
    DECISECONDS(3),
    SECONDS(4),
    MINUTES(5),
    HOURS(6);

    private final int position;

    NetworkSpeedMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
