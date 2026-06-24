abstract class SpaceVessel {
    short shipId;          // max 30000
    boolean operational;   // true or false
    char fleetClass;       // A, B, C

    SpaceVessel(short shipId, boolean operational, char fleetClass) {
        this.shipId = shipId;
        this.operational = operational;
        this.fleetClass = fleetClass;
    }
}

class MiningShip extends SpaceVessel {
    float[][] cargoHold;   // ore weights

    MiningShip(short shipId, boolean operational, char fleetClass, float[][] cargoHold) {
        super(shipId, operational, fleetClass);
        this.cargoHold = cargoHold;
    }

    public float calculateTotalOreWeight() {
        float total = 0;

        for (int i = 0; i < cargoHold.length; i++) {
            for (int j = 0; j < cargoHold[i].length; j++) {
                total += cargoHold[i][j];
            }
        }

        return total;
    }

    public float findHeaviestContainer() {
        float max = cargoHold[0][0];

        for (int i = 0; i < cargoHold.length; i++) {
            for (int j = 0; j < cargoHold[i].length; j++) {
                if (cargoHold[i][j] > max) {
                    max = cargoHold[i][j];
                }
            }
        }

        return max;
    }
}

public class Main {
    public static void main(String[] args) {

        float[][] cargo = {
                {1200.5f, 3400.8f},
                {5600.2f, 4200.6f},
                {8900.1f, 1500.3f}
        };

        SpaceVessel[] fleet = new SpaceVessel[1];

        fleet[0] = new MiningShip((short)1001, true, 'A', cargo);

        MiningShip ship = (MiningShip) fleet[0];

        System.out.println("Total Ore Weight: " + ship.calculateTotalOreWeight() + " kg");
        System.out.println("Heaviest Container: " + ship.findHeaviestContainer() + " kg");
    }
}
