package gr.cmc;

public enum DigitalMeasurement {
    BIT(1),
    BYTE(2),
    KILOBYTE(3),
    MEGABYTE(4),
    GIGABYTE(5),
    TERABYTE(6),
    PETABYTE(7),
    EXABYTE(8);

    private final int position;

    DigitalMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
