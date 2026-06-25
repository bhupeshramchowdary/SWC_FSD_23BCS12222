abstract class SmartDevice {
    protected String deviceId;
    protected String deviceName;

    public SmartDevice(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public abstract void runDiagnostic();
}

interface BatteryOperated {
    int getBatteryLevel();
    void triggerRechargeAlert();
}

class SmartLight extends SmartDevice {

    public SmartLight(String deviceId, String deviceName) {
        super(deviceId, deviceName);
    }

    @Override
    public void runDiagnostic() {
        System.out.println(deviceName + ": Light diagnostic completed.");
    }
}

class SmartCamera extends SmartDevice implements BatteryOperated {
    private int batteryLevel;

    public SmartCamera(String deviceId, String deviceName, int batteryLevel) {
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println(deviceName + ": Camera diagnostic completed.");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void triggerRechargeAlert() {
        System.out.println(deviceName + ": Battery low! Recharge required.");
    }
}

class SmartLock extends SmartDevice implements BatteryOperated {
    private int batteryLevel;

    public SmartLock(String deviceId, String deviceName, int batteryLevel) {
        super(deviceId, deviceName);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void runDiagnostic() {
        System.out.println(deviceName + ": Lock diagnostic completed.");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void triggerRechargeAlert() {
        System.out.println(deviceName + ": Battery low! Recharge required.");
    }
}

class HomeHub {

    public void executeNightlyRoutine(SmartDevice[] devices) {

        for (SmartDevice device : devices) {

            device.runDiagnostic();

            if (device instanceof BatteryOperated) {
                BatteryOperated batteryDevice = (BatteryOperated) device;

                if (batteryDevice.getBatteryLevel() < 20) {
                    batteryDevice.triggerRechargeAlert();
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        SmartDevice[] devices = {
                new SmartLight("L101", "Living Room Light"),
                new SmartCamera("C201", "Front Door Camera", 15),
                new SmartLock("S301", "Main Door Lock", 45)
        };

        HomeHub hub = new HomeHub();
        hub.executeNightlyRoutine(devices);
    }
}
