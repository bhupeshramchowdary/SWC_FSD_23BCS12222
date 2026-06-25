class HardwareLockException extends Exception {
    public HardwareLockException(String message) {
        super(message);
    }
}

class SensorCorruptionException extends RuntimeException {
    public SensorCorruptionException(String message) {
        super(message);
    }
}

class TelemetryStream implements AutoCloseable {

    public void readData() throws HardwareLockException {
        System.out.println("Reading telemetry data...");

        // Uncomment any one to test exceptions

        // throw new HardwareLockException("Hardware is locked.");
        // throw new SensorCorruptionException("Sensor data is corrupted.");
    }

    @Override
    public void close() {
        System.out.println("Telemetry stream closed.");
    }
}

public class Main {
    public static void main(String[] args) {

        try (TelemetryStream stream = new TelemetryStream()) {

            stream.readData();
            System.out.println("Telemetry processed successfully.");

        } catch (HardwareLockException e) {

            System.out.println("Checked Exception: " + e.getMessage());

        } catch (SensorCorruptionException e) {

            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }
}
