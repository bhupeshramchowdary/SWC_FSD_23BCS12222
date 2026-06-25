enum DoorState {
    OPEN,
    CLOSED,
    LOCKED
}

class IllegalStateTransitionException extends RuntimeException {
    public IllegalStateTransitionException(String message) {
        super(message);
    }
}

class VaultDoor {
    private DoorState state;

    public VaultDoor() {
        state = DoorState.OPEN;
    }

    public void closeDoor() {
        if (state == DoorState.OPEN) {
            state = DoorState.CLOSED;
            System.out.println("Door closed.");
        } else {
            System.out.println("Door cannot be closed.");
        }
    }

    public void lockDoor() {
        if (state == DoorState.CLOSED) {
            state = DoorState.LOCKED;
            System.out.println("Door locked.");
        } else {
            throw new IllegalStateTransitionException(
                "Cannot lock an open door. Close it first."
            );
        }
    }

    public void unlockDoor() {
        if (state == DoorState.LOCKED) {
            state = DoorState.CLOSED;
            System.out.println("Door unlocked.");
        } else {
            System.out.println("Door is not locked.");
        }
    }

    public void showState() {
        System.out.println("Current State: " + state);
    }
}

public class Main {
    public static void main(String[] args) {

        VaultDoor door = new VaultDoor();

        door.showState();

        door.closeDoor();
        door.showState();

        door.lockDoor();
        door.showState();

        door.unlockDoor();
        door.showState();
    }
}
