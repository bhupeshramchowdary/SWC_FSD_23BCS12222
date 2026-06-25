abstract class DeliveryDrone {
    String droneId;

    public DeliveryDrone(String droneId) {
        this.droneId = droneId;
    }

    public abstract void deliverPackage();
}

interface Airborne {
    void flyToDestination();

    default void requestAirTrafficClearance() {
        System.out.println("Air traffic clearance granted.");
    }
}

interface GroundBased {
    void navigateSidewalks();
}

class Quadcopter extends DeliveryDrone implements Airborne {

    public Quadcopter(String droneId) {
        super(droneId);
    }

    @Override
    public void flyToDestination() {
        System.out.println("Quadcopter is flying to destination.");
    }

    @Override
    public void deliverPackage() {
        requestAirTrafficClearance();
        flyToDestination();
        System.out.println("Package delivered by Quadcopter.");
    }
}

class CityRover extends DeliveryDrone implements GroundBased {

    public CityRover(String droneId) {
        super(droneId);
    }

    @Override
    public void navigateSidewalks() {
        System.out.println("City Rover is navigating sidewalks.");
    }

    @Override
    public void deliverPackage() {
        navigateSidewalks();
        System.out.println("Package delivered by City Rover.");
    }
}

class HybridVTOL extends DeliveryDrone implements Airborne, GroundBased {

    public HybridVTOL(String droneId) {
        super(droneId);
    }

    @Override
    public void flyToDestination() {
        System.out.println("Hybrid VTOL is flying.");
    }

    @Override
    public void navigateSidewalks() {
        System.out.println("Hybrid VTOL is moving on the ground.");
    }

    @Override
    public void deliverPackage() {
        requestAirTrafficClearance();
        flyToDestination();
        navigateSidewalks();
        System.out.println("Package delivered by Hybrid VTOL.");
    }
}

public class Main {
    public static void main(String[] args) {

        DeliveryDrone[] drones = {
            new Quadcopter("Q101"),
            new CityRover("R201"),
            new HybridVTOL("H301")
        };

        for (DeliveryDrone drone : drones) {
            drone.deliverPackage();
            System.out.println();
        }
    }
}
