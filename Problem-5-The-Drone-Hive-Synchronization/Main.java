import java.util.concurrent.atomic.AtomicInteger;

class DroneHive {
    private AtomicInteger totalDronesReturned = new AtomicInteger(0);
    private volatile boolean emergencyAbort = false;

    public void droneReturned() {
        totalDronesReturned.incrementAndGet();
    }

    public int getTotalDronesReturned() {
        return totalDronesReturned.get();
    }

    public void detectStorm() {
        emergencyAbort = true;
    }

    public boolean isEmergencyAbort() {
        return emergencyAbort;
    }
}

public class Main {
    public static void main(String[] args) {

        DroneHive hive = new DroneHive();

        for (int i = 1; i <= 10; i++) {
            hive.droneReturned();
        }

        System.out.println("Total Drones Returned: " + hive.getTotalDronesReturned());

        hive.detectStorm();

        if (hive.isEmergencyAbort()) {
            System.out.println("Emergency Abort Activated!");
        } else {
            System.out.println("No Emergency.");
        }
    }
}
