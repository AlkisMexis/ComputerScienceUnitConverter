package gr.cmc;

public enum UploadandDownloadSpeedMeasurement implements Measurement, GenericMeasurement {

    bps(1),
    kbps(2),
    mbps(3),
    gbps(4),
    tbps(5);

    public final int position;

    UploadandDownloadSpeedMeasurement(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
