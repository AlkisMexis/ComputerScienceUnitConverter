package gr.cmc;

public enum GenericMeasurement {
    HERTZ(1),
    KILOHERTZ(2),
    MEGAHERTZ(3),
    GIGAHERTZ(4),
    TERAHERTZ(5),
    PIXEL(6),
    KILOPIXEL(7),
    MEGAPIXEL(8),
    GIGAPIXEL(9),
    TERAPIXEL(10);

    private final int position;

    GenericMeasurement(int position) {

        this.position = position;
    }

    public int getPosition() {

        return position;
    }
}
