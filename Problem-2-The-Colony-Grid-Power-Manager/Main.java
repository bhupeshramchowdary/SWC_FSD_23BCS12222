class PowerManager {
    private byte sectorStates = 0;

    public void turnOnSector(int sectorIndex) {
        sectorStates = (byte) (sectorStates | (1 << sectorIndex));
    }

    public void turnOffSector(int sectorIndex) {
        sectorStates = (byte) (sectorStates & ~(1 << sectorIndex));
    }

    public boolean isSectorOn(int sectorIndex) {
        return (sectorStates & (1 << sectorIndex)) != 0;
    }

    public void displayStates() {
        System.out.print("Sector States: ");
        for (int i = 7; i >= 0; i--) {
            System.out.print(((sectorStates >> i) & 1) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        PowerManager manager = new PowerManager();

        manager.turnOnSector(0);
        manager.turnOnSector(3);
        manager.turnOnSector(5);

        manager.displayStates();

        System.out.println("Sector 3 ON: " + manager.isSectorOn(3));
        System.out.println("Sector 4 ON: " + manager.isSectorOn(4));

        manager.turnOffSector(3);

        manager.displayStates();
    }
}
