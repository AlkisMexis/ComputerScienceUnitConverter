package gr.cmc;

public enum FrameDisplayMeasurement {
    HERTZ(1),
    KILOHERTZ(2),
    MEGAHERTZ(3),
    GIGAHERTZ(4),
    TERAHERTZ(5);

    private final int position;

    FrameDisplayMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}

